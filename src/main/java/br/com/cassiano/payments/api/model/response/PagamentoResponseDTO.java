package br.com.cassiano.payments.api.model.response;

import br.com.cassiano.payments.domain.model.MetodoPagamento;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PagamentoResponseDTO(
        Long id,
        BigDecimal valor,
        StatusPagamento statusPagamento,
        MetodoPagamento metodoPagamento,

        Pessoa pessoa
) {

}
