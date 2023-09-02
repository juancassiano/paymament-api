package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.Cartao;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaJuridicaRequestDTO(
        @NotNull @CNPJ
        String documento,
        Cartao cartao,
        @NotNull
        String razaoSocial
) {
}
