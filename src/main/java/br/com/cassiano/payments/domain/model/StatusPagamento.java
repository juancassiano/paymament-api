package br.com.cassiano.payments.domain.model;

public enum StatusPagamento {
    SUCESSO("Pago com sucesso"),
    PENDENTE("Pagamento pendente"),
    FALHA("Falha no pagamento");

    private String descricao;

    StatusPagamento(String descricao){
        this.descricao = descricao;
    }
}
