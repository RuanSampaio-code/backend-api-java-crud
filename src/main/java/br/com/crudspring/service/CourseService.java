package br.com.crudspring.service;

import br.com.crudspring.dto.CourseDTO;
import br.com.crudspring.dto.mapper.CourseMapper;
import br.com.crudspring.enums.Category;
import br.com.crudspring.exception.RecordNotFoundException;
import br.com.crudspring.model.Course;
import br.com.crudspring.repository.CourseRepository;
import br.com.crudspring.exception.NotItemsFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;



@Validated
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.courseMapper = new CourseMapper();
    }

    public List<CourseDTO> list(){

        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));

    }

    public CourseDTO save(@Valid @NotNull CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update( @PathVariable @NotNull @Positive  Long id, CourseDTO course) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    // Atualiza apenas os campos necessários
                    existingCourse.setName(course.name());
                    existingCourse.setCategory(Category.FRONTEND);
                    // Outros campos que precisam ser atualizados

                    return(courseMapper.toDTO( courseRepository.save(existingCourse)));
                })
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive  Long id) {
         courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
