package com.a2.informational.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2.informational.dtos.ActivityDto;
import com.a2.informational.dtos.DescriptiveDto;
import com.a2.informational.kafka.ActivityProducer;
import com.a2.informational.kafka.TopicsProducer;
import com.a2.informational.models.Description;
import com.a2.informational.repositories.RedisRepository;

@RestController
@RequestMapping("/description")
public class DescriptionController {
	
	@Autowired
	private TopicsProducer topicsProducer;
	@Autowired
	private ActivityProducer activityProducer;
	
	@Autowired
	private RedisRepository redisRepository;
	
	@PostMapping("/describe")
	public ResponseEntity<ActivityDto> describe(@Validated @RequestBody DescriptiveDto descriptiveDto){
		topicsProducer.forwardTopic(descriptiveDto.relatedTopics());
		
		ActivityDto activityDto = new ActivityDto(descriptiveDto.referredObject(), descriptiveDto.author(), descriptiveDto.relatedTopics());
		activityProducer.forwardActivity(activityDto);
		
		Description description = new Description(descriptiveDto.referredObject())
		
		this.redisRepository.save(descriptiveDto.referredObject(), , 0)
		
		return new ResponseEntity<ActivityDto>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping()
	public ResponseEntity<Description description> getDescriptions() {
		
		
	}
}
