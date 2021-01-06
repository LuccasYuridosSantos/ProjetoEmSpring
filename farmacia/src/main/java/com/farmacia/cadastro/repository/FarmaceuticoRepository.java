package com.farmacia.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.cadastro.model.entities.Farmaceutico;

@Repository
public interface FarmaceuticoRepository extends JpaRepository<Farmaceutico, Long> {
	
	public Optional<Farmaceutico> findByUsuario(String farmaceutico);
	
}
