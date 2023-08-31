package br.com.cassiano.payments.api.controller;

import br.com.cassiano.payments.domain.model.Pagamento;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import br.com.cassiano.payments.domain.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoservice;


    @PostMapping("/{documento}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento criar(@RequestBody @Valid Pagamento pagamento, @PathVariable String documento){
        return pagamentoservice.criar(pagamento, documento);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> listar(){
        return pagamentoservice.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento buscarPorCodigo(@PathVariable Long id){
        return pagamentoservice.buscarPorCodigo(id);
    }

    @GetMapping("/status/{statusPagamento}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> buscarPorStatus(@PathVariable StatusPagamento statusPagamento){
        return pagamentoservice.buscarPorStatus(statusPagamento);
    }

    @GetMapping("/cliente/{documento}")
    @ResponseStatus(HttpStatus.OK)
    public List<Pagamento> buscarPorDocumento(@PathVariable String documento){
        return pagamentoservice.buscarPorCpfOuCnpj(documento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id){
        pagamentoservice.deletarPagamento(id);
    }

    @PutMapping("/{id}/{statusPagamento}")
    @ResponseStatus(HttpStatus.OK)
    public Pagamento atualizarStatusPagamento(@PathVariable Long id, @PathVariable StatusPagamento statusPagamento){

        return pagamentoservice.atualizarStatusPagamento(id, statusPagamento);
    }

}
