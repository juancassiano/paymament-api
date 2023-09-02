package br.com.cassiano.payments.api.model.request;

import br.com.cassiano.payments.domain.model.Cartao;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaFisicaRequestDTO(
        @NotNull(message = "{documento.obrigaorio}")
        @CPF(message = "{documento.invalido}")
        String documento,

        Cartao cartao,
        @NotNull(message = "{nome.obrigatorio}")
        String nome
) {
}
