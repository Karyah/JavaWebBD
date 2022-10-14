package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.EmpresaBO;

@Path("/empresa")
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpresaTO> listar(){
		return empresaBO.listar();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpresaTO buscar(int id) {
		return empresaBO.buscarPorId(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(EmpresaTO empresa, @PathParam("id") int id) {
		empresa.setId(id);
		empresaBO.atualizar(empresa);
		return Response.ok().build();
	}
}
