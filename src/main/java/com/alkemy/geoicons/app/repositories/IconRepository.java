package com.alkemy.geoicons.app.repositories;

import com.alkemy.geoicons.app.entities.CountryEntity;
import com.alkemy.geoicons.app.entities.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository extends JpaRepository<IconEntity,Long>, JpaSpecificationExecutor<IconEntity> {

    //defino interfaz propia con Specification
    List<IconEntity> findAll(Specification<IconEntity> spec);

}
