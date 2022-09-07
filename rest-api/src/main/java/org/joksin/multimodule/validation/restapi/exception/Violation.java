package org.joksin.multimodule.validation.restapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Violation {

    private final String fieldName;
    private final String message;

}
