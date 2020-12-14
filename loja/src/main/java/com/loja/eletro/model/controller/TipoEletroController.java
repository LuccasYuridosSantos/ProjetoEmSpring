package com.loja.eletro.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.eletro.model.entities.TipoEletro;
import com.loja.eletro.repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipo")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoEletroController {

	@Autowired
	private TipoEletroRepository repository;

	@GetMapping
	public ResponseEntity<List<TipoEletro>> getAllTipoEletro() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> getByIdTipoEletro(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build());
	}
	
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TipoEletro>> getByAllDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	
	@PostMapping
	public ResponseEntity<TipoEletro> post(@RequestBody TipoEletro eletro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(eletro));
	}
	
	@PutMapping
	public ResponseEntity<TipoEletro> put(@RequestBody TipoEletro eletro){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(eletro));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id){
			repository.deleteById(id);
	}
}