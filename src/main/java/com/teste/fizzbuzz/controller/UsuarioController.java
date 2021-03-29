package com.teste.fizzbuzz.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Usuario adicionarUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}
		
	@GetMapping("/usuarios")
	public List <Usuario> buscarPorParametro(@RequestParam(required = false)  String email, @RequestParam (required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data, @RequestParam (required = false) Integer numero, @RequestParam (required = false) String resultado) {
		return usuarioService.buscarPorParametro(email, data, numero, resultado);
	}
}
