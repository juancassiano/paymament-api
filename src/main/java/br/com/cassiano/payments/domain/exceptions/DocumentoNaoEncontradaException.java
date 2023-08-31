package br.com.cassiano.payments.domain.exceptions;

public class DocumentoNaoEncontradaException extends RuntimeException {
    public DocumentoNaoEncontradaException(String documento) {
        super(String.format("Formato inválido! Digite 11 dígitos para CPF ou 14 para CNPF"));
    }
}
