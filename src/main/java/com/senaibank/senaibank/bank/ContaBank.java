package com.senaibank.senaibank.bank;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "contas_bancarias")
public class ContaBank{

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double saldo = 0.0;

    @OneToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "id")
    private Cliente cliente;

    public boolean temSaldo(double valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'temSaldo'");
    }
    
}