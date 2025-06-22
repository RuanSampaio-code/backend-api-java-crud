package br.com.crudspring.dto;

import br.com.crudspring.enums.Category;
import br.com.crudspring.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CourseDTO(
    Long id,
    @NotBlank @NotNull String name,
    @NotBlank @NotNull Category category,
    @NotBlank @NotNull Status status
) {
}
