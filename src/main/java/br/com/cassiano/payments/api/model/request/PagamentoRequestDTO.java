package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.MetodoPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PagamentoRequestDTO(

        @NotNull
        @Positive(message = "{valor.obrigatorio}")
        BigDecimal valor,
        @NotNull(message = "{metodoPagamento.obrigatorio}")
        MetodoPagamento metodoPagamento
) {
}
