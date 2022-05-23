package com.alkemy.geoicons.app.repositories;

import com.alkemy.geoicons.app.entities.CountryEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Long>, JpaSpecificationExecutor<CountryEntity> {

    //defino interfaz propia con Specification
    List<CountryEntity> findAll(Specification<CountryEntity> spec);

}
