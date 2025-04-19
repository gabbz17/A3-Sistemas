package com.example.A3_Sistemas_Distribuidos.repository;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByCargo(Cargo cargo);
    Funcionario findByNome(String nome);
}
