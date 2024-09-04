package com.github.luisfeliperochamartins.domain.produto;

import com.github.luisfeliperochamartins.domain.categoria.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {

	private final EntityManager em;

	public ProdutoDAO(EntityManager em) {
		this.em = em;
	}

	public void insert(Produto produto) {
		em.persist(produto);
	}

	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> findAll() {
		var jpql = "SELECT p FROM Produto p ";
		return em.createQuery(jpql, Produto.class).getResultList();
	}

	public List<Produto> findByNome(String nome) {
		var jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}

	public BigDecimal findPrecoByNome(String nome) {
		var jpql = "SELECT p.preoc FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome)
				.getSingleResult();
	}

	public List<Produto> findByCategoria(Categoria categoria) {
		var jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", categoria.getNome())
				.getResultList();
	}
}
