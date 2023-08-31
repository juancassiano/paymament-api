package br.com.cassiano.payments.domain.repository;

import br.com.cassiano.payments.domain.model.Pagamento;
import br.com.cassiano.payments.domain.model.Pessoa;
import br.com.cassiano.payments.domain.model.StatusPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Optional<List<Pagamento>> findByPessoa(Pessoa pessoa);

    Optional<List<Pagamento>> findByStatusPagamento(StatusPagamento statusPagamento);
}
