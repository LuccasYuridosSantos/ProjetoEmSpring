package com.generation.demonstracao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.demonstracao.model.Demonstracao;

@RestController
@RequestMapping("/demonstracao")
public class DemonstracaoController {

	Demonstracao demo1 = new Demonstracao("Persistência",
			"Necessario para continuar focado por mais que esteja dificil");
	Demonstracao demo2 = new Demonstracao("Orientação ao futuro",
			"Mentalidade essecial para poder se desenvolver e adquirir novos conhecimentos");
	Demonstracao demo3 = new Demonstracao("Trabalho em Equipe",
			"Habilidade que auxilia no desenvolvimento pessoal e coletivo");
	Demonstracao demo4 = new Demonstracao("Atenção aos Detalhes",
			"Ser atento as pequenas coisas pois delas temos grandes resultados");

	@GetMapping("/demo1")
	public String demonstracao1() {

		String txt = (String) demo1.getTipo() + ", " + demo1.getDescricao();
		return txt;
	}

	@GetMapping("/demo2")
	public String demonstracao2() {

		String txt = (String) demo2.getTipo() + ", " + demo2.getDescricao();
		return txt;
	}

	@GetMapping("/demo3")
	public String demonstracao3() {

		String txt = (String) demo3.getTipo() + ", " + demo3.getDescricao();
		return txt; 
	}

	@GetMapping("/demo4")
	public String demonstracao4() {

		String txt = (String) demo4.getTipo() + ", " + demo4.getDescricao();
		return txt;
	}
	

}
