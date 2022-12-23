package io.github.tjeveraldo;


import io.github.tjeveraldo.domain.entity.Cliente;
import io.github.tjeveraldo.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {


    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Everaldo"));
            clientes.save(new Cliente("Outro Cliente"));

            boolean existe = clientes.existsByNome("Everaldo");
            System.out.println("existe um cliente com o nome Everaldo? " + existe);

        };
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}