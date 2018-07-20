package com.omerta.rabbitproducer.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omerta.rabbitproducer.config.RabbitMQConfig;

@Component
public class MessageProducer {

	private static final Logger logger=LoggerFactory.getLogger(MessageProducer.class);
	
	 @Autowired
	 RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String msg) {
		logger.info("Sending MSG:"+ msg +" at "+ new Date().toString());
		rabbitTemplate.convertAndSend(RabbitMQConfig.ROUTING_KEY, msg);
		logger.info("is Listener Returned:::"+rabbitTemplate.isReturnListener());
		logger.info("MSG:"+ msg +" sent at "+ new Date().toString());
		
		
	}
}
