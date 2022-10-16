package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.CandidatoTO;
import br.com.fiap.resource.EmpresaTO;
import br.com.fiap.resource.FoneTO;

public class FoneEmpresaDAO {
private Connection conexao;
	
	public FoneEmpresaDAO(){
		this.conexao = new GerenciadorBD().obterConexao();
	}
	
	public void inserir(FoneTO fone) throws SQLException{

		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("INSERT INTO FoneEmpresa (seq_fone, fone, id_empresa) VALUES(?,?,?)");
			
			SQL.setInt(1, fone.getSequencia());
			SQL.setInt(2, fone.getTelefone());
			SQL.setInt(3, fone.getEmpresa().getId());
		
			
			SQL.executeUpdate();
			SQL.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	/*get all*/
	public List<FoneTO> listar() throws SQLException{
		
		List<FoneTO> listaFone = new ArrayList<>();

		PreparedStatement SQL = null;
		ResultSet rs = null;
		
		try {
			SQL = conexao.prepareStatement("SELECT * FROM FoneEmpresa");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_fone");
				int sequencia = rs.getInt("seq_fone");
				int fone = rs.getInt("fone");
				int idEmpresa = rs.getInt("id_empresa");
				
				EmpresaDAO empresaDAO = new EmpresaDAO();
				EmpresaTO objetoEmpresa = empresaDAO.buscarPorID(idEmpresa);
				
				FoneTO foneTO = new FoneTO(id,sequencia, fone, objetoEmpresa);
				
				listaFone.add(foneTO);
			}
			
			conexao.close();
			SQL.close();
			rs.close();
			
		
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println("erro");
		}
		return listaFone;	

	}
//	get by id
	
	public FoneTO buscarPorID(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		FoneTO fone = new FoneTO();
		try{
			SQL = conexao.prepareStatement("SELECT * FROM FoneEmpresa WHERE id_fone = ?");
			SQL.setInt(1, id);	
			ResultSet rs = SQL.executeQuery();
			
			while(rs.next()) {
				fone.setSequencia(rs.getInt("seq_fone"));
				fone.setTelefone(rs.getInt("fone"));
				
				EmpresaDAO empresaDAO = new EmpresaDAO();
				
				EmpresaTO objetoEmpresa = empresaDAO.buscarPorID(id);
				
				fone.setEmpresa(objetoEmpresa);
				}
				

			SQL.close();
			conexao.close();
			rs.close();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return fone;
	}
	
	public void atualizar(FoneTO fone) throws SQLException{

		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("UPDATE FoneEmpresa SET seq_fone = ?, SET fone =?, SET id_empresa = ?");
			SQL.setInt(1, fone.getSequencia());
			SQL.setInt(2, fone.getTelefone());
			SQL.setInt(3, fone.getEmpresa().getId());
		
			
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM FoneEmpresa WHERE id_fone =  ?");
			SQL.setInt(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
