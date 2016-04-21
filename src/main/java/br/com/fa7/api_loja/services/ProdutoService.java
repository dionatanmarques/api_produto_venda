package br.com.fa7.api_loja.services;

import java.util.List;

import javax.ejb.Local;

import br.com.fa7.api_loja.entity.Produto;

@Local
public interface ProdutoService {
	public List<Produto> findAll();

	public Produto findById(Long id);

	public void insert(Produto produto);
}