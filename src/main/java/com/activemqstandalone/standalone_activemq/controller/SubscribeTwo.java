package com.activemqstandalone.standalone_activemq.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : Vishal Srivastava
 * @Date : 11-07-2021
 **/

@Component
public class SubscribeTwo {

    @JmsListener(destination = "standAlone.queue")
    public void consumer2(String message) {
        System.out.println("Getting the message 22 -- " + message);
    }

}
