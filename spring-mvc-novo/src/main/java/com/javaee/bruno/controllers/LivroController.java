package com.javaee.bruno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaee.bruno.objects.Livro;
import com.javaee.bruno.services.LivroService;

@Controller
@RequestMapping(LivroController.BASE_URL)
public class LivroController {
	
	public static final String BASE_URL = "/livro";
	
	private final LivroService livroService;
	
	public LivroController(LivroService livroService){
		this.livroService = livroService;	
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable Long id, Model model){
		model.addAttribute("livro", livroService.findById(id));
		
		return "livro/show";
	}
	
	@GetMapping("/novo")
	public String novoLivro(Model model){
		model.addAttribute("livro", new Livro());
		
		return "livro/livroform";
	}
	
	@GetMapping("/{id}/atualizar")
	public String atualizarLivros(@PathVariable Long id, Model model){
		model.addAttribute("livro", livroService.findById(id));
		
		return "livro/livroform";
	}
	
	@PostMapping("/")
	public String salvarOuAtualizar(@ModelAttribute Livro livro){
		Livro livroSalvo = livroService.SalvarLivro(livro);
		
		return "redirecionar:/book/" + livroSalvo.getId();
	}
	
	@GetMapping("/{if/deletar}")
	public String deleteById(@PathVariable String id){
		livroService.deleteById(Long.valueOf(id));
		return "redirect:/";
	}
	
}