package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.resources.EmpresaTO;

public class VagaDAO {
private Connection conexao;
	
	public void Inserir(EmpresaTO empresa) {
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL =null;
		try {
			SQL = conexao.prepareStatement("INSERT INTO Vaga (id_vaga, nome_vaga, descricao_vaga, id_empresa) VALUES(?,?,?,?)");
			SQL.setString(1, empresa.getVaga().getId());
			SQL.setString(2, empresa.getVaga().getNome());
			SQL.setString(3, empresa.getVaga().getDescricao());
			SQL.setString(4,empresa.getVaga().getEmpresa().getId());
			
			SQL.executeUpdate();
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
}
}
