package com.javanauta.agendador_horarios.services;

import com.javanauta.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //INJECAO DE DEPENDENCIAS
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
}