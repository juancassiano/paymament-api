package br.com.cassiano.payments.api.controller;

import br.com.cassiano.payments.api.assembler.CriarPagamentoMapper;
import br.com.cassiano.payments.api.model.request.PagamentoRequestDTO;
import br.com.cassiano.payments.api.model.response.PagamentoResponseDTO;
import br.com.cassiano.payments.domain.model.Pagamento;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import br.com.cassiano.payments.domain.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoservice;
    @Autowired
    private CriarPagamentoMapper criarPagamentoMapper;


    @PostMapping("/{documento}")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoResponseDTO criar(@Valid @RequestBody PagamentoRequestDTO request, @PathVariable String documento){
        Pagamento pagamento = criarPagamentoMapper.toPagamentoEntity(request);
        pagamentoservice.criar(pagamento, documento);
        return criarPagamentoMapper.toResponseDTO(pagamento);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<PagamentoResponseDTO> listar(){

        List<Pagamento> pagamentos = pagamentoservice.listarTodos();
        return pagamentos.stream().map(pagamento -> criarPagamentoMapper.toResponseDTO(pagamento))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PagamentoResponseDTO buscarPorCodigo(@PathVariable Long id){

        Pagamento pagamento =  pagamentoservice.buscarPorCodigo(id);
        return criarPagamentoMapper.toResponseDTO(pagamento);
    }

    @GetMapping("/status/{statusPagamento}")
    @ResponseStatus(HttpStatus.OK)
    public List<PagamentoResponseDTO> buscarPorStatus(@PathVariable StatusPagamento statusPagamento){

        List<Pagamento> pagamentos = pagamentoservice.buscarPorStatus(statusPagamento);
        return pagamentos.stream().map(pagamento -> criarPagamentoMapper.toResponseDTO(pagamento))
                .collect(Collectors.toList());
    }

    @GetMapping("/cliente/{documento}")
    @ResponseStatus(HttpStatus.OK)
    public List<PagamentoResponseDTO> buscarPorDocumento(@PathVariable String documento){
        List<Pagamento> pagamentos = pagamentoservice.buscarPorCpfOuCnpj(documento);
        return pagamentos.stream().map(pagamento -> criarPagamentoMapper.toResponseDTO(pagamento))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id){
        pagamentoservice.deletarPagamento(id);
    }

    @PutMapping("/{id}/{statusPagamento}")
    @ResponseStatus(HttpStatus.OK)
    public PagamentoResponseDTO atualizarStatusPagamento(@PathVariable Long id, @PathVariable StatusPagamento statusPagamento){

        Pagamento pagamento = pagamentoservice.atualizarStatusPagamento(id, statusPagamento);
        return criarPagamentoMapper.toResponseDTO(pagamento);
    }

}
