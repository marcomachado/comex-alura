package br.com.alura.comex.controllers.dto;

import br.com.alura.comex.model.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {

    private Long id;
    private String nome;

    public CategoriaDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(categoria -> new CategoriaDto(categoria.getId(), categoria.getNome()))
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
