package br.com.fa7.api_loja.services;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.fa7.api_loja.entity.Cliente;
import br.com.fa7.api_loja.entity.Compra;

@Stateless(name = "CompraService")
public class CompraServiceImpl implements CompraService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Compra> findAll() {
		List<Compra> compras = em.createQuery("From Compra", Compra.class).getResultList();
		Cliente cliente;
		for (Compra compra : compras) {
			cliente = compra.getCliente();
			cliente.setNome(restCliente(cliente));
		}
		return compras;
	}

	@Override
	public Compra findById(Long id) {
		Compra compra = em.find(Compra.class, id);
		compra.getCliente().setNome(restCliente(compra.getCliente()));
		return compra;
	}

	@Asynchronous
	private String restCliente(Cliente cliente){
		try {
			HttpResponse<JsonNode> json = Unirest.get("http://localhost:8082/clientes/" + cliente.getId()).asJson();
			return (String) json.getBody().getObject().get("nome");
		} catch (UnirestException e) {
			return "";
		}
	}

	@Override
	public void insert(Compra compra) {
		em.persist(compra);
	}
}