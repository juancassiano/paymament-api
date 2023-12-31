package br.com.cassiano.payments.infrastructure.configuration.beanConfigurations;

import br.com.cassiano.payments.api.assembler.CriarPessoaFisicaMapper;
import br.com.cassiano.payments.api.assembler.CriarPessoaJuridicaMapper;
import br.com.cassiano.payments.api.assembler.CriarPagamentoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    CriarPessoaFisicaMapper criarPessoaFisicaMapper() {
        return new CriarPessoaFisicaMapper();
    }

    @Bean
    CriarPessoaJuridicaMapper criarPessoaJuridicaMapper() {
        return new CriarPessoaJuridicaMapper();
    }

    @Bean
    CriarPagamentoMapper criarPagamentoMapper() {
        return new CriarPagamentoMapper();
    }


}
