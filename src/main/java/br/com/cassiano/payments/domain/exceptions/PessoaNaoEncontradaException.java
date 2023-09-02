package br.com.cassiano.payments.domain.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class PessoaNaoEncontradaException extends EntityNotFoundException {
    public PessoaNaoEncontradaException(Long id) {
        super(String.format("Não foi encontrado uma pessoa com ID: %s", id));
    }
    public PessoaNaoEncontradaException(String documento) {
        super(String.format("Não foi encontrado uma pessoa com CPF/CNPJ: %s", documento));
    }
}
