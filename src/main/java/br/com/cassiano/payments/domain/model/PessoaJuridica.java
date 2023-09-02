package br.com.cassiano.payments.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PESSOA_JURIDICA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaJuridica extends Pessoa{

    @Column(nullable = false, unique = true)
    private String razaoSocial;

    public PessoaJuridica(String documento, Cartao cartao, String razaoSocial){
        super(documento, cartao);
        this.razaoSocial = razaoSocial;
    }

}
