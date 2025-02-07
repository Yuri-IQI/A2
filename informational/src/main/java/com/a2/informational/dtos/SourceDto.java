package com.a2.informational.dtos;

import jakarta.validation.constraints.NotNull;

public record SourceDto(@NotNull String name, @NotNull String sourceAuthor) {

}
