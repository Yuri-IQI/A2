package com.a2.informational.config.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a2.informational.models.MessageEntity;

@Repository
public interface MessageDao {
	boolean saveMessage(MessageEntity message);

	List<MessageEntity> fetchAllMessages();
}
