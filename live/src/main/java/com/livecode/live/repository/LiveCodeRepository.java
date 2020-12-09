package com.livecode.live.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livecode.live.model.entities.LiveCode;

@Repository
public interface LiveCodeRepository  extends JpaRepository<LiveCode, Long>{	
	
	public List<LiveCode> findAllByTituloContainingIgnoreCase(String titulo);
	
	@Query(value = "select * from tb_live where qtd_participantes > :valor", nativeQuery = true)
	public List<LiveCode> findAllMaiorQue (@Param("valor") int valor);
}
