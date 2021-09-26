package com.valterjr.umlcourse.controller;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.repositories.CategoriaRepository;
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
    CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok().body(categorias);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Categoria findById(@PathVariable Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElse(null);
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
