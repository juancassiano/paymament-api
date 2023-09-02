package br.com.cassiano.payments.api.assembler;

import br.com.cassiano.payments.api.model.request.PessoaJuridicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaJuridicaDTO;
import br.com.cassiano.payments.domain.model.PessoaJuridica;


public class CriarPessoaJuridicaMapper {

    public PessoaJuridicaDTO toResponseDTO(PessoaJuridica pessoaJuridica) {
        return new PessoaJuridicaDTO(pessoaJuridica.getId(), pessoaJuridica.getDocumento(), pessoaJuridica.getCartao(), pessoaJuridica.getRazaoSocial());
    }

    public PessoaJuridica toPessoaJuridicaEntity(PessoaJuridicaRequestDTO requestDTO) {
        return new PessoaJuridica(requestDTO.documento(), requestDTO.cartao(), requestDTO.razaoSocial());
    }
}
