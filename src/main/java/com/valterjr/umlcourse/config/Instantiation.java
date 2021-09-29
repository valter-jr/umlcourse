package com.valterjr.umlcourse.config;

import com.valterjr.umlcourse.model.Categoria;
import com.valterjr.umlcourse.model.Cidade;
import com.valterjr.umlcourse.model.Estado;
import com.valterjr.umlcourse.model.Produto;
import com.valterjr.umlcourse.repositories.CategoriaRepository;
import com.valterjr.umlcourse.repositories.CidadeRepository;
import com.valterjr.umlcourse.repositories.EstadoRepository;
import com.valterjr.umlcourse.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "Mouse", 80.00);

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(List.of(p2));

        p1.getCategorias().addAll(List.of(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(List.of(cat1));



        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        System.out.println("Objetos Salvos");

    }
}