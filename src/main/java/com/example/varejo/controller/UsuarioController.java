package com.example.varejo.controller;

import com.example.varejo.entity.Usuario;
import com.example.varejo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return service.createUsuario(usuario);
    }
}
