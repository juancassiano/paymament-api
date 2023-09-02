package br.com.cassiano.payments.api.controller;

import br.com.cassiano.payments.api.assembler.CriarPessoaFisicaMapper;
import br.com.cassiano.payments.api.model.request.PessoaFisicaRequestDTO;
import br.com.cassiano.payments.api.model.response.PessoaJuridicaDTO;
import br.com.cassiano.payments.domain.model.PessoaFisica;
import br.com.cassiano.payments.domain.service.PessoaFisicaService;
import br.com.cassiano.payments.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaFisicaService pessoaFisicaService;
    @Autowired
    private CriarPessoaFisicaMapper criarPessoaFisicaMapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PessoaJuridicaDTO> listar(){

        List<PessoaFisica> pessoas = pessoaFisicaService.listar();
        return pessoas.stream().map(pessoa -> criarPessoaFisicaMapper.toResponseDTO(pessoa))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaJuridicaDTO buscarPorId(@PathVariable @Valid Long id){
       PessoaFisica pessoa = pessoaFisicaService.buscarPessoaFisica(id);
       return criarPessoaFisicaMapper.toResponseDTO(pessoa);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaJuridicaDTO criar(@RequestBody @Valid PessoaFisicaRequestDTO request){
        PessoaFisica pessoaFisica = criarPessoaFisicaMapper.toPessoaFisicaEntity(request);
        PessoaFisica pessoa = pessoaService.criarPessoaFisica(pessoaFisica);
        return criarPessoaFisicaMapper.toResponseDTO(pessoa);
    }

}
