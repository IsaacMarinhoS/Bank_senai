package com.senaibank.senaibank.bank;

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


    private Double saldo = 0.0;

    @OneToOne
    @JoinColumn( name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;
    
}