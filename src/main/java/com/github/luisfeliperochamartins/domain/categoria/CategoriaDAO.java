package com.github.luisfeliperochamartins.domain.categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {

	private final EntityManager em;

	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}

	public void insert(Categoria categoria) {
		em.persist(categoria);
	}

	public void update(Categoria categoria) {
		categoria = em.merge(categoria);
	}

	public void delete(Categoria categoria) {
		categoria = em.merge(categoria); //to force that the Categoria is not detached
		em.remove(categoria);
	}
}
