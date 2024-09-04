package com.github.luisfeliperochamartins;

import com.github.luisfeliperochamartins.domain.categoria.Categoria;
import com.github.luisfeliperochamartins.domain.categoria.CategoriaDAO;
import com.github.luisfeliperochamartins.domain.produto.Produto;
import com.github.luisfeliperochamartins.domain.produto.ProdutoDAO;
import com.github.luisfeliperochamartins.util.JPAUtil;

import java.math.BigDecimal;

public class CadastroProduto {
	public static void main(String[] args) {
//		cadastrarProduto();
		var em = JPAUtil.getEntityManager();
		var produtodao = new ProdutoDAO(em);

		var produto = produtodao.findById(1L);
		System.out.println(produto.getPreco());
	}

	private static void cadastrarProduto() {
		var celulares = new Categoria("celulares");
		var celular = new Produto(null, "Xiaomi Redmi", "Xiaomi Redmi", new BigDecimal("800"), celulares);

		var em = JPAUtil.getEntityManager();
		var produtodao = new ProdutoDAO(em);
		var categoriadao = new CategoriaDAO(em);

		em.getTransaction().begin();
		categoriadao.insert(celulares);
		produtodao.insert(celular);
		em.getTransaction().commit();
		em.close();
	}
}