package com.a2.informational.services;

import org.apache.kafka.common.errors.InterruptException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DescriptionService {
	
	@Cacheable(value = "products", key = "#id")
	public String getProductById(Long id) {
		simulateSlowService();
		return "Product-" + id;
	}
	
	private void simulateSlowService() {
        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
	}
}
