package br.com.cassiano.payments.infrastructure.configuration;

import br.com.cassiano.payments.api.assembler.CriarPessoaFisicaMapper;
import br.com.cassiano.payments.api.assembler.CriarPessoaJuridicaMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    CriarPessoaFisicaMapper criarPessoaFisicaMapper() {
        return new CriarPessoaFisicaMapper();
    }

    @Bean
    CriarPessoaJuridicaMapper criarPessoaJuridicaMapper() {
        return new CriarPessoaJuridicaMapper();
    }
}
