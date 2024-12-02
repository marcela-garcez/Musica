package com.prova.projetomusica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.prova")
@EntityScan(basePackages = {"com.prova.domains","com.prova.domains.enums"})
@EnableJpaRepositories(basePackages = "com.prova.repositories")
@SpringBootApplication
public class ProjetomusicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetomusicaApplication.class, args);
	}

}
