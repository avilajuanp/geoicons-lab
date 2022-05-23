package com.alkemy.geoicons.app.dtos;

import com.alkemy.geoicons.app.entities.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class CountryBasicDTO {

    private Long id;
    private String image;
    private String name;
    private Long population;

}
