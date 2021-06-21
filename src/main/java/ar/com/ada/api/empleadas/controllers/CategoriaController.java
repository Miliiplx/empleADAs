package ar.com.ada.api.empleadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.models.response.GenericResponse;
import ar.com.ada.api.empleadas.services.CategoriaService;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping("/categorias")
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){

        GenericResponse r = new GenericResponse();
        service.crearCategoria(categoria);

        r.isOk = true;
        r.id = categoria.getCategoriaId();
        r.message = "La categoria fue creada con éxito.";

        return ResponseEntity.ok(r);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> traerCategorias(){
        return ResponseEntity.ok(service.traerCategorias());
    }


    
}
