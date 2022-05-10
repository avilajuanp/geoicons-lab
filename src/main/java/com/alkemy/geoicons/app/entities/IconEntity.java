package com.alkemy.geoicons.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter @Setter

public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;
    private String name;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "creation_date") //uso sintaxis correcta para SQL
    private LocalDate creationDate;

    private Long height;
    private String history;

    //este Many to Many es el "menor", porque cuando agrego íconos ya deberían existir los paises
    //Muchos iconos tienen muchos paises (puede haber replicas de esos iconos en otros paises)
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countries = new ArrayList<>();
}
