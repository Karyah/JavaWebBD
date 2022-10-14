package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.dao.CandidatoDAO;
import br.com.fiap.dao.EmpresaDAO;
import br.com.fiap.resource.CandidatoTO;
import br.com.fiap.resource.EmpresaTO;


public class EmpresaBO {
	
	private EmpresaDAO empdao;
	
	
	public void inserir(EmpresaTO empresa) {
		empdao = new EmpresaDAO();
		try {
			empdao.inserir(empresa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	Get all
	
	public List<EmpresaTO> listar(){
		empdao = new EmpresaDAO();
		return empdao.listar();
		}

	
//  Get
	public EmpresaTO buscarPorId(int id) {
		empdao = new EmpresaDAO();
		try {
			return empdao.buscarPorID(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	Update
	public void atualizar(EmpresaTO empresa) {
		empdao = new EmpresaDAO();
		try {
			empdao.atualizar(empresa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Delete
	public void deletar(int id) {
		empdao = new EmpresaDAO();
		try {
			empdao.deletar(id);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
