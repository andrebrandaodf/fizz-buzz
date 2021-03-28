package com.teste.fizzbuzz.repository;

import java.time.LocalDate;
import java.util.List;

import com.teste.fizzbuzz.entity.Usuario;

public interface UsuarioRepositoryCustom {

	List<Usuario> findByParameter(String email,  LocalDate date, Integer numero, String resultado);

}
