package br.com.crudspring.service;

import br.com.crudspring.model.Course;
import br.com.crudspring.repository.CourseRepository;
import br.com.crudspring.exception.NotItemsFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public ResponseEntity<List<Course>> list(){
        return ResponseEntity.ok(courseRepository.findAll());
    }

    public ResponseEntity<Course> findById(Long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
        return ResponseEntity.ok(course);
    }

    public  ResponseEntity<Course> save( Course course) {

//        if (course.getId() != null) {
//            var existingCourse = courseRepository.findById(course.getId());
////            if (existingCourse.isPresent()) {
////                throw new ResourceAlredyExistsException("Course with id " + course.getId() + " already exists.");
////            }
//        }
        return ResponseEntity.ok(courseRepository.save(course));
    }

    public ResponseEntity<Course> update(Long id, Course course) {
        return courseRepository.findById(id)
                .map(existingCourse -> {
                    // Atualiza apenas os campos necessários
                    existingCourse.setName(course.getName());
                    existingCourse.setCategory(course.getCategory());
                    // Outros campos que precisam ser atualizados

                    return ResponseEntity.ok(courseRepository.save(existingCourse));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(Long id) {
        return courseRepository.findById(id)
                .map(course -> {
                    courseRepository.delete(course);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
