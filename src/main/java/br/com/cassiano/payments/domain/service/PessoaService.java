package br.com.cassiano.payments.domain.service;

import br.com.cassiano.payments.domain.exceptions.*;
import br.com.cassiano.payments.domain.model.*;
import br.com.cassiano.payments.domain.repository.PessoaFisicaRepository;
import br.com.cassiano.payments.domain.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaService(PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public PessoaFisica criarPessoaFisica(PessoaFisica pessoaFisica){
        Optional<PessoaFisica> pessoa = pessoaFisicaRepository.findByDocumento(pessoaFisica.getDocumento());

        if(existeCartao(pessoaFisica.getCartao().getNumero())){
            throw new CartaoExistenteException("O cartão já está cadastrado");
        }
        if(pessoa.isPresent()){
            throw new PessoaFisicaEmUsoException(pessoaFisica.getDocumento());
        }
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaJuridica criarPessoaJuridica(PessoaJuridica pessoaJuridica) {
        if (existeCartao(pessoaJuridica.getCartao().getNumero())) {
            throw new CartaoExistenteException("O cartão já está cadastrado");
        }
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaFisica adicionarCartaoPessoaFisica(Long pessoaId, Cartao cartao) {
        PessoaFisica pessoa = pessoaFisicaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));

        existeCartao(pessoa, cartao);

        pessoa.setCartao(cartao);
        return pessoaFisicaRepository.save(pessoa);
    }

    public PessoaJuridica adicionarCartaoPessoaJuridica(Long pessoaId, Cartao cartao){
        PessoaJuridica pessoa = pessoaJuridicaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaNaoEncontradaException(pessoaId));

        existeCartao(pessoa, cartao);

        pessoa.setCartao(cartao);
        return pessoaJuridicaRepository.save(pessoa);
    }

    public Pessoa buscarPorCpfOuCnpj(String documento){
        if(documento.length() == 14){
            return pessoaJuridicaRepository.findByDocumento(documento).orElseThrow(
                    () -> new PessoaNaoEncontradaException(documento)
            );
        }
        else if(documento.length() == 11){
          return pessoaFisicaRepository.findByDocumento(documento).orElseThrow(
                    () -> new PessoaNaoEncontradaException(documento)
            );
        }else{
            throw new DocumentoNaoEncontradaException(documento);
        }
    }



    private boolean existeCartao(String numeroCartao) {
        return pessoaFisicaRepository.existsByCartaoNumero(numeroCartao) ||
                pessoaJuridicaRepository.existsByCartaoNumero(numeroCartao);
    }

private void existeCartao(Pessoa pessoa, Cartao cartao) {
    String numeroCartao = cartao.getNumero();

    if(pessoaFisicaRepository.existsByCartaoNumero(numeroCartao) ||
                pessoaJuridicaRepository.existsByCartaoNumero(numeroCartao)){
            throw new CartaoExistenteException("O cartão já está cadastrado");
        }
    pessoa.setCartao(cartao);
    }
}
