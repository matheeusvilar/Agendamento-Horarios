package com.javanauta.agendador_horarios.services;

import com.javanauta.agendador_horarios.infrastructure.entity.Agendamento;
import com.javanauta.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor //INJECAO DE DEPENDENCIAS
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    //VERIFICANDO SE A DATA E HORA JA NAO ESTA MARCADA PARA OUTRA PESSOA

    public Agendamento salvarAgendamento(Agendamento agendamento){

        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusHours(1);

        Agendamento agendados = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento,horaFim);

        if (Objects.nonNull(agendados)){
            throw new RuntimeException("Horario já está preenchido");
        }
        return agendamentoRepository.save(agendamento);

    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente){

        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }

    public Agendamento buscarAgendamentosDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23,59,59);

       return agendamentoRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
    }

    public Agendamento alterarAgendamento(Agendamento agendamento, String cleinte, LocalDateTime dataHoraAgendamento){

    }
}