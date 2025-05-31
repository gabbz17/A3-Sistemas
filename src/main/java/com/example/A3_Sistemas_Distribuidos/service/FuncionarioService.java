package com.example.A3_Sistemas_Distribuidos.service;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.exception.IdNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.ListNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.NameNotFoundException;
import com.example.A3_Sistemas_Distribuidos.exception.NameUniqueException;
import com.example.A3_Sistemas_Distribuidos.repository.FuncionarioRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Funcionario create(Funcionario funcionario){
        try {
            funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
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

    public Funcionario updatePasswordGerente(Long id, String password){
        Funcionario funcionario = findById(id);

        funcionario.setSenha(passwordEncoder.encode(password));

        return repository.save(funcionario);
    }

    public Funcionario updatePasswordFuncionario(Long id, String senhaAtual, String novaSenha, String repitaSenha){
        Funcionario funcionario = findById(id);

        if (!passwordEncoder.matches(senhaAtual, funcionario.getSenha())) {
            throw new NameUniqueException("Senha incorreta!");
        }
        if (!novaSenha.equals(repitaSenha)) {
            throw new NameUniqueException("Senhas diferentes!");
        }

        funcionario.setSenha(passwordEncoder.encode(novaSenha));

        return repository.save(funcionario);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
