package org.joksin.multimodule.validation.core.repository;

import org.joksin.multimodule.validation.core.model.Country;
import org.joksin.multimodule.validation.core.model.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerRepository extends GenericRepository<Manufacturer> {

    @Override
    protected void loadInitData() {
        add(Manufacturer.builder()
                .name("Pionir")
                .country(Country.SERBIA)
                .build());

        add(Manufacturer.builder()
                .name("Kras")
                .country(Country.CROATIA)
                .build());
    }

}
