package com.example.A3_Sistemas_Distribuidos.entity;

import com.example.A3_Sistemas_Distribuidos.entity.role.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "uid")
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;
    @NotBlank
    private String descricao;
    @NotBlank
    private String atendente;
    @NotBlank
    private String supervisor;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status = Status.ATRIBUIDO;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime criado = LocalDateTime.now();
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime finalizado;
}
