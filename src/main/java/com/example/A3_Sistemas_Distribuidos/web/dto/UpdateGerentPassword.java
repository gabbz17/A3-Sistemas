package com.example.A3_Sistemas_Distribuidos.web.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateGerentPassword(
        @NotBlank
        String senha
) {
}
