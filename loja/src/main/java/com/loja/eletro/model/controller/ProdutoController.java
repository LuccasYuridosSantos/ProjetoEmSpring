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

import com.loja.eletro.model.entities.Produto;
import com.loja.eletro.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAllProduto() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getByIdProduto(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.badRequest().build());
	}
	
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByAllNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("range/{valorIn}/{valorFim}")
	public ResponseEntity<List<Produto>> getByRange(@PathVariable double valorIn,@PathVariable double valorFim){
		return ResponseEntity.ok(repository.findByPrecoBetween(valorIn, valorFim));
	}
	
	
	@GetMapping("/porTipo/{tipoId}/{valor}")
	public ResponseEntity<List<Produto>> getByIdAndPreco(@PathVariable long tipoId, @PathVariable double valor){
		return ResponseEntity.ok(repository.findByTipoEletroIdAndPrecoLessThanEqual(tipoId, valor));
	}
	
	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTipoEletro(@PathVariable long id){
			repository.deleteById(id);
	}
}