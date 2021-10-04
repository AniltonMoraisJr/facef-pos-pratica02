package br.edu.unifacef.atividade.model;

public class Saldo {
    private Long id;

    private Long contaId;

    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContaId() {
        return contaId;
    }

    public void setContaId(Long contaId) {
        this.contaId = contaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Saldo{" +
                "id=" + id +
                ", contaId=" + contaId +
                ", valor=" + valor +
                '}';
    }
}
