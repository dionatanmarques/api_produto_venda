package br.com.fa7.api_loja.services;

import java.util.List;

import javax.ejb.Local;

import br.com.fa7.api_loja.entity.Compra;

@Local
public interface CompraService {
	public List<Compra> findAll();

	public Compra findById(Long id);

	public void insert(Compra compra);
}
