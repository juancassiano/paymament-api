package br.com.cassiano.payments.api.model.response;

import br.com.cassiano.payments.domain.model.Cartao;
import br.com.cassiano.payments.domain.model.MetodoPagamento;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.StatusPagamento;

import java.math.BigDecimal;

public record PessoaFisicaResponseDTO(
        Long id,
        String documento,
        Cartao cartao,
        String nome

) {

}
