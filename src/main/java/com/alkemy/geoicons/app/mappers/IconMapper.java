package com.alkemy.geoicons.app.mappers;

import com.alkemy.geoicons.app.dtos.IconBasicDTO;
import com.alkemy.geoicons.app.dtos.IconDTO;
import com.alkemy.geoicons.app.entities.IconEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class IconMapper {

/*
    @Autowired
    private CountryMapper countryMapper;
    @Autowired
    IconRepository iconRepository;
*/
    //defino metodo que recibe DTO y devuelve una entidad. Utilizo MAppers para limpiar Service y reutilizar el codigo
    //El controller SIEMPRE maneja DTOs!
    public IconEntity iconDTO2Entity(IconDTO dto) {

        IconEntity iconEntity = new IconEntity();

        iconEntity.setImage(dto.getImage());
        iconEntity.setName(dto.getName());
        iconEntity.setCreationDate(dto.getCreationDate());
        iconEntity.setHeight(dto.getHeight());
        iconEntity.setHistory(dto.getHistory());
        iconEntity.setCountries(dto.getCountries());
        //acá traigo a deleted?

        return iconEntity;
    }

    //operación inversa a la anterior, AGREGO CODIGO PARA EVITAR EL LOOP DE CARGA DE PAISES-ICONOS
    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadIcons) {

        IconDTO dto = new IconDTO();
        //OJO acá ya tengo que devolver el ID
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setCreationDate(entity.getCreationDate());
        dto.setHeight(entity.getHeight());
        dto.setHistory(entity.getHistory());
        dto.setCountries(entity.getCountries());
        /*if (loadIcons){
            List<IconDTO> iconDTOS = iconMapper.iconEntityList2DTOList(entity.getIcons(),false);
            dto.setIcons(iconDTOS);
        }*/

        return dto;
    }

    //metodo para mapear lista de entidades a lista de DTO
    public List<IconDTO> iconEntityList2DTOList(List<IconEntity> entities, boolean loadIcons) {

        List<IconDTO> dtos = new ArrayList<>();
        //itero sobre la lista de entidades para transformar a DTO
        for (IconEntity entity : entities) {
            dtos.add(iconEntity2DTO(entity, loadIcons));
        }

        return dtos;
    }

    //metodo para mapear lista de entidades a lista de BasicDTO
    public List<IconBasicDTO> iconEntityList2BasicDTOList (Collection<IconEntity> entities){

        List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDTO = new IconBasicDTO();

        for (IconEntity entity : entities) {
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setName(entity.getName());
            dtos.add(basicDTO);
        }

        return dtos;
    }
/*

    public IconEntity iconEntityUpdate(IconEntity entity) {
         //genero Entity y actualizo campos
        IconEntity entityUpd = new IconEntity();

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
