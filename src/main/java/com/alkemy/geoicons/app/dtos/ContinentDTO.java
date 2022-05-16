package com.alkemy.geoicons.app.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContinentDTO {

    //solo transfiere datos de una capa a otra
    private Long id;
    private String image;
    private String name;
}
