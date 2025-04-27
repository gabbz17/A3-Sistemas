package com.example.A3_Sistemas_Distribuidos.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        //INICIO DA AUTORIZAÇÃO DE FUNCIONARIOS
                        .requestMatchers(HttpMethod.POST, "/api/funcionario").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/funcionario").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/funcionario/id/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/funcionario/cargo/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/funcionario/nome/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.PATCH, "/api/funcionario/update/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/api/funcionario/delete/*").hasRole("GERENTE")
                        //INICIO DA AUTORIZAÇÃO DE TAREFAS
                        .requestMatchers(HttpMethod.POST, "/api/tarefa").hasRole("SUPERVISOR")
                        .requestMatchers(HttpMethod.GET, "/api/tarefa").hasRole("SUPERVISOR")
                        .requestMatchers(HttpMethod.GET, "/api/tarefa/status/*").hasRole("SUPERVISOR")
                        .requestMatchers(HttpMethod.GET, "/api/tarefa/supervisor/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/tarefa/atendente/*").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.DELETE, "/api/tarefa/delete/*").hasRole("GERENTE")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
