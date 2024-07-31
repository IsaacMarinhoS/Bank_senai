package com.senaibank.senaibank.bank;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "clientes")
public class ContaBank{


    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroDaConta;

    @Column()
    private Double saldo;

    @ManyToMany
    private Cliente cliente;
    
}