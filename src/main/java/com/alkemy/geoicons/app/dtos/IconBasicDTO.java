package com.alkemy.geoicons.app.dtos;

import com.alkemy.geoicons.app.entities.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class IconBasicDTO {

    private Long id;
    private String image;
    private String name;

}
