package com.senaibank.senaibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senaibank.senaibank.bank.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByClienteAtivoTrue();

    @Query("SELECT new com.api.senai.dto.ClienteDTO(c.id, c.nome) FROM Cliente c")
    List<Cliente> getClientesDTO();

}