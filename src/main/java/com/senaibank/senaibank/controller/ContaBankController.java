package com.senaibank.senaibank.controller;

import com.senaibank.senaibank.bank.ContaBank;
import com.senaibank.senaibank.service.ContaBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaBankController {
    @Autowired
    private ContaBankService contaBankService;

    @PostMapping
    public ResponseEntity<ContaBank> create(@RequestBody ContaBank contaBank) {
        return ResponseEntity.ok(contaBankService.create(contaBank));
    }

    @GetMapping
    public ResponseEntity<List<ContaBank>> findAll() {
        return ResponseEntity.ok(contaBankService.findAll());
    }

    @GetMapping("/{numeroConta}")
    public ResponseEntity<ContaBank> findById(@PathVariable Long id) {
        return ResponseEntity.ok(contaBankService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaBank> update(@PathVariable Long id, @RequestBody ContaBank contaBank) {
        contaBank.setId(id);
        return ResponseEntity.ok(contaBankService.update(contaBank));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contaBankService.delete(id);
        return ResponseEntity.noContent().build();
    }
}