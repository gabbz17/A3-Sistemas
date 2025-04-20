package com.example.A3_Sistemas_Distribuidos.entity.role;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Status {
    ATRIBUIDO,
    EM_ANDAMENTO,
    CONCLUIDO;

    @JsonCreator
    public static Status fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "ATRIBUIDO":
                    return ATRIBUIDO;

                case "EM_ANDAMENTO":
                    return EM_ANDAMENTO;

                case "CONCLUIDO":
                    return CONCLUIDO;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Status: " + value);
    }
}
