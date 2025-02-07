package com.a2.informational.dtos;

import java.util.List;

import com.a2.informational.models.Author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DescriptiveDTO(
		@NotBlank String referredObject,
		@NotNull @Size(max=60) String shortDescription,
		@NotNull String fullDescription,
		@NotNull boolean isActive,
		@NotNull Author author,
		@NotNull List<TopicDto> relatedTopics,
		@NotNull List<SourceDto> sources,
		String motivation
		) {}