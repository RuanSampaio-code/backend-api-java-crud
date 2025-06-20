package br.com.crudspring.dto.mapper;

import br.com.crudspring.dto.CourseDTO;
import br.com.crudspring.model.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }
       return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getCategory(),
                course.getStatus()
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
        course.setCategory(courseDTO.category());
        course.setStatus("Ativo");
        return course;
    }
}
