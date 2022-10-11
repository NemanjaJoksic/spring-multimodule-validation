package org.joksin.multimodule.validation.restapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.Iterator;

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
        Iterator<Path.Node> propertyPathIterator = violation.getPropertyPath().iterator();
        Path.Node leafNode = propertyPathIterator.next();
        while(propertyPathIterator.hasNext()) {
            leafNode = propertyPathIterator.next();
        }
        return leafNode.getName();
    }

}
