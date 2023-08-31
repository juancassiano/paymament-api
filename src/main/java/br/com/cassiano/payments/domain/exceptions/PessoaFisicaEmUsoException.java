package br.com.cassiano.payments.domain.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class PessoaFisicaEmUsoException extends DataIntegrityViolationException {
    public PessoaFisicaEmUsoException(String cpf) {
        super(String.format("A pessoa física com CPF: %s já está cadastrada", cpf));
    }
}
