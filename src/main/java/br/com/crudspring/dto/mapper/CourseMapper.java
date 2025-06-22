package br.com.crudspring.dto.mapper;

import br.com.crudspring.dto.CourseDTO;
import br.com.crudspring.enums.Category;
import br.com.crudspring.model.Course;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
       return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getCategory().getValue()
        );
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();

        if(courseDTO == null) {
            return null;
        }
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }

        course.setName(courseDTO.name());
        course.setCategory(converterCategoryValue(courseDTO.category()));
        return course;
    }

    public Category converterCategoryValue(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }

        switch (value){
            case "Back-end":
                return Category.BACKEND;
            case "Front-end":
                return Category.FRONTEND;
            default:
                throw new IllegalArgumentException("Categoria inválida: " + value);
        }
    }
}
