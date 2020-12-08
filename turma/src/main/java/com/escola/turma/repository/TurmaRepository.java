package com.escola.turma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.turma.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	public List<Turma> findAllByTurmaContainingIgnoreCase(String turma);
}
