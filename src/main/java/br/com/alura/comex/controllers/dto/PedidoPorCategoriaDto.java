package br.com.alura.comex.controllers.dto;

public class PedidoPorCategoriaDto {
    private String nomeCategoria;
    private Integer quantidadeVendida;
    private Double montanteVendido;

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public Double getMontanteVendido() {
        return montanteVendido;
    }

    public void setMontanteVendido(Double montanteVendido) {
        this.montanteVendido = montanteVendido;
    }
}
