package com.senaibank.senaibank.bank;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@EqualsAndHashCode(of = "id")
@Entity
@Data
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double saldo = 0.0;

    @OneToOne
    @JoinColumn(name = "Clientes_id", referencedColumnName = " id")
    private Cliente cliente;

    public boolean temSaldo(Object valor) {
        throw new UnsupportedOperationException("Unimplemented method 'temSaldo'");
    }

}