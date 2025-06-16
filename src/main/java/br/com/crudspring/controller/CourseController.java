package br.com.crudspring.controller;

import br.com.crudspring.model.Course;
import br.com.crudspring.repository.CourseRepository;
import br.com.crudspring.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public @ResponseBody ResponseEntity<List<Course>> listar(){
        return courseService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> buscarPorId(@PathVariable @NotNull @Positive Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Course> cadastrar(@RequestBody @Valid Course course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> atualizar (@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {

        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NotNull @Positive Long id) {
        return courseService.delete(id);
    }


}
