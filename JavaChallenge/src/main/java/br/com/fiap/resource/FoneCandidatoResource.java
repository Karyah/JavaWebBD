package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import br.com.fiap.bo.FoneCandidatoBO;

@Path("foneCandidato")
public class FoneCandidatoResource {

	FoneCandidatoBO foneBO = new FoneCandidatoBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(FoneTO fone, @Context UriInfo uriInfo) {
		foneBO.inserir(fone);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(fone.getTelefone()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoneTO> listar(){
		return foneBO.listar();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FoneTO buscar(int id) {
		return foneBO.buscarPorId(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(FoneTO fone, @PathParam("id") int id) {
		fone.setId(id);
		foneBO.atualizar(fone);
		return Response.ok().build();
	}

	@DELETE 
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		foneBO.deletar(id);
	}
}
