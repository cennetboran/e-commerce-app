package com.kodgemisi.course.ecommerce.user;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(RegistrationDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RegistrationDto dto = (RegistrationDto) target;

        if (dto.getEmail() != null && !dto.getEmail().equals(dto.getEmailConfirmation())) {
            errors.rejectValue("emailConfirmation","user.registrationDto.emailConfirmationNotEqual", "confirmation email doesn't match");
        }

    }
}
