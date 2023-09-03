package br.com.cassiano.payments.api.exceptionHandler;

import br.com.cassiano.payments.domain.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.StringWriter;
import java.net.URI;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController  {

    @Autowired
    private MessageSource messageSource;
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

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    private ResponseEntity<ProblemDetail> handlePessoaFisicaNaoEncontradaException(PessoaNaoEncontradaException exception) {

        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, sw.toString()
        );
        problemDetail.setInstance(URI.create("/pessoa-nao-encontrada"));
        problemDetail.setTitle(exception.getMessage());
        problemDetail.setProperty("descricao", "Essa pessoa não foi encontrada");
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ProblemDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> errorMessages = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            String errorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            errorMessages.add(errorMessage);
        }
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                sw.toString());
        problemDetail.setTitle("Erro de validação");
        problemDetail.setProperty("timestamp", Instant.now());
        problemDetail.setProperty("errors", errorMessages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ProblemDetail> handleHttpMessageNotReadable(HttpMessageNotReadableException exception){
        StringWriter sw = new StringWriter();
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                sw.toString());
        problemDetail.setTitle("Erro de validação");
        problemDetail.setProperty("timestamp", Instant.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);

    }


}
