package com.senaibank.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.bank.Conta;

public interface ContaBankRepository extends JpaRepository<Conta, Long> {

    void save(String contaOrigem);
}