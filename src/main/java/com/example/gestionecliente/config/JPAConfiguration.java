package com.example.GestioneCliente.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.GestioneCliente.Domain.Repository")
public class JPAConfiguration {
}
