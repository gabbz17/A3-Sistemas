package com.example.A3_Sistemas_Distribuidos.entity.role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    ATRIBUIDO,
    PENDENTE,
    CONCLUIDO;

    @JsonCreator
    public static Status fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ATRIBUIDO":
                    return ATRIBUIDO;

                case "PENDENTE":
                    return PENDENTE;

                case "CONCLUIDO":
                    return CONCLUIDO;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Role: " + value);
    }
}
