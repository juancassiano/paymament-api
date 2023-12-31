package br.com.cassiano.payments.domain.exceptions;

public class CartaoExistenteException extends RuntimeException {
    public CartaoExistenteException(String message) {
        super(message);
    }

    public CartaoExistenteException(){
        super("O cartão já está cadastrado");
    }
}
