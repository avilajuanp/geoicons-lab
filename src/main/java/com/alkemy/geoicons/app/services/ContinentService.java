package com.alkemy.geoicons.app.services;

import com.alkemy.geoicons.app.dtos.ContinentDTO;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    //método para guardar mi continente
    public ContinentDTO save(ContinentDTO dto) {
        //todo código de guardar continente

        System.out.println("GUARDAR CONTINENTE");

        return dto;
    }
}
