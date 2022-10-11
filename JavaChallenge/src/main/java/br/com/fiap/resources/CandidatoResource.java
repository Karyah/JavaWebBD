package br.com.fiap.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.fiap.bo.CandidatoBO;

@Path("/candidato")
public class CandidatoResource {
	
	CandidatoBO  cbo = new CandidatoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidatoTO> listar(){
		return cbo.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CandidatoTO buscar(String id) {
		return cbo.buscarPorId(id);
	}
}
