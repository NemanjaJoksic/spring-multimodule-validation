package org.joksin.multimodule.validation.core.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Country {

    SERBIA(1, "Serbia", "SRB"),
    MONTENEGRO(2, "Montenegro", "MNE");

    private final Integer id;
    private final String name;
    private final String isoCode;

}
