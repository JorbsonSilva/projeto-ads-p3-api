package com.equipe.projetoadsapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equipe.projetoadsapi.model.Usuario;
import com.equipe.projetoadsapi.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastro")
    public Usuario cadastrar(@RequestBody Usuario novoUsuario) {

      return service.cadastrarUsuario(novoUsuario);
    }

    @PostMapping("/login")
    public Usuario loginUsuario(@RequestBody Usuario loginUsuario) {
        return service.consultaUsuario(loginUsuario);
    }
}
