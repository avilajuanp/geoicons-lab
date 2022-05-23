package com.alkemy.geoicons.app.services.impl;

import com.alkemy.geoicons.app.dtos.IconDTO;
import com.alkemy.geoicons.app.entities.IconEntity;
import com.alkemy.geoicons.app.mappers.IconMapper;
import com.alkemy.geoicons.app.repositories.IconRepository;
import com.alkemy.geoicons.app.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired //anotación para que Spring me traiga mi Mapper y Repository para trabajar
    private IconMapper iconMapper;
    @Autowired
    private IconRepository iconRepository;
    //@Autowired
    //private IconSpecification iconSpecification;

    //método para guardar mi ícono
    public IconDTO save(IconDTO dto) {

        //convierto a Entity para poder guardarlo en DB
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        //envío a Repository para guardarlo y recupero la entidad ya guardada
        IconEntity entitySaved = iconRepository.save(entity);
        //Mapeo de vuelta el entitySaved a DTO para enviar al Service
        IconDTO dtoSaved = iconMapper.iconEntity2DTO(entitySaved, true);

        return dtoSaved;
    }
    //metodo para recuperar todos los paises desde DB
    public List<IconDTO> getAllIcons() {

        //creo lista de Entidades traída de la DB
        List<IconEntity> entities = iconRepository.findAll();
        //transformo a DTO para devolver al Service
        List<IconDTO> dtos = iconMapper.iconEntityList2DTOList(entities, true);

        return dtos;
    }

    public IconDTO getIconById(Long id) {
        //creo Entidad traída de la DB
        IconEntity entity = iconRepository.getById(id);

        /*
        //manejo de error de Id inválido
        if (!entity.isPresent()){
            throw new ParamNotFound("Id de país no válido.")
        }
        */

        //transformo a DTO para devolver al Service
        IconDTO dto = iconMapper.iconEntity2DTO(entity, true);

        return dto;
    }

    public List<IconDTO> getByFilters(String name, LocalDate creationDate, Long CountryId) {
        /*
        //creo nuevo DTO de filtrado
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, continent, order);
        //genero lista entity con las coincidencias de la especificación del filtrado
        List<IconEntity> entities = iconRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        */
        return null;
    }

    @Modifying
    public IconDTO update(Long id, IconDTO dto) {

        //convierto a entity para update en BD
        IconEntity entity = iconRepository.getById(id);

        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setHeight(dto.getHeight());
        entity.setHistory(dto.getHistory());
        entity.setCountries(dto.getCountries());

        //envío a Mapper para actualizar y recupero la entidad ya editada y persistida
        IconEntity entityUpdated = iconRepository.save(entity);

        //Mapeo de vuelta el entitySaved a DTO para enviar al Service
        IconDTO dtoUpdated = iconMapper.iconEntity2DTO(entityUpdated,true);

        return dtoUpdated;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

}
