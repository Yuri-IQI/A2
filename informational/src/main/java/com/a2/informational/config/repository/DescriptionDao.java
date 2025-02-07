package com.a2.informational.config.repository;

import org.springframework.stereotype.Repository;

import com.a2.informational.models.Description;

@Repository
public interface DescriptionDao {
	boolean saveDescription(Description description);
}
