package com.valterjr.umlcourse.services;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Categoria obj = categoriaRepository.getById(id);
        return obj;
    }
}
