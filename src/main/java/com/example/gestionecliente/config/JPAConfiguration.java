package com.example.gestionecliente.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.gestionecliente.Domain.Repository")
public class JPAConfiguration {
}
