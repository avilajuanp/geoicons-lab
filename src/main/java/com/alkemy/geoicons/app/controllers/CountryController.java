package com.alkemy.geoicons.app.controllers;

import com.alkemy.geoicons.app.dtos.CountryDTO;
import com.alkemy.geoicons.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries") //como se va a llamar la base de nuestro Path
public class CountryController {

    @Autowired //anotación para que Spring me traiga mi servicio para trabajar
    private CountryService countryService;

    //endpoint para poder guardar países, es POST xq estamos creando país
    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country){

        // instancio el elemento del body q va en la respuesta, la lógica de guardado la maneja mi Service
        CountryDTO countryCreated = countryService.save(country);

        //devolvemos el codigo 201 con el país guardado arriba
        return ResponseEntity.status(HttpStatus.CREATED).body(countryCreated);
    }

    //endpoint GET para obtener listado de países guardados
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAll(){
        //instancio lista para el Return
        List<CountryDTO> countries = countryService.getAllCountries();
        //retorno la Lista creada
        return ResponseEntity.ok().body(countries);
    }

    //endpoint GET para obtener un país especifico por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id){

        CountryDTO countryDTO = countryService.getCountryById(id);
        return ResponseEntity.ok(countryDTO); //esto tbien está ok
    }

/*
    //endpoint para buscar países y filtrar por nombre y continente
    @GetMapping
    public ResponseEntity<List<CountryDTO>> getCountriesByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long continent,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<CountryDTO> countries = countryService.getByFilters(name,continent,order);
        return ResponseEntity.ok(countries);
    }
*/

    //metodo Update país por Id
    @PutMapping("/{id}")
    public ResponseEntity<CountryDTO> update(@PathVariable Long id, @RequestBody CountryDTO country){
        //instancio Dto para el return
        CountryDTO dtoUpdated = countryService.update(id,country);

        return ResponseEntity.ok(dtoUpdated);
    }

    //método Delete país por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        countryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
