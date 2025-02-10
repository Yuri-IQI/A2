package com.a2.informational.repositories;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
	
	private final RedisTemplate<String, Object> redisTemplate;
	
	public RedisRepository(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	public void save(String key, Object value, long expirationTime) {
		redisTemplate.opsForValue().set(key, value, expirationTime, TimeUnit.MINUTES);
	}
	
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	
	public void delete(String key) {
		redisTemplate.delete(key);
	}
}
