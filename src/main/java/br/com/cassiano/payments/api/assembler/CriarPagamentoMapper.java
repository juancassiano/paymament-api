package br.com.cassiano.payments.api.assembler;

import br.com.cassiano.payments.api.model.request.PessoaFisicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaJuridicaDTO;
import br.com.cassiano.payments.domain.model.PessoaFisica;


public class CriarPagamentoMapper {

    public PessoaJuridicaDTO toResponseDTO(PessoaFisica pessoaFisica) {
        return new PessoaJuridicaDTO(pessoaFisica.getId(), pessoaFisica.getDocumento(), pessoaFisica.getCartao(), pessoaFisica.getNome());
    }

    public PessoaFisica toPessoaFisicaEntity(PessoaFisicaRequestDTO requestDTO) {
        return new PessoaFisica(requestDTO.documento(), requestDTO.cartao(), requestDTO.nome());
    }
}
