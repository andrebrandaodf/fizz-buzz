package com.teste.fizzbuzz.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.fizzbuzz.entity.Usuario;
import com.teste.fizzbuzz.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Usuario saveUsuario(Usuario usuario) {
		usuario.setDate(new Date());
		usuario.setResultado(conversaoMultiplos(usuario.getNumeroChamado()));
		return repository.save(usuario);
	}
	
	public List<Usuario> getUsuarios(){
		return repository.findAll();
	}
	
	public Usuario getUsuarioById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public Usuario getUsuarioByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	private boolean verificarMultiplos(Integer valor, Integer multiplo) {
		return (valor % multiplo) == 0;
	}	
	
	private String conversaoMultiplos(Integer numero) {
		
		StringBuilder resposta = new StringBuilder("");
		
		if(verificarMultiplos(numero, 3)) {
			resposta.append("Fizz");
		}
		
		if(verificarMultiplos(numero, 5)) {
			resposta.append("Buzz");
		}
		
		if (resposta.length() == 0) {
			resposta.append(Integer.toString(numero));
		}
		return resposta.toString();
	}
}
