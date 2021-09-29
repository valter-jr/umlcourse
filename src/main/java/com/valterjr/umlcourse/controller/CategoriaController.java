package com.valterjr.umlcourse.controller;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.repositories.CategoriaRepository;
import com.valterjr.umlcourse.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        return categoriaService.listar();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = categoriaService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

}
