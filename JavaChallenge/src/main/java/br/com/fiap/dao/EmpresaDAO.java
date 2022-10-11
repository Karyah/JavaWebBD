package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.resources.EmpresaTO;

public class EmpresaDAO {
private Connection conexao;
private List<EmpresaTO> listaEmpresas;
	
	public void Inserir(EmpresaTO empresa) throws SQLException{
		conexao = GerenciadorBD.obterConexao();
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("INSERT INTO Empresa (id_empresa, nome_empresa, senha_empresa, email_empresa, tipo_Usuario, cnpj) VALUES(?,?,?,?,?,?)");
			
			SQL.setString(1, empresa.getId());
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
}
