package com.loja.eletro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.eletro.model.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findByPrecoBetween(double precoIn, double precoFim);
	
	public List<Produto> findByTipoEletroIdAndPrecoLessThanEqual(long tipoEletroId,double preco);
	
}
