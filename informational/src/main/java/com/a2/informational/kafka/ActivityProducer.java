package com.a2.informational.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.a2.informational.dtos.ActivityDto;

@Service
public class ActivityProducer {
	private KafkaTemplate<String, ActivityDto> kafkaTemplate;
	
	public ActivityProducer(KafkaTemplate<String, ActivityDto> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void forwardActivity(ActivityDto activity) {
		kafkaTemplate.send("activity-topic", activity);
	}
}
