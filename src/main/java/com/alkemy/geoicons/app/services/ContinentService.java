package com.alkemy.geoicons.app.services;

import com.alkemy.geoicons.app.dtos.ContinentDTO;

import java.util.List;

public interface ContinentService {
    //abstracción de métodos ContinentServiceImpl
    ContinentDTO save(ContinentDTO dto);

    List<ContinentDTO> getAllContinents();
}
