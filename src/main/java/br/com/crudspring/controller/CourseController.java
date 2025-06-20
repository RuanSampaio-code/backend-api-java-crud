package br.com.crudspring.controller;

import br.com.crudspring.dto.CourseDTO;
import br.com.crudspring.dto.mapper.CourseMapper;
import br.com.crudspring.model.Course;
import br.com.crudspring.repository.CourseRepository;
import br.com.crudspring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping
    public @ResponseBody List<CourseDTO> listar(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public CourseDTO buscarPorId(@PathVariable @NotNull @Positive Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO cadastrar(@RequestBody @Valid CourseDTO course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public CourseDTO atualizar (@PathVariable @NotNull @Positive Long id, @RequestBody @Valid CourseDTO course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable @NotNull @Positive Long id) {
        courseService.delete(id);
    }
}