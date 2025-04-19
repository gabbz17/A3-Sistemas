package com.example.A3_Sistemas_Distribuidos.entity.role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {
    ATENDENTE,
    SURPEVISOR,
    GERENTE;

    @JsonCreator
    public static Cargo fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ATENDENTE":
                    return ATENDENTE;

                case "SURPEVISOR":
                    return SURPEVISOR;

                case "GERENTE":
                    return GERENTE;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
