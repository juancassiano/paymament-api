package br.com.cassiano.payments.api.model.response;

import br.com.cassiano.payments.domain.model.Cartao;

public record PessoaJuridicaDTO(
        Long id,
        String documento,
        Cartao cartao,
        String nome
) {
}
