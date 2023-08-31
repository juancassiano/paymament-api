package br.com.cassiano.payments.domain.repository;

import br.com.cassiano.payments.domain.model.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    boolean existsByCartaoNumero(String numeroCartao);

    Optional<PessoaFisica> findByDocumento(String cpf);
}
