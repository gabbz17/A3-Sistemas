package com.example.A3_Sistemas_Distribuidos.web.controller;

import com.example.A3_Sistemas_Distribuidos.documentation.FuncionarioDocs;
import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.service.FuncionarioService;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioDTO;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioResponseDTO;
import com.example.A3_Sistemas_Distribuidos.web.mapper.FuncionarioMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController implements FuncionarioDocs {

    @Autowired
    FuncionarioService service;

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@Valid @RequestBody Funcionario funcionario){
        Funcionario fun = service.create(funcionario);
        FuncionarioDTO dto = FuncionarioMapper.toDTO(funcionario);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        List<Funcionario> fun = service.findAll();
        List<FuncionarioDTO> list = FuncionarioMapper.toAllDto(fun);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id){
        Funcionario fun = service.findById(id);
        FuncionarioDTO dto = FuncionarioMapper.toDTO(fun);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<FuncionarioDTO>> findByCargo(@PathVariable String cargo){
        List<Funcionario> fun = service.findByCargo(cargo);
        List<FuncionarioDTO> list = FuncionarioMapper.toAllDto(fun);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<FuncionarioDTO> findByNome(@PathVariable String nome){
        Funcionario fun = service.findByNome(nome);
        FuncionarioDTO dto = FuncionarioMapper.toDTO(fun);
        return ResponseEntity.ok().body(dto);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Long id, @Valid @RequestBody FuncionarioResponseDTO cargo){
        Funcionario fun = service.update(id, cargo.getCargo());
        FuncionarioDTO dto = FuncionarioMapper.toDTO(fun);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
