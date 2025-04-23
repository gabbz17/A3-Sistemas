package com.example.A3_Sistemas_Distribuidos.web.controller;

import com.example.A3_Sistemas_Distribuidos.documentation.TarefaDocs;
import com.example.A3_Sistemas_Distribuidos.web.dto.TarefaResponseDTO;
import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tarefa")
public class TarefaController implements TarefaDocs {

    @Autowired
    TarefaService service;

    @PostMapping
    public ResponseEntity<Tarefa> create(@Valid @RequestBody Tarefa tarefa){
        Tarefa fun = service.create(tarefa);
        return ResponseEntity.status(201).body(fun);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll(){
        List<Tarefa> fun = service.findAll();
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/uid/{uid}")
    public ResponseEntity<Tarefa> findByUid(@PathVariable String uid){
        Tarefa fun = service.findByUid(uid);
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Tarefa>> findByStatus(@PathVariable String status){
        List<Tarefa> fun = service.findByStatus(status);
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/supervisor/{supervisor}")
    public ResponseEntity<List<Tarefa>> findBySupervisor(@PathVariable String supervisor){
        List<Tarefa> fun = service.findBySupervisor(supervisor);
        return ResponseEntity.ok().body(fun);
    }

    @GetMapping("/atendente/{atendente}")
    public ResponseEntity<List<Tarefa>> findByAtendente(@PathVariable String atendente){
        List<Tarefa> fun = service.findByAtendente(atendente);
        return ResponseEntity.ok().body(fun);
    }

    @PatchMapping("/update/{uid}")
    public ResponseEntity<Tarefa> update(@PathVariable String uid, @Valid @RequestBody TarefaResponseDTO status){
        Tarefa fun = service.update(uid, status.getStatus());
        return ResponseEntity.ok().body(fun);
    }

    @DeleteMapping("/delete/{uid}")
    public ResponseEntity<Void> delete(@PathVariable String uid){
        service.delete(uid);
        return ResponseEntity.noContent().build();
    }
}
