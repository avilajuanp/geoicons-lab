package com.alkemy.geoicons.app.services;

import com.alkemy.geoicons.app.dtos.CountryDTO;

import java.util.List;

public interface CountryService {
    //abstracción de métodos CountryServiceImpl
    CountryDTO save(CountryDTO dto);

    List<CountryDTO> getAllCountries();

    CountryDTO getCountryById(Long id);

    List<CountryDTO> getByFilters(String name, Long continent, String order);

    CountryDTO update(Long id, CountryDTO country);

    void delete(Long id);
}
