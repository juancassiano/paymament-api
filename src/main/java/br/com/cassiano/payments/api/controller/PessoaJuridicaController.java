package br.com.cassiano.payments.api.controller;

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

@RestController()
@RequestMapping("/pessoas-juridica")
public class PessoaJuridicaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<PessoaJuridica> listar(){

        return pessoaJuridicaService.listar();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PessoaJuridica buscarPorId(@PathVariable @Valid Long id){
        return pessoaJuridicaService.buscarPessoaJuridica(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaJuridica criar(@RequestBody @Valid PessoaJuridica pessoaJuridicaService){
        return pessoaService.criarPessoaJuridica(pessoaJuridicaService);
    }

}
