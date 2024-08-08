package com.senaibank.senaibank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.senaibank.bank.ContaBancaria;
import com.senaibank.senaibank.bank.Transacao;


public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByContaOrigemOrContaDestinoOrderByDataDesc(
        ContaBancaria contaOrigem, 
        ContaBancaria contaDestino
    );

}