package br.com.cassiano.payments.domain.service;

import br.com.cassiano.payments.domain.exceptions.PessoaNaoEncontradaException;
import br.com.cassiano.payments.domain.model.PessoaFisica;
import br.com.cassiano.payments.domain.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {
    private final PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
    }

    public PessoaFisica buscarPorCpf(String cpf){
        return pessoaFisicaRepository.findByDocumento(cpf).orElseThrow(
                () -> new PessoaNaoEncontradaException(cpf)
        );
    }

    public List<PessoaFisica> listar(){
        return pessoaFisicaRepository.findAll();    }

    public PessoaFisica buscarPessoaFisica(Long id){
        return pessoaFisicaRepository.findById(id).orElseThrow(
                () -> new PessoaNaoEncontradaException(id)
        );
    }
}
