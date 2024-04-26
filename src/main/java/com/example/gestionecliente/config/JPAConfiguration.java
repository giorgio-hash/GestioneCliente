package com.example.gestionecliente.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Classe di configurazione per abilitare Hibernate ad usare le interfacce Repository specificate
 */
@EnableJpaRepositories(basePackages = "com.example.gestionecliente.Domain.Repository")
public class JPAConfiguration {
}
