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
import br.com.fiap.resource.FoneTO;
import br.com.fiap.resource.VagaTO;

public class FoneCandidatoDAO {
private Connection conexao;

	public FoneCandidatoDAO() {
		this.conexao = new GerenciadorBD().obterConexao();
	}
	
	/*inserir*/
	public void inserir(FoneTO fone) throws SQLException{
		
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
	
	/*get all*/
	public List<FoneTO> listar() throws SQLException{
		
		List<FoneTO> listaFone = new ArrayList<>();

		PreparedStatement SQL = null;
		ResultSet rs = null;
		
		try {
			SQL = conexao.prepareStatement("SELECT * FROM FoneCandidato");
			rs = SQL.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_fone");
				int sequencia = rs.getInt("seq_fone");
				int fone = rs.getInt("fone");
				int idCandidato = rs.getInt("id_candidato");
				
				CandidatoDAO candidatoDAO = new CandidatoDAO();
				CandidatoTO objetoCandidato = candidatoDAO.buscarPorID(idCandidato);
				
				FoneTO foneTO = new FoneTO(id, sequencia, fone, objetoCandidato);
				
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
			SQL = conexao.prepareStatement("SELECT * FROM FoneCandidato WHERE id_fone = ?");
			SQL.setInt(1, id);	
			ResultSet rs = SQL.executeQuery();
			
			while(rs.next()) {
				fone.setSequencia(rs.getInt("seq_fone"));
				fone.setTelefone(rs.getInt("fone"));
				int idCandidato = rs.getInt("id_candidato"); 
				CandidatoDAO candidatoDAO = new CandidatoDAO();
				
				CandidatoTO objetoCandidato = candidatoDAO.buscarPorID(idCandidato);
				
				fone.setCandidato(objetoCandidato);
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
			SQL = conexao.prepareStatement("UPDATE FoneCandidato SET seq_fone = ?, SET fone =?, SET id_candidato = ?");
			SQL.setInt(1, fone.getSequencia());
			SQL.setInt(2, fone.getTelefone());
			SQL.setInt(3, fone.getCandidato().getId());
		
			
			
			SQL.close();
			conexao.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int id) throws SQLException{
		
		PreparedStatement SQL = null;
		
		try {
			SQL = conexao.prepareStatement("DELETE FROM FoneCandidato WHERE id_candidato =  ?");
			SQL.setInt(1, id);
			
			SQL.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
