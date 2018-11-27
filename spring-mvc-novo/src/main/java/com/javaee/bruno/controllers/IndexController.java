package com.javaee.bruno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee.bruno.services.LivroService;

@Controller
public class IndexController {
	
	private final LivroService livroService;
	
	public IndexController(LivroService livroService){
		this.livroService = livroService;	
	}
	
	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model){
		model.addAttribute("livros", livroService.getLivros());
		
		return "index";
	}
}	