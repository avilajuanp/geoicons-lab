package com.alkemy.geoicons.app.dtos;

import com.alkemy.geoicons.app.entities.CountryEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class IconDTO {

    private Long id;
    private String image;
    private String name;
    private LocalDate creationDate;
    private Long height;
    private String history;
    private List<CountryEntity> countries;
}
