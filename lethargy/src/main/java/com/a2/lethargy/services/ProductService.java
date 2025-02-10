package com.a2.lethargy.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Cacheable(value = "products", key = "#id")
	public String getProductById(Long id) {
		simulateSlowService();
		return "Product-" + id;
	}
	
    private void simulateSlowService() {
        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
