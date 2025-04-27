package com.example.A3_Sistemas_Distribuidos.service;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.exception.IdNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.ListNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.NameNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.NameUniqueException;
import com.example.A3_Sistemas_Distribuidos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public Funcionario create(Funcionario funcionario){
        try {
            String encryptedPassword = new BCryptPasswordEncoder().encode(funcionario.getSenha());
            funcionario.setSenha(encryptedPassword);
            return repository.save(funcionario);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new NameUniqueException("Dados já cadastrados!");
        }
    }

    public List<Funcionario> findAll(){
        return repository.findAll();
    }

    public Funcionario findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Funcionário com o id (%d), não encontrado!", id)));
    }

    public List<Funcionario> findByCargo(String cargo){
        Cargo cg = Cargo.valueOf(cargo);
        List<Funcionario> list = repository.findByCargo(cg);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Funcionários com o cargo (%s), não encontrados!", cargo));
        }

        return list;
    }

    public Funcionario findByNome(String nome){
        return repository.findByNome(nome).orElseThrow(() ->
                new NameNotFoundException(String.format("Funcionário com o nome (%s), não encontrado!", nome)));
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
