package br.com.fa7.api_loja;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.com.fa7.api_loja.resource.CompraResource;
import br.com.fa7.api_loja.resource.ProdutoResource;

@ApplicationPath("/rs")
public class ApplicationRest extends Application {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set<Class<?>> getClasses() {
		return new HashSet(Arrays.asList(CompraResource.class, ProdutoResource.class));
	}
}
