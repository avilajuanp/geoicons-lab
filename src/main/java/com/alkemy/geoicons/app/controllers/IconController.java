package com.alkemy.geoicons.app.controllers;

import com.alkemy.geoicons.app.dtos.IconDTO;
import com.alkemy.geoicons.app.services.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons") //como se va a llamar la base de nuestro Path
public class IconController {

    @Autowired //anotación para que Spring me traiga mi servicio para trabajar
    private IconService iconService;

    //endpoint para poder guardar íconos, es POST xq estamos creando ícono
    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon){

        // instancio el elemento del body q va en la respuesta, la lógica de guardado la maneja mi Service
        IconDTO iconCreated = iconService.save(icon);

        //devolvemos el codigo 201 con el icono guardado arriba
        return ResponseEntity.status(HttpStatus.CREATED).body(iconCreated);
    }

    //endpoint GET para obtener listado de iconos guardados
    @GetMapping
    public ResponseEntity<List<IconDTO>> getAll(){
        //instancio lista para el Return
        List<IconDTO> icons = iconService.getAllIcons();
        //retorno la Lista creada
        return ResponseEntity.ok().body(icons);
    }

    //endpoint GET para obtener un ícono especifico por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<IconDTO> getIconById(@PathVariable Long id){

        IconDTO iconDTO = iconService.getIconById(id);
        return ResponseEntity.ok(iconDTO); //esto tbien está ok
    }

/*
    //endpoint para buscar íconos y filtrar por nombre y continente
    @GetMapping
    public ResponseEntity<List<IconDTO>> getIconsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long continent,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<IconDTO> icons = iconService.getByFilters(name,continent,order);
        return ResponseEntity.ok(icons);
    }
*/

    //metodo Update país por Id
    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon){
        //instancio Dto para el return
        IconDTO dtoUpdated = iconService.update(id,icon);

        return ResponseEntity.ok(dtoUpdated);
    }

    //método Delete país por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
