package com.equipe.projetoadsapi.service;

import com.equipe.projetoadsapi.model.Agendamento;
import com.equipe.projetoadsapi.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Agendamento agendarAula(Agendamento agendamento) {
        // Verifica se o horário já está ocupado no banco de dados 
        boolean horarioOcupado = agendamentoRepository.existsByProfessorAndDataAndHora(
                agendamento.getProfessor(),
                agendamento.getData(),
                agendamento.getHora()
        );

        if (horarioOcupado) {
            throw new RuntimeException("Erro: O professor já possui uma aula marcada neste horário.");
        }

        // Salva o agendamento se o horário estiver livre 
        agendamento.setStatus("CONFIRMADO"); 
        return agendamentoRepository.save(agendamento);
    }
}