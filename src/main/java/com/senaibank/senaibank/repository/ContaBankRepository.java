package com.senaibank.senaibank.repository;

import com.senaibank.senaibank.bank.ContaBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaBankRepository extends JpaRepository<ContaBank, Long> {

    void save(String contaOrigem);
}