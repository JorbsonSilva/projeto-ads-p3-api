package com.equipe.projetoadsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equipe.projetoadsapi.model.Usuario;
import com.equipe.projetoadsapi.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Usuario apos public indica oque o metodo vai retorna.
    public Usuario cadastrarUsuario(Usuario novoUsuario){

        // Busca no banco e já guarda o resultado na variável
        Usuario usuarioExistente = repository.findByEmail(novoUsuario.getEmail());

        // Regra de negócio 
        if (usuarioExistente != null){
            throw new RuntimeException("Email já cadastrado!!!"); 
        }
        // Se o código chegou aqui, o caminho está livre. Pode salvar!
        return repository.save(novoUsuario);
        
    } 
  
    public Usuario consultaUsuario(Usuario loginUsuario){

        Usuario usuarioExistente = repository.findByEmail(loginUsuario.getEmail());

        // Regra de negócio 
        if (usuarioExistente == null){
            throw new RuntimeException("Usuário não cadastrado!!!"); 
             
        }else if(!usuarioExistente.getSenha().equals(loginUsuario.getSenha())){
                throw new RuntimeException("Senha incorreta!!!");
        } 
        // Se o código chegou aqui, o caminho está livre. Pode salvar!
        return usuarioExistente;

    }
}
