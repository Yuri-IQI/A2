package com.a2.lethargy.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a2.lethargy.repositories.RedisRepository;

@RestController
@RequestMapping("/cache")
public class CacheController {

	private final RedisRepository redisRepository;
	
	public CacheController(RedisRepository redisRepository) {
		this.redisRepository = redisRepository;
	}
	
	@PostMapping("/{key}/{value}")
	public ResponseEntity<String> saveToCache(@PathVariable String key, @PathVariable String value) {
		redisRepository.save(key, value, 10);
		return new ResponseEntity<>("Saved to Redis", HttpStatus.CREATED);
	}
	
	@GetMapping("/{key}")
	public ResponseEntity<Object> getFromCache(@PathVariable String key) {
		return new ResponseEntity<>(redisRepository.get(key), HttpStatus.OK);
	}
	
    @DeleteMapping("/{key}")
    public ResponseEntity<String> deleteFromCache(@PathVariable String key) {
        redisRepository.delete(key);
        return new ResponseEntity<>("Deleted from Redis", HttpStatus.OK);
    }
}
