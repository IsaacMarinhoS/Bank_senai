package com.senaibank.senaibank.service;

import com.senaibank.senaibank.bank.ContaBank;
import com.senaibank.senaibank.repository.ContaBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBankService {
    @Autowired
    private ContaBankRepository contaBankRepository;

    public ContaBank create(ContaBank contaBank) {
        return contaBankRepository.save(contaBank);
    }

    public List<ContaBank> findAll() {
        return contaBankRepository.findAll();
    }

    public ContaBank findByNumeroConta(String numeroConta) {
        return contaBankRepository.findByNumeroConta(numeroConta);
    }

    public ContaBank update(ContaBank contaBank) {
        return contaBankRepository.save(contaBank);
    }

    public void delete(Long id) {
        contaBankRepository.deleteById(id);
    }
}
