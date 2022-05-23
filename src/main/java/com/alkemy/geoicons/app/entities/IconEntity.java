package com.alkemy.geoicons.app.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter @Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?") //cuando elimino entidad, solo hace un update para el Soft Delete
@Where(clause = "deleted=false") // diferencio los borrados de los activos cdo busco info a la DB
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
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.MERGE)
    private List<CountryEntity> countries = new ArrayList<>();

    //atributo boolean para el Soft Delete
    private boolean deleted = false;
}
