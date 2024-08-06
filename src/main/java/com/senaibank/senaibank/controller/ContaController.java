package com.senaibank.senaibank.controller;

import com.senaibank.senaibank.bank.Conta;
import com.senaibank.senaibank.service.ContaBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contas")
public class ContaController {

    @Autowired
    private ContaBankService contaService;
    
    @PostMapping
    public ResponseEntity<Conta> criarConta(@RequestBody Conta conta){
        Conta novaConta = contaService.create(conta);
        return ResponseEntity.ok(novaConta);
    }
    @GetMapping
    public ResponseEntity<List<Conta>> listadeContas(){
        List<Conta> contas = contaService.getAll();
        return ResponseEntity.ok(contas);
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarContasPorId(@PathVariable Long id){
     Conta conta = contaService.findById(id);
     if (conta == null) {
        return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(conta);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conta> atualizarConta(@PathVariable Long id, @RequestBody Conta contaAtualizada){
       Conta conta = contaService.findById(id);
       if (conta == null) {
        return null;
        }
        conta.setSaldo(contaAtualizada.getSaldo());
        return ResponseEntity.ok(conta);

      
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){
       Conta conta = contaService.findById(id);
       if (conta == null) {
        return ResponseEntity.notFound().build();
        
       }
       contaService.delete(id);
       return ResponseEntity.noContent().build();
    }


}