package br.com.crudspring;

import br.com.crudspring.model.Course;
import br.com.crudspring.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CourseRepository courseRepository) {
		return args -> {
			// This method can be used to initialize data or perform startup tasks
			Course course1 = new Course();
			course1.setName("Spring Boot Basics");
			course1.setCategory("Fullstack");
			courseRepository.save(course1);
		};
	}
}
