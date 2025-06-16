package br.com.crudspring.repository;

import br.com.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Custom query methods can be defined here if needed
    // For example:
    // List<Course> findByCategory(String category);
}
