package br.com.alura.comex.repositories;

import br.com.alura.comex.controllers.dto.PedidoPorCategoriaDto;
import br.com.alura.comex.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Query(value = "SELECT c.nome , COUNT(*) as quantidade, SUM(p.preco_unitario) FROM categorias c, produtos p WHERE c.id = p.categoria_id ", nativeQuery = true)
    List<PedidoPorCategoriaDto> relatorioPedidoCategoria();
}
