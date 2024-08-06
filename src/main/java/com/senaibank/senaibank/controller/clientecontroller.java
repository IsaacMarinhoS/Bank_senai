package com.senaibank.senaibank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senaibank.senaibank.bank.Cliente;
import com.senaibank.senaibank.service.ClienteService;


@RestController
@RequestMapping("clientes")
public class clientecontroller {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criarClientes(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.create(cliente);
        return ResponseEntity.ok(novoCliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteAtualizar = clienteService.getById(id);
        if (clienteAtualizar == null) {
            return null;

        }
        if (clienteAtualizar.getNome() != null) {
            clienteAtualizar.setNome(cliente.getNome());

        }
        if (clienteAtualizar.getCpf() != null) {
            clienteAtualizar.setCpf(cliente.getCpf());

        }
        if (clienteAtualizar.getTelefone() != null) {
            clienteAtualizar.setTelefone(cliente.getTelefone());

        }
        if (clienteAtualizar.getDatanascimento() != null) {
            clienteAtualizar.setDatanascimento(cliente.getDatanascimento());
            
        }
        if (clienteAtualizar.getEndereco() != null) {
            clienteAtualizar.setEndereco(cliente.getEndereco());
            
        }
        if (clienteAtualizar.getEmail() != null) {
            clienteAtualizar.setEmail(cliente.getEmail());
            
        }

        clienteService.create(clienteAtualizar);
        return ResponseEntity.ok(clienteService.getById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();

        }
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}