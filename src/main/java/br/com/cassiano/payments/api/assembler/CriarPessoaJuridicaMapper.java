package br.com.cassiano.payments.api.assembler;

import br.com.cassiano.payments.api.model.request.PessoaJuridicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaJuridicaResponseDTO;
import br.com.cassiano.payments.domain.model.PessoaJuridica;


public class CriarPessoaJuridicaMapper {

    public PessoaJuridicaResponseDTO toResponseDTO(PessoaJuridica pessoaJuridica) {
        return new PessoaJuridicaResponseDTO(pessoaJuridica.getId(), pessoaJuridica.getDocumento(), pessoaJuridica.getCartao(), pessoaJuridica.getRazaoSocial());
    }

    public PessoaJuridica toPessoaJuridicaEntity(PessoaJuridicaRequestDTO requestDTO) {
        return new PessoaJuridica(requestDTO.documento(), requestDTO.cartao(), requestDTO.razaoSocial());
    }
}
