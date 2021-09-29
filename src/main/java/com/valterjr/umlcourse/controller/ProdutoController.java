package com.valterjr.umlcourse.controller;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> produtos = produtoRepository.findAll();
        return ResponseEntity.ok().body(produtos);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Produto findById(@PathVariable Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElse(null);
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) {
            return produtoRepository.save(produto);
    }
    
}
