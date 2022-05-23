package com.alkemy.geoicons.app.repositories.specifications;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.alkemy.geoicons.app.dtos.CountryFiltersDTO;
import com.alkemy.geoicons.app.entities.CountryEntity;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountrySpecification {

   /* public Specification<CountryEntity> getByFilters(CountryFiltersDTO filtersDTO){
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                                "%"+filtersDTO.getName().toLowerCase()+"%"
                        )
                );
            }

        }
    }*/
}
