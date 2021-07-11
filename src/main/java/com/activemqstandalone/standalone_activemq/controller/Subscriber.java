package com.activemqstandalone.standalone_activemq.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : Vishal Srivastava
 * @Date : 11-07-2021
 **/

@Component
public class Subscriber {

    @JmsListener(destination = "standAlone.queue")
    public void consumer(String message) {
        System.out.println("Getting the message -- " + message);
    }

}
