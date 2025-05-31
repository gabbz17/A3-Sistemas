package com.example.A3_Sistemas_Distribuidos.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateFuncionarioPassword {

    @NotBlank
    private String senhaAtual;
    @NotBlank
    private String novaSenha;
    @NotBlank
    private String repitaSenha;
}
