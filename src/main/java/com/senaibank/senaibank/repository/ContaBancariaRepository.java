package com.senaibank.senaibank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.bank.ContaBancaria;


public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {



}