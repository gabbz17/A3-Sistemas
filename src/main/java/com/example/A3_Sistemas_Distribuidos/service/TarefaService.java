package com.example.A3_Sistemas_Distribuidos.service;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.Tarefa;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.entity.role.Status;
import com.example.A3_Sistemas_Distribuidos.exception.IdNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.ListNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.NameUniqueException;
import com.example.A3_Sistemas_Distribuidos.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        if (!atendente.getCargo().equals(Cargo.ATENDENTE) || !supervisor.getCargo().equals(Cargo.SUPERVISOR)){
            throw new NameUniqueException("Funcionário(os) com cargo errado!");
        }

        tarefa.setFuncionario(atendente);

        return repository.save(tarefa);
    }

    public List<Tarefa> findAll(){
        return repository.findAll();
    }

    public Tarefa findByUid(String uid){
        return repository.findById(uid).orElseThrow(() ->
                new IdNotFoundException(String.format("Tarefa com o uid (%s), não encontrada!", uid)));
    }

    public List<Tarefa> findByStatus(String status){
        Status st = Status.valueOf(status);
        List<Tarefa> list = repository.findByStatus(st);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Tarefas com o status (%s), não encontrados!", status));
        }
        return list;
    }

    public List<Tarefa> findBySupervisor(String supervisor){
        List<Tarefa> list = repository.findBySupervisor(supervisor);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Tarefas supervisionadas por (%s), não encontradas!", supervisor));
        }
        return list;
    }

    public List<Tarefa> findByAtendente(String atendente){
        List<Tarefa> list = repository.findByAtendente(atendente);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Tarefas atribuídas para (%s), não encontradas!", atendente));
        }
        return list;
    }

    public Tarefa update(String uid, Status status){
        Tarefa tarefa = findByUid(uid);

        if (status.equals(Status.ATRIBUIDO)){
            throw new NameUniqueException(String.format("Valor para status (%s), negado!", status));
        }

        if (status.equals(Status.CONCLUIDO)) {
            tarefa.setFinalizado(LocalDateTime.now());
        }

        tarefa.setStatus(status);
        return repository.save(tarefa);
    }

    public void delete(String uid){
        repository.deleteById(uid);
    }
}
