package br.com.crudspring.model;

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
    @NotBlank
    @Length( max = 20)
    @Pattern(regexp = "Back-end|Front-end|Fullstack", message = "Category must be Back-end, Front-end or Fullstack")
    @Column(length = 20, nullable = false)
    private String category;


    @NotNull
    @NotBlank
    @Length( max = 10)
    @Pattern(regexp = "Ativo|Inativo", message = "Category must be Ativo, Inativo")
    @Column(length = 20, nullable = false)
    private String status = "Ativo"; // Default value set to "Ativo"

}
