package com.example.varejo.service;

import com.example.varejo.entity.Usuario;
import com.example.varejo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario createUsuario(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O e-mail é obrigatório!");
        }

        if (repository.existsByEmail(usuario.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este e-mail já está em uso.");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A senha é obrigatória!");
        }

        return repository.save(usuario);
    }
}
