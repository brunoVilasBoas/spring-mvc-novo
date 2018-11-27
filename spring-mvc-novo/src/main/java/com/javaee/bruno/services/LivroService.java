package com.javaee.bruno.services;

import java.util.Set;

import com.javaee.bruno.objects.Livro;

public interface LivroService{
	
	Set<Livro> getLivros();
	
	Livro findById(Long id);
	
	Livro SalvarLivro(Livro livro);
	
	void deleteById(Long idToDeletar);
	
}