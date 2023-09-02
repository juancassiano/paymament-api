package br.com.cassiano.payments.api.controller;

import br.com.cassiano.payments.api.assembler.CriarPessoaJuridicaMapper;
import br.com.cassiano.payments.api.model.request.PessoaJuridicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaJuridicaDTO;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.PessoaFisica;
import br.com.cassiano.payments.domain.model.PessoaJuridica;
import br.com.cassiano.payments.domain.service.PessoaFisicaService;
import br.com.cassiano.payments.domain.service.PessoaJuridicaService;
import br.com.cassiano.payments.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/pessoas-juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;
    @Autowired
    private CriarPessoaJuridicaMapper criarPessoaJuridicaMapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PessoaJuridicaDTO> listar(){
        List<PessoaJuridica> pessoas = pessoaJuridicaService.listar();

        return pessoas.stream().map(pessoa -> criarPessoaJuridicaMapper.toResponseDTO(pessoa))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaJuridicaDTO buscarPorId(@PathVariable @Valid Long id){
        PessoaJuridica pessoaJuridica = pessoaJuridicaService.buscarPessoaJuridica(id);
        return criarPessoaJuridicaMapper.toResponseDTO(pessoaJuridica);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaJuridicaDTO criar(@RequestBody @Valid PessoaJuridicaRequestDTO request){
        PessoaJuridica pessoaJuridica= criarPessoaJuridicaMapper.toPessoaJuridicaEntity(request);
        PessoaJuridica pessoa = pessoaService.criarPessoaJuridica(pessoaJuridica);
        return criarPessoaJuridicaMapper.toResponseDTO(pessoa);
    }

}
