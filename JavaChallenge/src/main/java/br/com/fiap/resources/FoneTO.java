package br.com.fiap.resources;

public class FoneTO {
	private EmpresaTO empresa;
	private CandidatoTO candidato;
	private int sequencia;
	private int telefone;
	
	public EmpresaTO getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}
	
	public CandidatoTO getCandidato() {
		return candidato;
	}
	
	public void setCandidato(CandidatoTO candidato) {
		this.candidato = candidato;
	}
	
	public int getSequencia() {
		return sequencia;
	}
	
	public void setSequencia(int sequencia) {
		this.sequencia = sequencia;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
