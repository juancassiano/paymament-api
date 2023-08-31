package br.com.cassiano.payments.api.exceptionHandler;

import br.com.cassiano.payments.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.StringWriter;
import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    URI path = URI.create("http://localhost:8080/errors");
    @ExceptionHandler(CartaoExistenteException.class)
    private ResponseEntity<ProblemDetail> handleCartaoExistenteException(CartaoExistenteException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,sw.toString()
        );
        problemDetail.setInstance(URI.create("/cartao-existente"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Esse cartão já está cadastrado");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }

    @ExceptionHandler(DocumentoNaoEncontradaException.class)
    private ResponseEntity<ProblemDetail> handleDocumentoNaoEncontradaException(DocumentoNaoEncontradaException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,sw.toString()
        );
        problemDetail.setInstance(URI.create("/documento-nao-encontrado"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Esse Documento não foi encontrado");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(PagamentoNaoEncontradoException.class)
    private ResponseEntity<ProblemDetail> handlePagamentoNaoEncontradoException(PagamentoNaoEncontradoException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,sw.toString()
        );
        problemDetail.setInstance(URI.create("/pagamento-nao-encontrado"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Esse Pagamento não foi encontrado");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(PessoaFisicaNaoEncontradaException.class)
    private ResponseEntity<ProblemDetail> handlePessoaFisicaNaoEncontradaException(PessoaFisicaNaoEncontradaException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,sw.toString()
        );
        problemDetail.setInstance(URI.create("/pessoa-fisica-nao-encontrada"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Essa pessoa não foi encontrada");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(PessoaJuridicaNaoEncontradaException.class)
    private ResponseEntity<ProblemDetail> handlePessoaJuridicaNaoEncontradaException(PessoaJuridicaNaoEncontradaException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,sw.toString()
        );
        problemDetail.setInstance(URI.create("/pessoa-juridica-nao-encontrada"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Essa pessoa não foi encontrada");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    private ResponseEntity<ProblemDetail> handleRegraDeNegocioException(RegraDeNegocioException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.INTERNAL_SERVER_ERROR,sw.toString()
        );
        problemDetail.setInstance(URI.create("/regra-de-negocio"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Ocorreu um erro inexperado. Entre em contato com o adm do sistema");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
    }

    @ExceptionHandler(PessoaFisicaEmUsoException.class)
    private ResponseEntity<ProblemDetail> handleRegraDeNegocioException(PessoaFisicaEmUsoException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,sw.toString()
        );
        problemDetail.setInstance(URI.create("/documento-ja-cadastrado"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao","Esse documento já está cadatrado");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setType(path);

        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetail);
    }


}
