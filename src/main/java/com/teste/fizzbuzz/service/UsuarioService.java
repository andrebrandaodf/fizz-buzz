package com.teste.fizzbuzz.service;

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
	
}
