package org.joksin.multimodule.validation.restapi.exception;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleConstraintValidationException(ConstraintViolationException ex) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            validationErrorResponse.getViolations().add(Violation.of(getFieldName(violation), violation.getMessage()));
        }
        return ResponseEntity.badRequest().body(validationErrorResponse);
    }

    private String getFieldName(ConstraintViolation<?> violation) {
        return ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
    }

}
