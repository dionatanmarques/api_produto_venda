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

import br.com.fa7.api_loja.entity.Compra;
import br.com.fa7.api_loja.services.CompraService;


@Path("/compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompraResource {
	
	@Inject
	private CompraService compraService;

	@GET
	public List<Compra> findAll() {
		return compraService.findAll();
	}
	
	@POST
	public Compra insert(Compra compra) {
		compraService.insert(compra);
		return compra;
	}
	
	@GET
	@Path("{id}")
	public Compra get(@PathParam("id") Long id) {
		return compraService.findById(id);
	}
}