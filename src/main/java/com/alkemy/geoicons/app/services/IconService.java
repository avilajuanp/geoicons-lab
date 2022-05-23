package com.alkemy.geoicons.app.services;

import com.alkemy.geoicons.app.dtos.IconDTO;

import java.time.LocalDate;
import java.util.List;

public interface IconService {
    
    //abstracción de métodos IconServiceImpl
    IconDTO save(IconDTO dto);

    List<IconDTO> getAllIcons();

    IconDTO getIconById(Long id);

    List<IconDTO> getByFilters(String name, LocalDate creationDate, Long CountryId);

    IconDTO update(Long id, IconDTO icon);

    void delete(Long id);
}
