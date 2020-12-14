package com.loja.eletro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loja.eletro.model.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {	
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
}
