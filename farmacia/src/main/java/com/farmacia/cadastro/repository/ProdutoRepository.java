package com.farmacia.cadastro.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.farmacia.cadastro.model.entities.Produto;

@Repository
public interface ProdutoRepository {

	
	public List<Produto> findAllByDescricaoContainingIgnoreCase(String produto);
	
}
