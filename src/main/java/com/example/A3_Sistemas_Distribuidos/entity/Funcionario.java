package com.example.A3_Sistemas_Distribuidos.entity;

import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
public class Funcionario implements UserDetails {

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
    @Size(min = 10, max = 11, message = "O numero tem que ter de 10 a 11 dígitos!")
    private String numero;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @NotBlank
    private String senha;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.cargo == Cargo.GERENTE) return List.of(new SimpleGrantedAuthority("ROLE_GERENTE"),
                new SimpleGrantedAuthority("ROLE_SUPERVISOR"), new SimpleGrantedAuthority("ROLE_ATENDENTE"));
        else if (this.cargo == Cargo.SUPERVISOR) return List.of(new SimpleGrantedAuthority("ROLE_SUPERVISOR"), new SimpleGrantedAuthority("ROLE_ATENDENTE"));
        else return List.of(new SimpleGrantedAuthority("ROLE_ATENDENTE"));

    }

    @Override
    public String getPassword() {
        return this.senha; // Agora você retorna a senha correta!
    }

    @Override
    public String getUsername() {
        return this.email; // Agora você retorna o email do funcionário (como username)
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
