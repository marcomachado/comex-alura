package br.com.alura.comex.services;

import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repositories.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaService crudCategoriaService;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaService crudCategoriaService) {
        this.produtoRepository = produtoRepository;
        this.crudCategoriaService = crudCategoriaService;
    }

    public void salvar(Produto produto) {

        produtoRepository.save(produto);
    }

    public void atualizar(Produto produto) {
        produtoRepository.save(produto);
    }

    public Iterable<Produto> visualizar(Integer page) {
        Sort sort = Sort.by(
                Sort.Order.asc("nome"));
        Pageable pageable = PageRequest.of(page, 5, sort);

        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos;
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }
}
