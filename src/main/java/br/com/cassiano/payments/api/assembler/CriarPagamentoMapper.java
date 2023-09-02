package br.com.cassiano.payments.api.assembler;

import br.com.cassiano.payments.api.model.request.PagamentoRequestDTO;
import br.com.cassiano.payments.domain.model.Pagamento;


public class CriarPagamentoMapper {

    public br.com.cassiano.payments.api.model.response.PagamentoResponseDTO toResponseDTO(Pagamento pagamento) {
        return new br.com.cassiano.payments.api.model.response.PagamentoResponseDTO(pagamento.getId(), pagamento.getValor(),pagamento.getStatusPagamento(),pagamento.getMetodoPagamento(), pagamento.getPessoa());
    }

    public Pagamento toPagamentoEntity(PagamentoRequestDTO requestDTO) {
        return new Pagamento(requestDTO.statusPagamento(), requestDTO.metodoPagamento(), requestDTO.pessoa(), requestDTO.valor());
    }
}
