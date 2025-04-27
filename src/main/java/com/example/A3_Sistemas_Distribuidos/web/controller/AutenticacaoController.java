package com.example.A3_Sistemas_Distribuidos.web.controller;

import com.example.A3_Sistemas_Distribuidos.infra.security.TokenService;
import com.example.A3_Sistemas_Distribuidos.web.dto.AutenticacaoDTO;
import com.example.A3_Sistemas_Distribuidos.web.dto.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager atAuthenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());
        var auth = this.atAuthenticationManager.authenticate(usernamePassword);

        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        var token = tokenService.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
