package com.alkemy.geoicons.app.services.impl;

import com.alkemy.geoicons.app.dtos.ContinentDTO;
import com.alkemy.geoicons.app.entities.ContinentEntity;
import com.alkemy.geoicons.app.mappers.ContinentMapper;
import com.alkemy.geoicons.app.repositories.ContinentRepository;
import com.alkemy.geoicons.app.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired //anotación para que Spring me traiga mi Mapper y Repository para trabajar
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;

    //método para guardar mi continente
    public ContinentDTO save(ContinentDTO dto) {

        //convierto a Entity para poder guardarlo en DB
        ContinentEntity entity = continentMapper.continentDTO2Entity(dto);
        //envío a Repository para guardarlo y recupero la entidad ya guardada
        ContinentEntity entitySaved = continentRepository.save(entity);
        //Mapeo de vuelta el entitySaved a DTO para enviar al Service
        ContinentDTO dtoSaved = continentMapper.continentEntity2DTO(entitySaved);

        return dtoSaved;
    }
    //metodo para recuperar todos los conts desde DB
    public List<ContinentDTO> getAllContinents() {

        //creo lista de Entidades traida de la DB
        List<ContinentEntity> entities = continentRepository.findAll();
        //transformo a DTO para devolver al Service
        List<ContinentDTO> dtos = continentMapper.continentEntityList2DTOList(entities);

        return dtos;
    }
}
