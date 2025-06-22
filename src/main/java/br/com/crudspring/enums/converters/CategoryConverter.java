package br.com.crudspring.enums.converters;

import br.com.crudspring.enums.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true) // This will apply the converter automatically to all entities using Category
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        return Stream.of(Category.values())
                .filter(category -> category.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
