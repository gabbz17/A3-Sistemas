package com.example.A3_Sistemas_Distribuidos.entity;

import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min = 11, max = 11)
    @Column(unique = true)
    private String cpf;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    @Column(unique = true)
    @Size(min = 10, max = 11)
    private String numero;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

}
