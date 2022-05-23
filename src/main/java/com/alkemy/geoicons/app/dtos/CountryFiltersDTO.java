package com.alkemy.geoicons.app.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CountryFiltersDTO {
    private String name;
    private Long continent;
    private String order;

    public CountryFiltersDTO(String name, Long continent, String order) {
        this.name = name;
        this.continent = continent;
        this.order = order;
    }

    public boolean isASC() {return this.order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC() {return this.order.compareToIgnoreCase("DESC") == 0;}
}
