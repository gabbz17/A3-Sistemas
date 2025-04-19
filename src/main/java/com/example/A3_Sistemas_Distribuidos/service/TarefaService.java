package com.example.A3_Sistemas_Distribuidos.service;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.entity.role.Status;
import com.example.A3_Sistemas_Distribuidos.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repository;

    @Autowired
    FuncionarioService service;

    public Tarefa create(Tarefa tarefa){
        Funcionario atendente = service.findByNome(tarefa.getAtendente());
        Funcionario supervisor = service.findByNome(tarefa.getSupervisor());

        if (!atendente.getCargo().equals(Cargo.ATENDENTE) || !supervisor.getCargo().equals(Cargo.SURPEVISOR)){
            throw new RuntimeException("Funcionário(os) com cargo errado!");
        }

        return repository.save(tarefa);
    }

    public List<Tarefa> findAll(){
        return repository.findAll();
    }

    public Tarefa findByUid(String uid){
        return repository.findById(uid).get();
    }

    public List<Tarefa> findByStatus(String status){
        Status st = Status.valueOf(status);

        return repository.findByStatus(st);
    }

    public List<Tarefa> findBySupervisor(String supervisor){
        return repository.findBySupervisor(supervisor);
    }

    public List<Tarefa> findByAtendente(String atendente){
        return repository.findByAtendente(atendente);
    }

    public Tarefa update(String uid, String status){
        Tarefa tarefa = findByUid(uid);
        Status st = Status.valueOf(status);

        if (st.equals(Status.ATRIBUIDO) || st.equals(Status.PENDENTE)){
            throw new RuntimeException(String.format("Valor para status (%s), negado!", st));
        }

        tarefa.setStatus(st);
        return repository.save(tarefa);
    }
}
