package com.a2.informational.config.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.a2.informational.models.Description;

@Repository
public class DescriptionDaoImpl implements DescriptionDao {

	@Autowired
	private RedisTemplate redisTemplate;
	
	private static final String KEY = "DESCRIPTION";
	
	@Override
	public boolean saveDescription(Description description) {
		try {
			redisTemplate.opsForHash().put(KEY, description.getId().toString(), description);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
