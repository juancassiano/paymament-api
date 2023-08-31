package br.com.cassiano.payments.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PESSOA_FISICA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaFisica extends Pessoa {

    @Column(nullable = false)
    private String nome;

    public PessoaFisica(String documento, Cartao cartao, String nome) {
        super(documento, cartao);
        this.nome = nome;
    }
}
