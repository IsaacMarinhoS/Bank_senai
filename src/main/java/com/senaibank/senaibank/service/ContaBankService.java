package com.senaibank.senaibank.service;

import com.senaibank.senaibank.bank.Conta;
import com.senaibank.senaibank.repository.ContaBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBankService {
    @Autowired
    private ContaBankRepository contaBankRepository;

    public Conta create(Conta contaBank) {
        return contaBankRepository.save(contaBank);
    }

    public List<Conta> findAll() {
        return contaBankRepository.findAll();
    }

    public Conta findById(Long id) {
        return contaBankRepository.findById(id).orElse(null);
    }

    public Conta update(Conta contaBank) {
        return contaBankRepository.save(contaBank);
    }

    public void delete(Long id) {
        contaBankRepository.deleteById(id);
    }

    public List<Conta> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

}
