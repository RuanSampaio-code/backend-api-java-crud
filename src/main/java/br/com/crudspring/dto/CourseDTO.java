package br.com.crudspring.dto;

import br.com.crudspring.enums.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
    Long id,
    @NotBlank @NotNull String name,
    @NotBlank @NotNull String category
) {
}
