package com.valterjr.umlcourse.services;

import com.valterjr.umlcourse.model.Cliente;
import com.valterjr.umlcourse.repositories.ClienteRepository;
import com.valterjr.umlcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository ClienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = ClienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente salvar(Cliente Cliente) {
        return ClienteRepository.save(Cliente);
    }

    public ResponseEntity<List<Cliente>> listar() {
        List<Cliente> clientes = ClienteRepository.findAll();
        return ResponseEntity.ok().body(clientes);
    }
}
