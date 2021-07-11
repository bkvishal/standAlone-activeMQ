package com.activemqstandalone.standalone_activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

/**
 * @author : Vishal Srivastava
 * @Date : 11-07-2021
 **/

@Configuration
@EnableJms
public class activeMqConfig {

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    // this is the queue which is going to be created in ActiveMQ
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("standAlone.queue");
    }

    // setting the connection factory because we are using standalone activeMQ that's why we need to pass broker_url
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(brokerUrl);
        return factory;
    }

    //now because of stand alone activeMQ jmstemplate need to be configured.
    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(activeMQConnectionFactory());
    }

}
