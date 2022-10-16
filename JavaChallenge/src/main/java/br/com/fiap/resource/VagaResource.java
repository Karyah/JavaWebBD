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


import br.com.fiap.bo.VagaBO;
@Path("/vaga")
public class VagaResource {

	public class EmpresaResource {
		VagaBO vagaBO = new VagaBO();
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response cadastrar(VagaTO vaga, @Context UriInfo uriInfo) {
			vagaBO.inserir(vaga);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(vaga.getId()));
			return Response.created(builder.build()).build();
		}
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<VagaTO> listar(){
			return vagaBO.listar();
			
		}
		
		@GET
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public VagaTO buscar(int id) {
			return vagaBO.buscarPorId(id);
		}
		
		@PUT
		@Path("/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response atualizar(VagaTO vaga, @PathParam("id") int id) {
			vaga.setId(id);
			vagaBO.atualizar(vaga);
			return Response.ok().build();
		}

}
