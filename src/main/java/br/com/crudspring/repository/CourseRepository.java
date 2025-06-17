package br.com.crudspring.repository;

import br.com.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    //List<Course> findByStatus(String ativo);

    // Custom query methods can be defined here if needed
    // For example:
    // List<Course> findByCategory(String category);
}
