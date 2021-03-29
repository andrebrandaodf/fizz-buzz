package com.teste.fizzbuzz.repository;

import java.time.LocalDate;
import java.util.List;

import com.teste.fizzbuzz.entity.Usuario;

public interface UsuarioRepositoryCustom {

	List<Usuario> buscarPorParametro(String email,  LocalDate data, Integer numero, String resultado);

}
