package com.example.varejo.service;

import com.example.varejo.entity.Produto;
import com.example.varejo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){
        if (repository.existsByNome(produto.getNome())) {
            throw new RuntimeException("Já existe um produto com este nome!");
        }

        return repository.save(produto);
    }
}
