package com.valterjr.umlcourse.controller;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.repositories.ProdutoRepository;
import com.valterjr.umlcourse.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return produtoService.listar();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Produto obj = produtoService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) {
            return produtoService.salvar(produto);
    }
    
}
