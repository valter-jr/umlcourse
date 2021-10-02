package com.valterjr.umlcourse.repositories;

import com.valterjr.umlcourse.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
