package br.com.fa7.api_loja.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fa7.api_loja.entity.Produto;
import br.com.fa7.api_loja.services.ProdutoService;


@Path("/produtos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProdutoResource {
	
	@Inject
	private ProdutoService produtoService;

	@GET
	public List<Produto> findAll() {
		return produtoService.findAll();
	}
	
	@POST
	public Produto insert(Produto produto) {
		produtoService.insert(produto);
		return produto;
	}
	
	@GET
	@Path("{id}")
	public Produto get(@PathParam("id") Long id) {
		return produtoService.findById(id);
	}
}