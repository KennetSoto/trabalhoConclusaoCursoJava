package br.com.crudComSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crudComSpring.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Optional<Produto> findById(Long id);
	
}
