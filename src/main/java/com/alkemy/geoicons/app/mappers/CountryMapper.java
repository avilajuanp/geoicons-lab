package com.alkemy.geoicons.app.mappers;

import com.alkemy.geoicons.app.dtos.CountryBasicDTO;
import com.alkemy.geoicons.app.dtos.CountryDTO;
import com.alkemy.geoicons.app.dtos.IconDTO;
import com.alkemy.geoicons.app.entities.CountryEntity;
import com.alkemy.geoicons.app.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CountryMapper {

/*
    @Autowired
    private IconMapper iconMapper;
    @Autowired
    CountryRepository countryRepository;
*/
    //defino metodo que recibe DTO y devuelve una entidad. Utilizo MAppers para limpiar Service y reutilizar el codigo
    //El controller SIEMPRE maneja DTOs!
    public CountryEntity countryDTO2Entity(CountryDTO dto) {

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setImage(dto.getImage());
        countryEntity.setName(dto.getName());
        countryEntity.setPopulation(dto.getPopulation());
        countryEntity.setArea(dto.getArea());
        countryEntity.setContinent(dto.getContinent());
        countryEntity.setContinentId(dto.getContinentId());
        countryEntity.setIcons(dto.getIcons());

        return countryEntity;
    }

    //operación inversa a la anterior, AGREGO CODIGO PARA EVITAR EL LOOP DE CARGA DE PAISES-ICONOS
    public CountryDTO countryEntity2DTO(CountryEntity entity, boolean loadIcons) {

        CountryDTO dto = new CountryDTO();
        //OJO acá ya tengo que devolver el ID
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setPopulation(entity.getPopulation());
        dto.setArea(entity.getArea());
        dto.setContinent(entity.getContinent());
        dto.setContinentId(entity.getContinentId());
        /*if (loadIcons){
            List<IconDTO> iconDTOS = iconMapper.iconEntityList2DTOList(entity.getIcons(),false);
            dto.setIcons(iconDTOS);
        }*/

        return dto;
    }

    //metodo para mapear lista de entidades a lista de DTO
    public List<CountryDTO> countryEntityList2DTOList(List<CountryEntity> entities, boolean loadIcons) {

        List<CountryDTO> dtos = new ArrayList<>();
        //itero sobre la lista de entidades para transformar a DTO
        for (CountryEntity entity : entities) {
            dtos.add(countryEntity2DTO(entity, loadIcons));
        }

        return dtos;
    }

    //metodo para mapear lista de entidades a lista de BasicDTO
    public List<CountryBasicDTO> countryEntityList2BasicDTOList (Collection<CountryEntity> entities){

        List<CountryBasicDTO> dtos = new ArrayList<>();
        CountryBasicDTO basicDTO = new CountryBasicDTO();

        for (CountryEntity entity : entities) {
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setName(entity.getName());
            basicDTO.setPopulation(entity.getPopulation());
            dtos.add(basicDTO);
        }

        return dtos;
    }
/*

    public CountryEntity countryEntityUpdate(CountryEntity entity) {
         //genero Entity y actualizo campos
        CountryEntity entityUpd = new CountryEntity();

        entityUpd.setImage(entity.getImage());
        entityUpd.setName(entity.getName());
        entityUpd.setPopulation(entity.getPopulation());
        entityUpd.setArea(entity.getArea());
        entityUpd.setContinent(entity.getContinent());
        entityUpd.setContinentId(entity.getContinentId());
        entityUpd.setIcons(entity.getIcons());

        return entityUpd;
    }
*/

}
