package com.example.varejo.controller;

import com.example.varejo.entity.Produto;
import com.example.varejo.repository.ProdutoRepository;
import com.example.varejo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoService service;

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return service.save(produto);
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return repository.findAll();
    }
}
