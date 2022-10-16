package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.resource.FoneTO;

public class FoneEmpresaDAO {
private Connection conexao;
	
	public FoneEmpresaDAO(){
		this.conexao = new GerenciadorBD().obterConexao();
	}
	
	public void inserir(FoneTO fone) {

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
}
