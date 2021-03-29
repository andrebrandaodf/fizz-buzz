package com.teste.fizzbuzz.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;

import com.teste.fizzbuzz.entity.Usuario;

public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom{

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Usuario> buscarPorParametro(String email, LocalDate data, Integer numero, String resultado){ 
		String hql = criarHql(email, data, numero, resultado);
		
		return criarQuery(hql, email, data, numero, resultado).getResultList();
	}
	
	private Query<Usuario> criarQuery(String hql, String email, LocalDate data, Integer numero, String resultado){
		Query<Usuario> query = (Query<Usuario>) entityManager.createQuery(hql, Usuario.class);
		
		if(!verificarParametroVazio(email)) {
			query.setParameter("email", email);
		}

		if(!verificarParametroVazio(data)) {
			query.setParameter("data", data);
		}

		if(!verificarParametroVazio(numero)) {
			query.setParameter("numero", numero);
		}

		if(!verificarParametroVazio(resultado)) {
			query.setParameter("resultado", resultado);
		}
		
		return query;
	}
	
	private String criarHql(String email, LocalDate data, Integer numero, String resultado){ 
		StringBuilder hql = new StringBuilder("Select u from Usuario u");

		boolean whereAdicionado = false;

		if(!verificarParametroVazio(email)) {
			hql.append(whereAdicionado?" and ": " where ");
			hql.append("email=:email");
			if(!whereAdicionado) {
				whereAdicionado = true;
			}
		}

		if(!verificarParametroVazio(data)) {
			hql.append(whereAdicionado?" and ": " where ");
			hql.append("date=:date");
			if(!whereAdicionado) {
				whereAdicionado = true;
			}
		}

		if(!verificarParametroVazio(numero)) {
			hql.append(whereAdicionado?" and ": " where ");
			hql.append("numero=:numero");
			if(!whereAdicionado) {
				whereAdicionado = true;
			}
		}

		if(!verificarParametroVazio(resultado)) {
			hql.append(whereAdicionado?" and ": " where ");
			hql.append("resultado=:resultado");
			if(!whereAdicionado) {
				whereAdicionado = true;
			}
		}
		return hql.toString();	
	}

	private boolean verificarParametroVazio(String parametro){
		return parametro == null || parametro.isEmpty();
	}

	private boolean verificarParametroVazio(LocalDate parametro){
		return parametro == null;
	}

	private boolean verificarParametroVazio(Integer parametro){
		return parametro == null;
	}
	
}

