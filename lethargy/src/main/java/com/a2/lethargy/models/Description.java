package com.a2.lethargy.models;

import java.io.Serializable;

public class Description implements Serializable{

	private long id;
	private String name;
	private String content;
	
	public Description(long id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
