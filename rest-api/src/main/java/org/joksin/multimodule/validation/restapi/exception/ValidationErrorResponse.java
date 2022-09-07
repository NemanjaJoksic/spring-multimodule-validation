package org.joksin.multimodule.validation.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class ValidationErrorResponse {

    private final List<Violation> violations = new LinkedList<>();

    public void addViolation(Violation violation) {
        violations.add(violation);
    }

}
