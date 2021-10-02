package com.valterjr.umlcourse.controller;

import com.valterjr.umlcourse.model.Cliente;
import com.valterjr.umlcourse.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return clienteService.listar();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Cliente obj = clienteService.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente) {
            return clienteService.salvar(cliente);
    }
    
}
