package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.resource.CandidatoTO;
import br.com.fiap.resource.EmpresaTO;
import br.com.fiap.resource.EnumGenero;
import br.com.fiap.resource.EnumTipoUsuario;
import br.com.fiap.resource.VagaTO;

public class VagaDAO {
private Connection conexao;
	
public VagaDAO() {
	this.conexao = new GerenciadorBD().obterConexao();
}
// Insert
	public void inserir(VagaTO vaga) throws SQLException {

		PreparedStatement SQL =null;
		try {
			SQL = conexao.prepareStatement("INSERT INTO Vaga (id_vaga, nome_vaga, descricao_vaga, id_empresa) VALUES(?,?,?,?)");
			SQL.setInt(1,  vaga.getId());
			SQL.setString(2,  vaga.getNome());
			SQL.setString(3,  vaga.getDescricao());
			SQL.setInt(4, vaga.getEmpresa().getId());
			
			SQL.executeUpdate();
			SQL.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	Get all
	public List<VagaTO> listar() throws SQLException { 
	
		PreparedStatement SQL = null;
		ResultSet rs = null;
		List<VagaTO> listaVagas = new ArrayList<>();
		try {
			SQL = conexao.prepareStatement("SELECT * FROM Vaga");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_vaga");
				String nome = rs.getString("nome_vaga");
				String descricao = rs.getString("descricao_vaga");
				int idEmpresa= rs.getInt("id_empresa");
				
				EmpresaDAO empresaDAO = new EmpresaDAO();
				EmpresaTO objetoEmpresa = empresaDAO.buscarPorID(idEmpresa);

				
				VagaTO vaga= new VagaTO(id,nome,descricao, objetoEmpresa);
				listaVagas.add(vaga);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaVagas;
	}
	
// Get By Id
	
	public VagaTO buscarPorID(int id) throws SQLException {
		PreparedStatement SQL = null;
		
		VagaTO vaga = new VagaTO();
		try{
			SQL = conexao.prepareStatement("SELECT * FROM Vaga WHERE id_vaga = ?");
			SQL.setInt(1, id);	
			ResultSet rs = SQL.executeQuery();
			
			if(rs.next()) {
				vaga.setNome(rs.getString("nome_vaga"));
				vaga.setDescricao(rs.getString("descricao_vaga"));
				int idEmpresa = rs.getInt("id_empresa");
				
				EmpresaDAO empresaDAO = new EmpresaDAO();
				EmpresaTO objetoEmpresa = empresaDAO.buscarPorID(idEmpresa);
				vaga.setEmpresa(objetoEmpresa);
				
			}
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vaga;
	}
	
	public void atualizar(VagaTO vaga) throws SQLException{

		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("UPDATE Vaga SET nome_vaga = ?, SET descricao_vaga =?, SET id_empresa = ?");
			SQL.setString(1, vaga.getNome());
			SQL.setString(2, vaga.getDescricao());
			SQL.setInt(3, vaga.getEmpresa().getId());
		
			
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM Vaga WHERE id_vaga =  ?");
			SQL.setInt(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
