package br.com.cassiano.payments.api.assembler;

import br.com.cassiano.payments.api.model.request.PessoaFisicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaFisicaResponseDTO;
import br.com.cassiano.payments.domain.model.PessoaFisica;


public class CriarPessoaFisicaMapper {

    public PessoaFisicaResponseDTO toResponseDTO(PessoaFisica pessoaFisica) {
        return new PessoaFisicaResponseDTO(pessoaFisica.getId(), pessoaFisica.getDocumento(), pessoaFisica.getCartao(), pessoaFisica.getNome());
    }

    public PessoaFisica toPessoaFisicaEntity(PessoaFisicaRequestDTO requestDTO) {
        return new PessoaFisica(requestDTO.documento(), requestDTO.cartao(), requestDTO.nome());
    }
}
