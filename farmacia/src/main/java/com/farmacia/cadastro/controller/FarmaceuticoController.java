package com.farmacia.cadastro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.cadastro.model.entities.Farmaceutico;
import com.farmacia.cadastro.model.entities.FarmaceuticoLogin;
import com.farmacia.cadastro.service.FarmaceuticoService;

@RestController
@RequestMapping("/farmaceutico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FarmaceuticoController {
	
	@Autowired
	private FarmaceuticoService farmaceuticoService;

	@PostMapping("/logar")
	public ResponseEntity<FarmaceuticoLogin> Autentication(@RequestBody Optional<FarmaceuticoLogin> user) {
		return farmaceuticoService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Farmaceutico> Post(@RequestBody Farmaceutico farmaceutico) {
		return ResponseEntity.status(HttpStatus.CREATED).body(farmaceutico);
	}
	
	
}
