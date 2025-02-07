package com.a2.informational.models;

import java.io.Serializable;
import java.util.List;

public class Description implements Serializable {
	
	private Long id;
	
	private String referredObject;
	
	private String shortDescription;
	
	private String fullDescription;
	
	private boolean isActive;
	
	private List<String> relatedTopics;
	
	private List<String> sources;

	public Description(Long id, String referredObject, String shortDescription, String fullDescription,
			boolean isActive, List<String> relatedTopics, List<String> sources) {
		this.id = id;
		this.referredObject = referredObject;
		this.shortDescription = shortDescription;
		this.fullDescription = fullDescription;
		this.isActive = isActive;
		this.relatedTopics = relatedTopics;
		this.sources = sources;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferredObject() {
		return referredObject;
	}

	public void setReferredObject(String referredObject) {
		this.referredObject = referredObject;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<String> getRelatedTopics() {
		return relatedTopics;
	}

	public void setRelatedTopics(List<String> relatedTopics) {
		this.relatedTopics = relatedTopics;
	}

	public List<String> getSources() {
		return sources;
	}

	public void setSources(List<String> sources) {
		this.sources = sources;
	}
	
}
