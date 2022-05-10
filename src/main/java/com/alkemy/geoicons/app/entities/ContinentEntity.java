package com.alkemy.geoicons.app.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

// Entity tagea la clase como Entidad, Table crea la tabla en MySQL, Getter y Setter me ahorran crear los metodos
@Entity
@Table(name= "continent")
@Getter
@Setter

public class ContinentEntity {

    //asigno variable como PK, y se genera secuencialmente
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;
    private String name;
}
