package br.com.cassiano.payments.api.model.response;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record PessoaJuridicaResponseDTO(
        Long id,
        String documento,
        String cartao,
        String razaoSocial
) {
}
