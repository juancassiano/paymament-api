package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.MetodoPagamento;
import br.com.cassiano.payments.infrastructure.configuration.validation.ValidMetodoPagamento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record PagamentoRequestDTO(

        @NotNull
        @Positive(message = "{valor.obrigatorio}")
        BigDecimal valor,
        @ValidMetodoPagamento()
        MetodoPagamento metodoPagamento
) {
}
