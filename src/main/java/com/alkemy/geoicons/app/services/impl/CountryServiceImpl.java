package com.alkemy.geoicons.app.services.impl;

import com.alkemy.geoicons.app.dtos.CountryDTO;
import com.alkemy.geoicons.app.entities.CountryEntity;
import com.alkemy.geoicons.app.mappers.CountryMapper;
import com.alkemy.geoicons.app.repositories.CountryRepository;
import com.alkemy.geoicons.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired //anotación para que Spring me traiga mi Mapper y Repository para trabajar
    private CountryMapper countryMapper;
    @Autowired
    private CountryRepository countryRepository;
    //@Autowired
    //private CountrySpecification countrySpecification;

    //método para guardar mi país
    public CountryDTO save(CountryDTO dto) {

        //convierto a Entity para poder guardarlo en DB
        CountryEntity entity = countryMapper.countryDTO2Entity(dto);
        //envío a Repository para guardarlo y recupero la entidad ya guardada
        CountryEntity entitySaved = countryRepository.save(entity);
        //Mapeo de vuelta el entitySaved a DTO para enviar al Service
        CountryDTO dtoSaved = countryMapper.countryEntity2DTO(entitySaved, true);

        return dtoSaved;
    }
    //metodo para recuperar todos los paises desde DB
    public List<CountryDTO> getAllCountries() {

        //creo lista de Entidades traída de la DB
        List<CountryEntity> entities = countryRepository.findAll();
        //transformo a DTO para devolver al Service
        List<CountryDTO> dtos = countryMapper.countryEntityList2DTOList(entities, true);

        return dtos;
    }

    public CountryDTO getCountryById(Long id) {
        //creo Entidad traída de la DB
        CountryEntity entity = countryRepository.getById(id);

        /*
        //manejo de error de Id inválido
        if (!entity.isPresent()){
            throw new ParamNotFound("Id de país no válido.")
        }
        */

        //transformo a DTO para devolver al Service
        CountryDTO dto = countryMapper.countryEntity2DTO(entity, true);

        return dto;
    }

    @Modifying
    public CountryDTO update(Long id, CountryDTO dto) {

        //convierto a entity para update en BD
        CountryEntity entity = countryRepository.getById(id);

        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setPopulation(dto.getPopulation());
        entity.setArea(dto.getArea());
        entity.setContinent(dto.getContinent());
        entity.setContinentId(dto.getContinentId());
        entity.setIcons(dto.getIcons());

        //envío a Mapper para actualizar y recupero la entidad ya editada y persistida
        CountryEntity entityUpdated = countryRepository.save(entity);

        //Mapeo de vuelta el entitySaved a DTO para enviar al Service
        CountryDTO dtoUpdated = countryMapper.countryEntity2DTO(entityUpdated,true);

        return dtoUpdated;
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    public List<CountryDTO> getByFilters(String name, Long continent, String order) {
/*
        //creo nuevo DTO de filtrado
        CountryFiltersDTO filtersDTO = new CountryFiltersDTO(name, continent, order);
        //genero lista entity con las coincidencias de la especificación del filtrado
        List<CountryEntity> entities = countryRepository.findAll(this.countrySpecification.getByFilters(filtersDTO));
*/
        return null;
    }

}
