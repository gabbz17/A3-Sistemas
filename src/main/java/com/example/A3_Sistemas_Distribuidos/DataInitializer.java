package com.example.A3_Sistemas_Distribuidos;

import com.example.A3_Sistemas_Distribuidos.entity.Funcionario;
import com.example.A3_Sistemas_Distribuidos.entity.role.Cargo;
import com.example.A3_Sistemas_Distribuidos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        String password = "anna123";
        String encode = passwordEncoder.encode(password);

        if (repository.count() == 0){
            Funcionario funcionario = new Funcionario();
            funcionario.setNome("Ana Melo");
            funcionario.setCpf("55410792465");
            funcionario.setEmail("anna@gmail.com");
            funcionario.setNumero("71788474202");
            funcionario.setCargo(Cargo.GERENTE);
            funcionario.setSenha(encode);

            repository.save(funcionario);
        }

    }
}
