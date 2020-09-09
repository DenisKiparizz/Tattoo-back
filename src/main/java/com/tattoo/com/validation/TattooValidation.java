package com.tattoo.com.validation;

import com.tattoo.com.entity.interfaces.TattooInterface;
import com.tattoo.com.exception.WrongModelException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TattooValidation implements ValidatorInterface<TattooInterface> {
    private static final Integer MIN = 2;

    @Override
    public void  validate(TattooInterface tattooDto) {
        List<String> list = Arrays.asList(
                tattooDto.getPicture(),
                tattooDto.getDescription(),
                tattooDto.getPictureUrl()
        );

        list.forEach(this::checkFieldsNotNull);
        list.forEach(this::checkFieldsNotBlank);
        list.forEach(this::checkFieldsLength);
        checkPositiveId(tattooDto.getStyle().getId());
    }

    private void checkFieldsNotNull(String tattoo) {
        if (tattoo == null) {
            throw new WrongModelException("Related with null field in the Tattoo");
        }
    }

    private void checkFieldsNotBlank(String tattoo) {
        if (tattoo.isBlank()) {
            throw new WrongModelException("Related with blank field");
        }
    }

    private void checkFieldsLength(String parameter) {
        if (parameter.length() < MIN) {
            throw new WrongModelException(String.format("Length [%s] doesnt match the range: ", parameter));
        }
    }

    @Override
    public void checkPositiveId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id has to be positive");
        }
    }
}
