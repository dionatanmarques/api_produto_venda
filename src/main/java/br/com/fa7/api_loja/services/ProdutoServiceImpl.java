package br.com.fa7.api_loja.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fa7.api_loja.entity.Produto;

@Stateless(name = "ProdutoService")
public class ProdutoServiceImpl implements ProdutoService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Produto> findAll() {
		return em.createQuery("From Produto", Produto.class).getResultList();
	}

	@Override
	public Produto findById(Long id) {
		return em.find(Produto.class, id);
	}

	@Override
	public void insert(Produto produto) {
		em.persist(produto);
	}
}