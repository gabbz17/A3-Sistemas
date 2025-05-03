package com.example.A3_Sistemas_Distribuidos.web.mapper;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.web.dto.FuncionarioDTO;

import java.util.List;

public class FuncionarioMapper {

    public static FuncionarioDTO toDTO(Funcionario funcionario){
        return new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), funcionario.getEmail(), funcionario.getCargo(), funcionario.getTarefa());
    }

    public static List<FuncionarioDTO> toAllDto(List<Funcionario> list){
        return list.stream().map(FuncionarioMapper::toDTO).toList();
    }
}
