package com.example.A3_Sistemas_Distribuidos.repository;

import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.entity.role.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, String> {
    List<Tarefa> findByStatus(Status st);
    List<Tarefa> findBySupervisor(String supervisor);
    List<Tarefa> findByAtendente(String atendente);
}
