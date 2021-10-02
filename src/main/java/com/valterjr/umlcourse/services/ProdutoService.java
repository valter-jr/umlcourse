package com.valterjr.umlcourse.services;

import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.repositories.ProdutoRepository;
import com.valterjr.umlcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository ProdutoRepository;

    public Produto find(Integer id) {
        Optional<Produto> obj = ProdutoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    public Produto salvar(Produto Produto) {
        return ProdutoRepository.save(Produto);
    }

    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = ProdutoRepository.findAll();
        return ResponseEntity.ok().body(produtos);
    }
}
