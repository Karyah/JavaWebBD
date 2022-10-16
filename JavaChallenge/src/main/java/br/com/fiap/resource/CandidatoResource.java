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

import br.com.fiap.bo.CandidatoBO;

@Path("/candidato")
public class CandidatoResource {
	
	CandidatoBO candidatoBO = new CandidatoBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CandidatoTO candidato, @Context UriInfo uriInfo) {
		candidatoBO.inserir(candidato);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(candidato.getId()));
		return Response.created(builder.build()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidatoTO> listar(){
		return candidatoBO.listar();
		
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CandidatoTO buscar(int id) {
		return candidatoBO.buscarPorId(id);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(CandidatoTO candidato, @PathParam("id") int id) {
		candidato.setId(id);
		candidatoBO.atualizar(candidato);
		return Response.ok().build();
	}

	@DELETE 
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		candidatoBO.deletar(id);
	}
}
