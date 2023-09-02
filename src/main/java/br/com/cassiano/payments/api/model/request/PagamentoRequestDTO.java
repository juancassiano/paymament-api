package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.Cartao;
import br.com.cassiano.payments.domain.model.MetodoPagamento;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.br.CNPJ;

import java.math.BigDecimal;

public record PagamentoRequestDTO(

        @NotNull
        @PositiveOrZero
        BigDecimal valor,
        @NotNull
        MetodoPagamento metodoPagamento
) {
}
