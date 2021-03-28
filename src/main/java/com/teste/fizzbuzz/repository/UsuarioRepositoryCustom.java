package com.teste.fizzbuzz.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.teste.fizzbuzz.entity.Usuario;

import jdk.vm.ci.meta.Local;

public interface UsuarioRepositoryCustom {

	List<Usuario> findByParameter(String email,  LocalDate date, Integer numero, String resultado);

}
