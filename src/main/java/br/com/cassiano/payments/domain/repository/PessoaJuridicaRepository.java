package br.com.cassiano.payments.domain.repository;

import br.com.cassiano.payments.domain.model.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {
    boolean existsByCartaoNumero(String numeroCartao);

    Optional<PessoaJuridica> findByDocumento(String cnpj);
}
