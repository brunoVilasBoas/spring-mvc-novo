package com.javaee.bruno.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.javaee.bruno.objects.Livro;

@Service
public abstract class LivroServiceImpl implements LivroService{
	
	private Set<Livro> livrosSalvos = new HashSet<Livro>();
	private Long actualId = 0L;
	
	public Set<Livro> getLivros(){
		return livrosSalvos;
	}
	
	public Livro findById(Long id){
		Optional<Livro> livroOptional = livrosSalvos.stream().filter(livro -> livro.getId().equals(id)).findFirst();
		return livroOptional.orElse(null);
	}
	
	public Livro salvarLivro(Livro livro){
		if(livro.getId() != null) {
			this.deleteById(livro.getId());
		}else{
			actualId++;
			livro.setId(actualId);
		}
		this.livrosSalvos.add(livro);
		return livro;
	}
	
	public void deleteById(Long idToDelete){
		this.livrosSalvos.removeIf(livro -> livro.getId().equals(idToDelete));
	}	
	
}