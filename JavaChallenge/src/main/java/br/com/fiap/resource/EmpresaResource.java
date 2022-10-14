package br.com.fiap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.EmpresaBO;

public class EmpresaResource {
	EmpresaBO empresaBO = new EmpresaBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(EmpresaTO empresa, @Context UriInfo uriInfo) {
		empresaBO.inserir(empresa);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(empresa.getId()));
		return Response.created(builder.build()).build();
	}
}
