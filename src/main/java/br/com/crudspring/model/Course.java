package br.com.crudspring.model;

import br.com.crudspring.enums.Category;
import br.com.crudspring.enums.Status;
import br.com.crudspring.enums.converters.CategoryConverter;
import br.com.crudspring.enums.converters.StatusConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;


@Data
@Entity
@SQLDelete(sql = "UPDATE Course SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status != 'Inativo'") // This will filter out soft-deleted records
//@Table(name = "courses") // Optional: specify table name if different from class name
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotNull
    @Column(length = 20, nullable = false)
    @Convert(converter = CategoryConverter.class)
    private Category category;


    @NotNull
    @Column(length = 20, nullable = false)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ATIVO; // Default value set to "Ativo"

}
