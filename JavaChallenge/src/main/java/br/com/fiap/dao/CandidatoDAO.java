package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.fiap.resource.CandidatoTO;
import br.com.fiap.resource.EnumGenero;
import br.com.fiap.resource.EnumTipoUsuario;

public class CandidatoDAO {
	private Connection conexao = null;
	
	public CandidatoDAO(){
		this.conexao=new GerenciadorBD().obterConexao();
	}
	
	public void inserir(CandidatoTO candidato) throws SQLException{
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("INSERT INTO Candidato (id_candidato, nome_candidato, senha_candidato, tipo_Usuario, email_candidato, cpf, genero_candidato) VALUES(?,?,?,?,?,?,?)");
			SQL.setInt(1, candidato.getId());
			SQL.setString(2, candidato.getNome());
			SQL.setString(3, candidato.getSenha());
			SQL.setString(4, candidato.tipoUsuario());
			SQL.setString(5, candidato.getEmail());
			SQL.setString(6, candidato.getCpf());
			SQL.setString(7, candidato.retornarGenero());
			
			
			SQL.executeUpdate();
			conexao.close();
			SQL.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	
//	get all
	public List<CandidatoTO> listar() throws SQLException{
		
		List<CandidatoTO> listaCandidatos = new ArrayList<>();

		PreparedStatement SQL = null;
		ResultSet rs = null;
		
		try {
			SQL = conexao.prepareStatement("SELECT * FROM Candidato");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_candidato");
				String nome = rs.getString("nome_candidato");
				String senha = rs.getString("senha_candidato");
				String tipoUsuario = rs.getString("tipo_usuario");
				String email = rs.getString("email_candidato");
				String cpf = rs.getString("cpf");
				String genero = rs.getString("genero_candidato");
				
				CandidatoTO candidato = new CandidatoTO(id, nome, senha, tipoUsuario, email, cpf, genero);
				System.out.println(id);
				listaCandidatos.add(candidato);
			}
			
			conexao.close();
			SQL.close();
			rs.close();
			
		
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.println("erro");
		}
		return listaCandidatos;	

	}
	
//	get by id
	
	public CandidatoTO buscarPorID(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		CandidatoTO candidato = new CandidatoTO();
		try{
			SQL = conexao.prepareStatement("SELECT * FROM Candidato WHERE id_candidato = ?");
			SQL.setInt(1, id);	ResultSet rs = SQL.executeQuery();
			
			while(rs.next()) {
				candidato.setNome(rs.getString("nome_candidato"));
				candidato.setSenha(rs.getString("senha_candidato"));
				String tipoUsuario = rs.getString("tipoUsuario");
				if(tipoUsuario.equals("Candidato")) {
					candidato.setTipoUsuario(EnumTipoUsuario.CANDIDATO);
				}
				if(tipoUsuario.equals("Empresa")) {
					candidato.setTipoUsuario(EnumTipoUsuario.EMPRESA);
				}
				candidato.setEmail(rs.getString("email_candidato"));
				candidato.setCpf(rs.getString("cpf"));
				String genero = (rs.getString("genero_candidato"));
				if(genero.equals("Masculino")) {
					candidato.setGenero(EnumGenero.MASCULINO);
				}
				if(genero.equals("Feminino")) {
					candidato.setGenero(EnumGenero.FEMININO);
				}
				if(genero.equals("Não Binário")) {
					candidato.setGenero(EnumGenero.NAO_BINARIO);
				}
				
			}
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return candidato;
	}
	
	
//	Update
	public void atualizar(CandidatoTO candidato) throws SQLException{

		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("UPDATE Candidato SET nome_candidato = ?, SET senha_candidato =?, SET tipo_Usuario = ?, SET email_candidato = ?, SET cpf = ?, SET genero_candidato = ?");
			SQL.setString(1, candidato.getNome());
			SQL.setString(2, candidato.getSenha());
			SQL.setString(3, candidato.tipoUsuario());
			SQL.setString(4, candidato.getEmail());
			SQL.setString(5, candidato.getCpf());
			SQL.setString(6, candidato.retornarGenero());
			
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
//	Delete
	public void deletar(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM Candidato WHERE id_candidato =  ?");
			SQL.setInt(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
