package com.valterjr.umlcourse.repositories;

import com.valterjr.umlcourse.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
