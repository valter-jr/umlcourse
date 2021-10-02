package com.valterjr.umlcourse.config;

import com.valterjr.umlcourse.model.*;
import com.valterjr.umlcourse.model.enums.EstadoPagamento;
import com.valterjr.umlcourse.model.enums.TipoCliente;
import com.valterjr.umlcourse.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
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

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    PagamentoRepository pagamentoRepository;

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

        Cliente cl1 = new Cliente(null, "Banjo", "banjo@gmail.com", "77097845698",
                TipoCliente.PESSOAFISICA);

        Cliente cl2 = new Cliente(null, "Kazooie Tech", "kazooie@gmail.com", "99804596305",
                TipoCliente.PESSOAJURIDICA);

        cl1.getTelefones().addAll(Arrays.asList("123456", "7891011"));

        Endereco e1 = new Endereco(null, "Rua Wenceslau", "300", "Apto 207",
                "Jardim", "18200300", cl1, c1);

        Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 700",
                "Centro", "19800978", cl2, c2);

        cl1.getEnderecos().addAll(Arrays.asList(e1, e2));


        clienteRepository.saveAll(Arrays.asList(cl1, cl2));

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(List.of(p2));

        p1.getCategorias().addAll(List.of(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(List.of(cat1));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("16/11/1996 10:32"), cl1, e1);
        Pedido ped2 = new Pedido(null, sdf.parse("16/12/2021 21:22"), cl2, e2);

        Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 7);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,
                sdf.parse("30/12/2021 00:00"), null);
        ped2.setPagamento(pagto2);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
        clienteRepository.saveAll(Arrays.asList(cl1, cl2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));


        System.out.println("Objetos Salvos");

    }
}