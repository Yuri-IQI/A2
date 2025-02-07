package com.a2.informational.dtos;

import java.util.List;

import com.a2.informational.models.Author;

import jakarta.validation.constraints.NotNull;

public record ActivityDto(
		@NotNull String referredObject,
		@NotNull Author author,
		@NotNull List<TopicDto> topics
		) {}