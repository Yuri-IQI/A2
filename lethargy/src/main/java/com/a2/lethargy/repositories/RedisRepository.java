package com.a2.lethargy.repositories;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.ListOperations;
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
	
    public List<Object> getAll(String key) {
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        return listOps.range(key, 0, -1);
    }
	
	public void delete(String key) {
		redisTemplate.delete(key);
	}
}
