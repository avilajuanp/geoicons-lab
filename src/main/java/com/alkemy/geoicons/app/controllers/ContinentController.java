package com.alkemy.geoicons.app.controllers;

import com.alkemy.geoicons.app.dtos.ContinentDTO;
import com.alkemy.geoicons.app.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continents") //como se va a llamar la base de nuestro Path
public class ContinentController {

    @Autowired //anotación para que Spring me traiga mi servicio para trabajar
    private ContinentService continentService;

    //endpoint GET para obtener listado de continentes guardados
    @GetMapping
    public ResponseEntity<List<ContinentDTO>> getAll(){
        //instancio lista para el Return
        List<ContinentDTO> continents = continentService.getAllContinents();
        //retorno la Lista creada
        return ResponseEntity.ok().body(continents);
    }

    //endpoint para poder guardar continents, es POST xq estamos creando continent
    @PostMapping
    public ResponseEntity<ContinentDTO> save (@RequestBody ContinentDTO continent){

        // instancio el elemento del body q va en la respuesta, la lógica de guardado la maneja mi Service
        ContinentDTO continentCreated = continentService.save(continent);

        //devolvemos el codigo 201 con el cont guardado arriba
        return ResponseEntity.status(HttpStatus.CREATED).body(continentCreated);
    }
}
