package br.com.alura.comex.controllers;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repositories.CategoriaRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoForm {

    @NotNull
    @NotEmpty
    @Length(min = 2)
    private String nome;
    private String descricao;
    @NotNull
    @NotEmpty
    @Min(0)
    private BigDecimal precoUnitario;
    @NotNull
    @NotEmpty
    @Min(0)
    private int quantidadeEstoque;
    @NotNull
    @NotEmpty
    private Long idCategoria;

    public ProdutoForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Produto converter(CategoriaRepository categoriaRepository) {
        Categoria c = categoriaRepository.getReferenceById(idCategoria);
        return new Produto(nome, descricao,
                precoUnitario, quantidadeEstoque, c);
    }
}
