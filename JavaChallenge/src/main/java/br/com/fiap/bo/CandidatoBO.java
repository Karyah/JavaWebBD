package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.CandidatoDAO;
import br.com.fiap.resource.CandidatoTO;

public class CandidatoBO {
	
	private CandidatoDAO cdao;
	
//	Get all
	
	public List<CandidatoTO> listar(){
		cdao = new CandidatoDAO();
		return cdao.listar();
		}

	
//  Get
	public CandidatoTO buscarPorId(String id) {
		cdao= new CandidatoDAO();
		try {
			return cdao.buscarPorID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	Update
	public void atualizar(CandidatoTO candidato) {
		cdao = new CandidatoDAO();
		try {
			cdao.atualizar(candidato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Delete
	public void deletar(String id) {
		cdao = new CandidatoDAO();
		try {
			cdao.deletar(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
