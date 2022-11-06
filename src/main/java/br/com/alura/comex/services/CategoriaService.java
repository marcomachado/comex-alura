package br.com.alura.comex.services;

import br.com.alura.comex.controllers.dto.PedidoPorCategoriaDto;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void atualizar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Iterable<Categoria> visualizar() {
        Iterable<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria buscarPorId(Long id) {
        Categoria categoria = categoriaRepository.getReferenceById(id);
        return categoria;
    }

    public List<PedidoPorCategoriaDto> relatorioPedidoCategoria() {
        return categoriaRepository.relatorioPedidoCategoria();

    }
}
