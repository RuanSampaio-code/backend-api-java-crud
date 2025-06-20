package br.com.crudspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
    Long id,
    @NotBlank @NotNull String name,
    @NotBlank @NotNull String category,
    @NotBlank @NotNull String status
) {
}
