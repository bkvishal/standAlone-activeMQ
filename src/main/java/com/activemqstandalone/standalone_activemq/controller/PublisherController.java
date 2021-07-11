package com.activemqstandalone.standalone_activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * @author : Vishal Srivastava
 * @Date : 11-07-2021
 **/


@RestController
@RequestMapping(value = "/rest")
public class PublisherController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping(value = "/msg/{message}")
    public String publishMsg(@PathVariable("message") String message) {
        jmsTemplate.convertAndSend(queue, message);

        return "producer produce successfully";

    }
}
