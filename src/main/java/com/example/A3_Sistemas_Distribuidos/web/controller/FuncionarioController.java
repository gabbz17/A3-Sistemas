package com.example.A3_Sistemas_Distribuidos.web.controller;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.service.FuncionarioService;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionario){
        Funcionario fun = service.create(funcionario);
        return ResponseEntity.status(201).body(fun);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll(){
        List<Funcionario> fun = service.findAll();
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id){
        Funcionario fun = service.findById(id);
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<Funcionario>> findByCargo(@PathVariable String cargo){
        List<Funcionario> fun = service.findByCargo(cargo);
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Funcionario> findByNome(@PathVariable String nome){
        Funcionario fun = service.findByNome(nome);
        return ResponseEntity.ok().body(fun);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @Valid @RequestBody FuncionarioResponseDTO cargo){
        Funcionario fun = service.update(id, cargo.getCargo());
        return ResponseEntity.ok().body(fun);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
