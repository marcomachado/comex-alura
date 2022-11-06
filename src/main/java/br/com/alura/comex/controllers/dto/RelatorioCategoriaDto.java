package br.com.alura.comex.controllers.dto;

import java.util.List;

public class RelatorioCategoriaDto {

    List<PedidoPorCategoriaDto> relatorio;

    public RelatorioCategoriaDto(List<PedidoPorCategoriaDto> relatorio) {
        this.relatorio = relatorio;
    }

    public List<PedidoPorCategoriaDto> getRelatorio() {
        return relatorio;
    }
}
