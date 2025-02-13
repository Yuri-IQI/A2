package com.a2.informational.kafka;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.a2.informational.dtos.TopicDto;

@Service
public class TopicsProducer {
	
	private KafkaTemplate<String, List<TopicDto>> kafkaTemplate;
	
	public TopicsProducer(KafkaTemplate<String, List<TopicDto>> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void forwardTopic(List<TopicDto> topics) {
		kafkaTemplate.send("topics-mapping", topics);
	}
}
