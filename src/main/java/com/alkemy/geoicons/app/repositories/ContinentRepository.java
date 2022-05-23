package com.alkemy.geoicons.app.repositories;

import com.alkemy.geoicons.app.entities.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<ContinentEntity,Long> {
}
