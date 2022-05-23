package com.alkemy.geoicons.app.dtos;

import com.alkemy.geoicons.app.entities.ContinentEntity;
import com.alkemy.geoicons.app.entities.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class CountryDTO {

    private Long id;
    private String image;
    private String name;
    private Long population;
    private Long area; //metros cuadrados!
    private Long continentId;
    private ContinentEntity continent;
    private Set<IconEntity> icons;
}
