package com.example.A3_Sistemas_Distribuidos.entity.role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {
    ATENDENTE,
    SUPERVISOR,
    GERENTE;

    @JsonCreator
    public static Cargo fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ATENDENTE":
                    return ATENDENTE;

                case "SUPERVISOR":
                    return SUPERVISOR;

                case "GERENTE":
                    return GERENTE;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Cargo: " + value);
    }
}
