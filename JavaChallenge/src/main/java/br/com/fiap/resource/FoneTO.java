package br.com.fiap.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoneTO {
	private int id;
	private EmpresaTO empresa;
	private CandidatoTO candidato;
	private int sequencia;
	private int telefone;
	
	
	public FoneTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoneTO(int id, int sequencia, int fone, CandidatoTO objetoCandidato) {
		// TODO Auto-generated constructor stub
	}

	public FoneTO(int id, int sequencia2, int fone, EmpresaTO objetoEmpresa) {
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
