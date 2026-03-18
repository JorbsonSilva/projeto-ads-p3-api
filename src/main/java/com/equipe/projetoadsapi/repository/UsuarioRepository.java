package com.equipe.projetoadsapi.repository;

import com.equipe.projetoadsapi.model.Usuario; // Importa a tabela Usuario
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String email);
    Usuario findBySenha(String senha);
    
}
