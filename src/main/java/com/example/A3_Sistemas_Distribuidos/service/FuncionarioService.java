package com.example.A3_Sistemas_Distribuidos.service;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public Funcionario create(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    public Funcionario findById(Long id){
        return repository.findById(id).get();
    }

    public List<Funcionario> findByCargo(String cargo){
        Cargo cg = Cargo.valueOf(cargo);

        return repository.findByCargo(cg);
    }

    public Funcionario findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Funcionario update(Long id, Cargo cargo){
        Funcionario funcionario = findById(id);

        funcionario.setCargo(cargo);
        return repository.save(funcionario);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
