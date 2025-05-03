package com.example.A3_Sistemas_Distribuidos.web.dto;

import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;

import java.util.List;

public record FuncionarioDTO(
        Long id,
        String nome,
        String email,
        Cargo cargo,
        List<Tarefa> tarefa
) {
}
