package com.alkemy.geoicons.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// Entity tagea la clase como Entidad, Table crea la tabla en MySQL, Getter y Setter me ahorran crear los metodos
@Entity
@Table (name = "country")
@Getter
@Setter
@SQLDelete(sql = "UPDATE country SET deleted = true WHERE id=?") //cuando elimino entidad, solo hace un update para el Soft Delete
@Where(clause = "deleted=false") // diferencio los borrados de los activos cdo busco info a la DB
public class CountryEntity {

    //asigno variable como PK, y se genera secuencialmente
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;
    private String name;
    private Long population;
    private Long area; //metros cuadrados!

    /*
    muchos paises en un solo continente
    fetch y cascade para traer la info de antemano, y para q se elimine todo por si hago un delete
    JoinColumn refiere al Id de continente q vamos a usar para instanciar el objeto
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "continent_id", insertable = false, updatable = false)
    private ContinentEntity continent;

    //uso el id para guardar y actualizar en la DB
    @Column(name = "continent_id", nullable = false)
    private Long continentId;

    //Este Many to Many engloba al de Iconos, porque cuando creo un pais, ya puedo agregar los iconos
    //Muchos paises tienen muchos iconos
    //JoinTable crea la Tabla intermedia entre los N:N, con los datos necesarios para crearla
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(
            name = "icon_country",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id")
            )
    private Set<IconEntity> icons = new HashSet<>();

    private boolean deleted = false;

}
