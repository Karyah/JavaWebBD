package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;


import br.com.fiap.dao.VagaDAO;
import br.com.fiap.resource.VagaTO;


public class VagaBO {
	private VagaDAO vagadao;
	
	
	public void inserir(VagaTO vaga) throws SQLException  {
		vagadao = new VagaDAO();
		try {
			vagadao.inserir(vaga);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Get all
	
	public List<VagaTO> listar(){
		vagadao = new VagaDAO();
		try {
			return vagadao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
//  Get
	public VagaTO buscarPorId(int id) throws SQLException {
		vagadao = new VagaDAO();
		try {
			return vagadao.buscarPorID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	Update
	public void atualizar(VagaTO empresa) {
		vagadao = new VagaDAO();
		try {
			vagadao.atualizar(empresa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Delete
	public void deletar(int id) {
		vagadao = new VagaDAO();
		try {
			vagadao.deletar(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}


