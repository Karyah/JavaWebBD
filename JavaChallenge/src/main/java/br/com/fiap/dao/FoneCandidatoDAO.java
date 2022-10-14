package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.resource.FoneTO;

public class FoneCandidatoDAO {
private Connection conexao;

	public FoneCandidatoDAO() {
		this.conexao = new GerenciadorBD().obterConexao();
	}
	public void inserir(FoneTO fone) {
		
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("INSERT INTO FoneCandidato (seq_fone, fone, id_candidato) VALUES(?,?,?)");
			
			SQL.setInt(1, fone.getSequencia());
			SQL.setInt(2, fone.getTelefone());
			SQL.setInt(3, fone.getCandidato().getId());
		
			
			SQL.executeUpdate();
			SQL.close();
			conexao.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
