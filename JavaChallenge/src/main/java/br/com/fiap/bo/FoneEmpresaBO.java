package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;


import br.com.fiap.dao.FoneEmpresaDAO;
import br.com.fiap.resource.FoneTO;

public class FoneEmpresaBO {
private FoneEmpresaDAO fonedao;
	
	public void inserir(FoneTO vaga)  {
		fonedao = new FoneEmpresaDAO();
		try {
			fonedao.inserir(vaga);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Get all
	
	public List<FoneTO> listar(){
		fonedao = new FoneEmpresaDAO();
		try {
			return fonedao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
//  Get
	public FoneTO buscarPorId(int id) {
		fonedao = new FoneEmpresaDAO();
		try {
			return fonedao.buscarPorID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	Update
	public void atualizar(FoneTO empresa) {
		fonedao = new FoneEmpresaDAO();
		try {
			fonedao.atualizar(empresa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Delete
	public void deletar(int id) {
		fonedao = new FoneEmpresaDAO();
		try {
			fonedao.deletar(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
