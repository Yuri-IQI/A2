package com.a2.lethargy.dtos;

import java.util.List;

import com.a2.lethargy.models.Author;

import jakarta.validation.constraints.NotNull;

public record DescriptionDto(
		@NotNull String name,
		@NotNull String descriptionContent,
		@NotNull Author author,
		@NotNull List<String> topics
		) {

}
