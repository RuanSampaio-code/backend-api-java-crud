package br.com.crudspring.enums.converters;

import br.com.crudspring.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true) // This will apply the converter automatically to all entities using Status
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

       return Stream.of(Status.values())
               .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }



}
