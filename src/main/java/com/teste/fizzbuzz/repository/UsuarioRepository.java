package com.teste.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.fizzbuzz.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {
	
}
