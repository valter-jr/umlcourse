package com.valterjr.umlcourse.repositories;

import com.valterjr.umlcourse.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
