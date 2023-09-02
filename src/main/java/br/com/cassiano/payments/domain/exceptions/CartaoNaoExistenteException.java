package br.com.cassiano.payments.domain.exceptions;

public class CartaoNaoExistenteException extends RuntimeException {
    public CartaoNaoExistenteException(String message) {
        super(message);
    }

    public CartaoNaoExistenteException(){
        super("O cartão não foi cadastrado");
    }
}
