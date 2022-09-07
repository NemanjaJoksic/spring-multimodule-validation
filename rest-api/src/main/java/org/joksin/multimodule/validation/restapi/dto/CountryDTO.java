package org.joksin.multimodule.validation.restapi.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryDTO {

    private final String id;
    private final String name;
    private final String isoCode;

}
