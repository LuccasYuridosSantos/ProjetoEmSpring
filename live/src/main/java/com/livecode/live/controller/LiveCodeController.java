package com.livecode.live.controller;

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

import com.livecode.live.model.entities.LiveCode;
import com.livecode.live.repository.LiveCodeRepository;

@RestController
@RequestMapping("/live")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class LiveCodeController {
	
	@Autowired
	private LiveCodeRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<LiveCode>> findAll(){
		
		//List<LiveCode> live = repository.findAll();
		//return ResponseEntity.ok(live);
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LiveCode> figetById(@PathVariable long id){
		return repository.findById(id).map(batata -> ResponseEntity.ok(batata))
				.orElse(ResponseEntity.badRequest().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<LiveCode>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/qtd/{valor}")
	public ResponseEntity<List<LiveCode>> findByValueBiggerThen(@PathVariable int valor){
		return ResponseEntity.ok(repository.findAllMaiorQue(valor));
	}
	
	@PostMapping
	public ResponseEntity<LiveCode> post(@RequestBody  LiveCode live){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(live));
	}
	
	
	@PutMapping
	public ResponseEntity<LiveCode> put(@RequestBody  LiveCode live){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(live));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
