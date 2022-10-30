package br.com.alura.comex.controllers.form;

import br.com.alura.comex.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoriaForm {

    @NotNull @NotEmpty @Length(min = 2)
    private String nome;


    public Categoria converter() {
        return new Categoria(nome);
    }

    public CategoriaForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
