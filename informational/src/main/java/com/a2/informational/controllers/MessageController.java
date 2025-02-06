package com.a2.informational.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.a2.informational.config.repository.MessageDao;
import com.a2.informational.models.MessageEntity;

@RestController
public class MessageController {
	
	@Autowired
	private MessageDao messageDao;
	
	@PostMapping("/message")
	public ResponseEntity<String> saveMessage(@RequestBody MessageEntity message) {
		boolean result = messageDao.saveMessage(message);
		if(result)
			return ResponseEntity.ok("Message Archived");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/message")
	public ResponseEntity<List<MessageEntity>> fetchAllUser() {
		List<MessageEntity> messages = messageDao.fetchAllMessages();
		return ResponseEntity.ok(messages);
	}
}
