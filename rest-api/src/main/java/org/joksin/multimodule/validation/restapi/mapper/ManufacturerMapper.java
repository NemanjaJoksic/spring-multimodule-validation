package org.joksin.multimodule.validation.restapi.mapper;

import org.joksin.multimodule.validation.core.model.Country;
import org.joksin.multimodule.validation.core.model.Manufacturer;
import org.joksin.multimodule.validation.restapi.dto.CountryDTO;
import org.joksin.multimodule.validation.restapi.dto.ManufacturerDTO;

public class ManufacturerMapper {

    public static ManufacturerDTO toDTO(Manufacturer manufacturer) {
        return ManufacturerDTO.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .country(buildCountryDTO(manufacturer.getCountry()))
                .build();
    }

    private static CountryDTO buildCountryDTO(Country country) {
        return CountryDTO.builder()
                .id(country.getId())
                .name(country.getName())
                .isoCode(country.getIsoCode())
                .build();
    }

}
