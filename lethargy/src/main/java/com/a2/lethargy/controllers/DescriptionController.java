package com.a2.lethargy.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.a2.lethargy.dtos.DescriptionDto;
import com.a2.lethargy.models.Description;
import com.a2.lethargy.services.DescriptionService;

@RestController
@RequestMapping("/description")
public class DescriptionController {
	
	private final DescriptionService descriptionService;
	
	public DescriptionController(DescriptionService descriptionService) {
		this.descriptionService = descriptionService;
	}
	
	@PostMapping()
	public ResponseEntity<Description> createDescription(@Validated @RequestBody DescriptionDto desc) {
		Description description = descriptionService.saveDescription(desc);
		return new ResponseEntity<>(description, HttpStatus.CREATED);
	}
	
	@GetMapping("/{key}")
	public ResponseEntity<List<Object>> getAllDescriptions(@RequestParam String key) {
		return new ResponseEntity<>(descriptionService.getAllDescriptions(key), HttpStatus.OK);
	}
}
