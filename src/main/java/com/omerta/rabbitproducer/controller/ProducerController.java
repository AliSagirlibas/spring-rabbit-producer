package com.omerta.rabbitproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omerta.rabbitproducer.model.MessageProducer;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	
	@Autowired
	MessageProducer messageProducer;
	
	@GetMapping
	public ResponseEntity<String> addMessage(@RequestParam String msg ) {
		
		messageProducer.sendMessage(msg);
		return ResponseEntity.ok(msg+"SENT");
	}  
}
