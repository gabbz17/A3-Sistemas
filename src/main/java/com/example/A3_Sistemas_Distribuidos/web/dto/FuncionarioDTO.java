package com.example.A3_Sistemas_Distribuidos.web.dto;

import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;

public record FuncionarioDTO(
        Long id,
        String nome,
        String email,
        Cargo cargo
) {
}
