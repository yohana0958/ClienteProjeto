package com.ClienteProjeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClienteProjeto.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
