package com.a2.lethargy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.a2.lethargy.dtos.DescriptionDto;
import com.a2.lethargy.models.Description;
import com.a2.lethargy.repositories.RedisRepository;

@Service
public class DescriptionService {

	private final RedisRepository redisRepository;
	
	public DescriptionService(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}
	
    public Description saveDescription(DescriptionDto desc) {
        String authorKey = desc.author().getName();
        List<Object> descriptions = redisRepository.getAll(authorKey);

        Description description;
        
        if (descriptions == null || descriptions.isEmpty()) {
            description = new Description(1L, desc.name(), desc.descriptionContent());
        } else {
            Description lastDescription = (Description) descriptions.getLast();
            description = new Description(lastDescription.getId() + 1, desc.name(), desc.descriptionContent());
        }

        redisRepository.save(authorKey, description, 10);
        return description;
    }
    
    public List<Object> getAllDescriptions(String key) {
    	return redisRepository.getAll(key);
    }
}
