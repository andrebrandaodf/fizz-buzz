package com.teste.fizzbuzz.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.fizzbuzz.entity.Usuario;
import com.teste.fizzbuzz.service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario addUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> findAll(){
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario findUsuarioById(@PathVariable Long id) {
		return usuarioService.getUsuarioById(id);
	}
}
