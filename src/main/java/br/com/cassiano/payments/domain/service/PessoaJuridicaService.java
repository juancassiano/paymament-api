package br.com.cassiano.payments.domain.service;

import br.com.cassiano.payments.domain.exceptions.PessoaJuridicaNaoEncontradaException;
import br.com.cassiano.payments.domain.model.PessoaJuridica;
import br.com.cassiano.payments.domain.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaJuridicaService {
    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    public PessoaJuridica buscarPorCnpj(String cnpj){
        return pessoaJuridicaRepository.findByDocumento(cnpj).orElseThrow(
                () -> new PessoaJuridicaNaoEncontradaException(cnpj)
        );
    }

    public PessoaJuridica buscarPessoaJuridica(Long id){
        return pessoaJuridicaRepository.findById(id).orElseThrow(
                () -> new PessoaJuridicaNaoEncontradaException(id)
        );
    }

    public List<PessoaJuridica> listar() {
        return pessoaJuridicaRepository.findAll();
    }
}
