package br.com.cassiano.payments.domain.model;

public enum MetodoPagamento {
    BOLETO("Boleto"),
    PIX("Pix"),
    CREDITO("Credito"),
    DEBITO("Debito");

    private String descricao;

    MetodoPagamento(String descricao){
        this.descricao = descricao;
    }
}
