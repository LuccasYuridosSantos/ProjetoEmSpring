package com.generation.firstproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generation")
public class GenerationController {

	@GetMapping
	public String GenerationExp() {
		String text = "Iniciando um projeto em spring";

		return text;
	}
}
