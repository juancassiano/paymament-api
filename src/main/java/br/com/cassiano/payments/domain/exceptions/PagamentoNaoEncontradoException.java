package br.com.cassiano.payments.domain.exceptions;

import br.com.cassiano.payments.domain.model.StatusPagamento;
import jakarta.persistence.EntityNotFoundException;

public class PagamentoNaoEncontradoException  extends EntityNotFoundException {


    public PagamentoNaoEncontradoException(Long id){
        super(String.format("Não foi encontrado um pagamento com ID: %s", id));
    }

    public PagamentoNaoEncontradoException(String documento) {
        super(String.format("Não foi encontrado um pagamento com o documento: %s", documento));
    }

    public PagamentoNaoEncontradoException(StatusPagamento statusPagamento) {
        super(String.format("Não foi encontrado um pagamento com o status: %s", statusPagamento));

    }
}
