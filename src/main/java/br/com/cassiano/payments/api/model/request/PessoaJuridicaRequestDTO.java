package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.Cartao;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaJuridicaRequestDTO(
        @NotNull(message = "{documento.obrigaorio}")
        @CNPJ(message = "{documento.invalido}")
        String documento,
        Cartao cartao,
        @NotNull(message = "{razaoSocial.obrigatorio}")
        String razaoSocial
) {
}
