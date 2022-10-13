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

public class EmpresaDAO {
private Connection conexao;

	
// Insert
	public void Inserir(EmpresaTO empresa) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("INSERT INTO Empresa (id_empresa, nome_empresa, senha_empresa, email_empresa, tipo_Usuario, cnpj) VALUES(?,?,?,?,?,?)");
			
			SQL.setInt(1, empresa.getId());
			SQL.setString(2, empresa.getNome());
			SQL.setString(3, empresa.getSenha());
			SQL.setString(4, empresa.getEmail());
			SQL.setString(5, empresa.tipoUsuario());
			SQL.setString(6, empresa.getCnpj());
			
			SQL.executeUpdate();

			SQL.close();			
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

//	Get All
	public List<EmpresaTO> listar(){ 
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		ResultSet rs = null;
		List<EmpresaTO> listaEmpresas= new ArrayList<>();
		
		try {
			SQL = conexao.prepareStatement("SELECT * FROM EMPRESA");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_empresa");
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
	
//	Get by id
	
	public EmpresaTO buscarPorID(int id) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		EmpresaTO empresa = new EmpresaTO();
		try{
			SQL = conexao.prepareStatement("SELECT * FROM Candidato WHERE id_candidato = ?");
			SQL.setInt(1, id);	ResultSet rs = SQL.executeQuery();
			
			while(rs.next()) {
				empresa.setNome(rs.getString("nome_empresa"));
				empresa.setSenha(rs.getString("senha_empresa"));
				String tipoUsuario = rs.getString("tipoUsuario");
				if(tipoUsuario.equals("Candidato")) {
					empresa.setTipoUsuario(EnumTipoUsuario.CANDIDATO);
				}
				if(tipoUsuario.equals("Empresa")) {
					empresa.setTipoUsuario(EnumTipoUsuario.EMPRESA);
				}
				empresa.setEmail(rs.getString("email_empresa"));
				empresa.setCnpj(rs.getString("cnpj"));
			
				
			}
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return empresa;
	}
	
//	Update
	
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
	
//	Delete
	
	public void deletar(int id) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM Empresa WHERE id_empresa =  ?");
			SQL.setInt(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
