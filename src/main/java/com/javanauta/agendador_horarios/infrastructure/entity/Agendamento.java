package com.javanauta.agendador_horarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOMATICAMENTE GENERAR ID
    private Long id;

    private String servico;

    private String profisional;

    private LocalDateTime dataHoraAgendamento;

    private String cliente;

    private String telfoneCliente;

    private LocalDateTime dataInsercao = LocalDateTime.now();


}
