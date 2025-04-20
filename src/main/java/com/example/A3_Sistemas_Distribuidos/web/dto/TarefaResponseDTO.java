package com.example.A3_Sistemas_Distribuidos.web.dto;

import com.example.A3_Sistemas_Distribuidos.entity.role.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TarefaResponseDTO {

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
}
