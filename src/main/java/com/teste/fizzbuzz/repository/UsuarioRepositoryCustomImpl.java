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
	
	public List<Usuario> findByParameter(String email, LocalDate date, Integer numero, String resultado){ 
		String hql = createHql(email, date, numero, resultado);
		
		return createQuery(hql, email, date, numero, resultado).getResultList();
	}
	
	private Query<Usuario> createQuery(String hql, String email, LocalDate date, Integer numero, String resultado){
		Query<Usuario> query = (Query<Usuario>) entityManager.createQuery(hql, Usuario.class);
		
		if(!verificarParametroVazio(email)) {
			query.setParameter("email", email);
		}

		if(!verificarParametroVazio(date)) {
			query.setParameter("date", date);
		}

		if(!verificarParametroVazio(numero)) {
			query.setParameter("numero", numero);
		}

		if(!verificarParametroVazio(resultado)) {
			query.setParameter("resultado", resultado);
		}
		
		return query;
	}
	
	private String createHql(String email, LocalDate date, Integer numero, String resultado){ 
		StringBuilder hql = new StringBuilder("Select u from Usuario u");

		boolean whereAdicionado = false;

		if(!verificarParametroVazio(email)) {
			hql.append(whereAdicionado?" and ": " where ");
			hql.append("email=:email");
			if(!whereAdicionado) {
				whereAdicionado = true;
			}
		}

		if(!verificarParametroVazio(date)) {
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

	private boolean verificarParametroVazio(String parameter){
		return parameter == null || parameter.isEmpty();
	}

	private boolean verificarParametroVazio(LocalDate parameter){
		return parameter == null;
	}

	private boolean verificarParametroVazio(Integer parameter){
		return parameter == null;
	}
	
}

