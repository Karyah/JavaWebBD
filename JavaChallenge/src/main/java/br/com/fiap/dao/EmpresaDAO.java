package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.resource.CandidatoTO;
import br.com.fiap.resource.EmpresaTO;

public class EmpresaDAO {
private Connection conexao;
private List<EmpresaTO> listaEmpresas;
	
//	public void Inserir(EmpresaTO empresa) throws SQLException{
//		conexao = GerenciadorBD.obterConexao();
//		PreparedStatement SQL = null;
//		
//		try {
//			SQL = conexao.prepareStatement("INSERT INTO Empresa (id_empresa, nome_empresa, senha_empresa, email_empresa, tipo_Usuario, cnpj) VALUES(?,?,?,?,?,?)");
//			
//			SQL.setString(1, empresa.getId());
//			SQL.setString(2, empresa.getNome());
//			SQL.setString(3, empresa.getSenha());
//			SQL.setString(4, empresa.getEmail());
//			SQL.setString(5, empresa.tipoUsuario());
//			SQL.setString(6, empresa.getCnpj());
//			
//			SQL.executeUpdate();
//
//			SQL.close();			
//			conexao.close();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	

//	Get All
	public List<EmpresaTO> listar(EmpresaTO empresa){
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		ResultSet rs = null;
		
		try {
			SQL = conexao.prepareStatement("SELECT * FROM EMPRESA");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id_empresa");
				String nome = rs.getString("nome_empresa");
				String senha = rs.getString("senha_empresa");
				String tipoUsuario = rs.getString("tipo_usuario");
				String email = rs.getString("email_empresa");
				String cnpj = rs.getString("cnpj");
				
				EmpresaTO emp= new EmpresaTO(id,nome,senha,tipoUsuario,email, cnpj);
				listaEmpresas.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listaEmpresas;
	}
	
//	get by id
	
	public EmpresaTO buscarPorID(String id) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		String idEmp = null;
		String nome= null;
		String senha= null;
		String tipoUsuario= null;
		String email= null;
		String cnpj = null;
		
		EmpresaTO empresa = new EmpresaTO(idEmp, nome, senha, tipoUsuario, email, cnpj);
		
		try{
			SQL = conexao.prepareStatement("SELECT * FROM Empresa WHERE id_empresa = ?");
			SQL.setString(1, id);	ResultSet rs = SQL.executeQuery();
			
			while(rs.next()) {
				idEmp = rs.getString("id_empresa");
				nome = rs.getString("nome_empresa");
				senha = rs.getString("senha_empresa");
				tipoUsuario = rs.getString("tipo_Usuario");
				email = rs.getString("email_empresa");
				cnpj = rs.getString("cnpj");
			
				
			}
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(idEmp.equals(id) ){
			return empresa;
		}else {
			return null;
		}
	}
	
//	update
	
	public void atualizar(EmpresaTO empresa) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("UPDATE Empresa SET nome_empresa = ?, SET senha_empresa =?, SET tipo_Usuario = ?, SET email_empresa = ?, SET cnpj = ?");
			SQL.setString(1, empresa.getNome());
			SQL.setString(2, empresa.getSenha());
			SQL.setString(3, empresa.tipoUsuario());
			SQL.setString(4, empresa.getEmail());
			SQL.setString(5, empresa.getCnpj());
	
			
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	delete
	
	public void deletar(String id) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM Empresa WHERE id_empresa =  ?");
			SQL.setString(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
