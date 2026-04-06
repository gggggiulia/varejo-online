package com.example.varejo.repository;

import com.example.varejo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    boolean existsByNome(String nome);

    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
