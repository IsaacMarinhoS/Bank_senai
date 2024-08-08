package com.senaibank.senaibank.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.senaibank.bank.ContaBancaria;
import com.senaibank.senaibank.bank.Transacao;
import com.senaibank.senaibank.repository.ContaBancariaRepository;


@Service
public class ContaService {

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    ContaService(ContaBancariaRepository contaBancariaRepository) {
        this.contaBancariaRepository = contaBancariaRepository;
    }

    public List<ContaBancaria> getAll() {
        return contaBancariaRepository.findAll();
    }

    public ContaBancaria getById(Long id) {
        return contaBancariaRepository.findById(id).orElse(null);
    }

    public ContaBancaria create(ContaBancaria contaBancaria) {
        return contaBancariaRepository.save(contaBancaria);
    }

    public ContaBancaria update(ContaBancaria contaExistente, ContaBancaria contaNova) {

        contaExistente.setSaldo(contaNova.getSaldo());

        return contaBancariaRepository.save(contaExistente);
    }

    public ContaBancaria delete(Long id) {
        ContaBancaria contaBancaria = getById(id);
        contaBancariaRepository.delete(contaBancaria);
        return contaBancaria;
    }

    public boolean temSaldo(Transacao transacao) {
        // Comprarar o saldo da conta origem com o valor da transacao
        ContaBancaria conta = getById(transacao.getContaOrigem().getNumeroConta());

        boolean temSaldo = (
            conta.getSaldo() 
            >= 
            transacao.getValor()
        );
        return temSaldo;
    }

}