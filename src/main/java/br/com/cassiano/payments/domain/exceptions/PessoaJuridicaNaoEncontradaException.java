package br.com.cassiano.payments.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PessoaJuridicaNaoEncontradaException extends EntityNotFoundException {
    public PessoaJuridicaNaoEncontradaException(Long id) {
        super(String.format("Não foi encontrado uma pessoa jurídica com ID: %s", id));
    }

    public PessoaJuridicaNaoEncontradaException(String cnpj) {
        super(String.format("Não foi encontrado uma pessoa jurídica com CNPJ: %s", cnpj));

    }
}
