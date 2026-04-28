package com.equipe.projetoadsapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Diz que é uma tabela do banco
@Table(name = "tb_usuarios") // Dá o nome da tabela
@Getter // Cria os gets de tudo
@Setter // Cria os sets de tudo
@NoArgsConstructor // Construtor vazio para o banco de dados
@AllArgsConstructor // Construtor cheio para você usar no código
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;


}
