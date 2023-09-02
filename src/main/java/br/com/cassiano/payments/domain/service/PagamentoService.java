package br.com.cassiano.payments.domain.service;

import br.com.cassiano.payments.domain.exceptions.*;
import br.com.cassiano.payments.domain.model.MetodoPagamento;
import br.com.cassiano.payments.domain.model.Pagamento;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import br.com.cassiano.payments.domain.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    private final PessoaService pessoaService;
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PessoaService pessoaService, PagamentoRepository pagamentoRepository) {
        this.pessoaService = pessoaService;
        this.pagamentoRepository = pagamentoRepository;
    }


    public Pagamento criar(Pagamento pagamento, String documentoPessoa){
        Pessoa pessoa = pessoaService.buscarPorCpfOuCnpj(documentoPessoa);
        if(pessoa == null) {
            throw new PessoaNaoEncontradaException(documentoPessoa);

        }
        pagamento.setPessoa(pessoa);
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento atualizarStatusPagamento(Long pagamentoId, StatusPagamento novoStatus) {
                Pagamento pagamento = pagamentoRepository.findById(pagamentoId)
                .orElseThrow(() -> new PagamentoNaoEncontradoException(pagamentoId));

        if (pagamento.getStatusPagamento() == StatusPagamento.PENDENTE) {
            if (novoStatus == StatusPagamento.SUCESSO || novoStatus == StatusPagamento.FALHA) {
                pagarComCartao(pagamento);
                pagamento.setStatusPagamento(novoStatus);
                pagamentoRepository.save(pagamento);
            }
        } else if (pagamento.getStatusPagamento() == StatusPagamento.FALHA && novoStatus == StatusPagamento.PENDENTE) {
            pagamento.setStatusPagamento(novoStatus);
            pagamentoRepository.save(pagamento);

        }else{
            throw new RegraDeNegocioException("Não foi possível alterar o status do seu pagamento");
        }
        return pagamento;
    }
    public List<Pagamento> listarTodos(){
        return pagamentoRepository.findAll();
    }

    public List<Pagamento> buscarPorCpfOuCnpj(String documento){
        Pessoa pessoa = pessoaService.buscarPorCpfOuCnpj(documento);
        return pagamentoRepository.findByPessoa(pessoa).orElseThrow(
                () -> new PagamentoNaoEncontradoException(documento)
        );
    }

    public List<Pagamento> buscarPorStatus(StatusPagamento statusPagamento){
        return pagamentoRepository.findByStatusPagamento(statusPagamento).orElseThrow(
                () -> new PagamentoNaoEncontradoException(statusPagamento)
        );
    }

    @Transactional
    public void deletarPagamento(Long pagamentoId){
        Pagamento pagamentoAtual = buscarPorCodigo(pagamentoId);

        if(!pagamentoAtual.getStatusPagamento().equals(StatusPagamento.PENDENTE)){
            throw new RegraDeNegocioException("Pagamento com Status em Falha ou Sucesso" +
                    "não pode ser excluído");
        }
        pagamentoRepository.delete(pagamentoAtual);
    }

    public Pagamento buscarPorCodigo(Long pagamentoId){
        return pagamentoRepository.findById(pagamentoId).orElseThrow(
                () -> new PagamentoNaoEncontradoException(pagamentoId)
        );
    }

    public void pagarComCartao(Pagamento pagamento){
        if((pagamento.getMetodoPagamento() == MetodoPagamento.CREDITO) || (pagamento.getMetodoPagamento() == MetodoPagamento.DEBITO)){
            if(pagamento.getPessoa().getCartao().getNumero() == null){
                throw new CartaoNaoExistenteException();
            }
            pagamento.setStatusPagamento(StatusPagamento.SUCESSO);
            pagamentoRepository.save(pagamento);
        }

    }
}
