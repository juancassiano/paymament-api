package br.com.cassiano.payments.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PessoaFisicaNaoEncontradaException extends EntityNotFoundException {
    public PessoaFisicaNaoEncontradaException(Long id) {
        super(String.format("Não foi encontrado uma pessoa física com ID: %s", id));
    }
    public PessoaFisicaNaoEncontradaException(String cpf) {
        super(String.format("Não foi encontrado uma pessoa física com CPF: %s", cpf));
    }
}
