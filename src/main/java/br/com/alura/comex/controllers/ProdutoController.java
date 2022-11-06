package br.com.alura.comex.controllers;

import br.com.alura.comex.controllers.dto.ProdutoDto;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repositories.CategoriaRepository;
import br.com.alura.comex.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid ProdutoForm form){
        Produto produto = form.converter(categoriaRepository);
        produtoRepository.save(produto);
     }

    @GetMapping
    public List<ProdutoDto> lista() {
        Iterable<Produto> produtos = produtoRepository.findAll();

        return ProdutoDto.converter((List<Produto>) produtos);
    }
}
