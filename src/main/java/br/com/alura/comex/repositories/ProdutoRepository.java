package br.com.alura.comex.repositories;

import br.com.alura.comex.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long> {
}
