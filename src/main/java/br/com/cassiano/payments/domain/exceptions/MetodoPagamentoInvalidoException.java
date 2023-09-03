package br.com.cassiano.payments.domain.exceptions;

public class MetodoPagamentoInvalidoException extends RuntimeException {
    public MetodoPagamentoInvalidoException(String mensagem) {
        super(String.format("Formato de pagamento %s inválido", mensagem));
    }
}
