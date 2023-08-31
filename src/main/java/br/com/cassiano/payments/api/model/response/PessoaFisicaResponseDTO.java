package br.com.cassiano.payments.api.model.response;

import br.com.cassiano.payments.domain.model.Cartao;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaFisicaResponseDTO(
        Long id,
        String documento,
        Cartao cartao,
        String nome
) {
}
