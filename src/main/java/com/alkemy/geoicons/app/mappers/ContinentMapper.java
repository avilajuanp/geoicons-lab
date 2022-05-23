package com.alkemy.geoicons.app.mappers;

import com.alkemy.geoicons.app.dtos.ContinentDTO;
import com.alkemy.geoicons.app.entities.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    //defino metodo que recibe DTO y devuelve una entidad. Utilizo MAppers para limpiar Service y reutilizar el codigo
    //El controller SIEMPRE maneja DTOs!
    public ContinentEntity continentDTO2Entity(ContinentDTO dto){

        ContinentEntity continentEntity = new ContinentEntity();
        continentEntity.setImage(dto.getImage());
        continentEntity.setName(dto.getName());

        return continentEntity;
    }

    //operación inversa a la anterior
    public ContinentDTO continentEntity2DTO(ContinentEntity entity){

        ContinentDTO dto = new ContinentDTO();
        //OJO acá ya tengo que devolver el ID
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());

        return dto;
    }

    public List<ContinentDTO> continentEntityList2DTOList(List<ContinentEntity> entities) {

        List<ContinentDTO> dtos = new ArrayList<>();
        //itero sobre la lista de entidades para transformar a DTO
        for (ContinentEntity entity : entities){
            dtos.add(continentEntity2DTO(entity));
        }

        return dtos;
    }
}
