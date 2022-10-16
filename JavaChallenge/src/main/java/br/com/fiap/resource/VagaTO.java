package br.com.fiap.resource;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VagaTO {
	private int  id;
	private String nome;
	private String descricao;
//	private ArrayList<Tags> tagsVaga;
	private EmpresaTO empresa;
	private ArrayList<CandidatoTO> candidatosInscritos;
	private ArrayList<VagaTO> todasVagas;

	
	
	public VagaTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VagaTO(int id, String nome, String descricao, EmpresaTO empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.empresa = empresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public ArrayList<Tags> getTagsVaga() {
//		return tagsVaga;
//	}
//
//	public void setTagsVaga(ArrayList<Tags> tagsVaga) {
//		this.tagsVaga = tagsVaga;
//	}

	public EmpresaTO getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(EmpresaTO empresa) {
		this.empresa = empresa;
	}

	public ArrayList<CandidatoTO> getCandidatosInscritos() {
		return candidatosInscritos;
	}

	public void setCandidatosInscritos(ArrayList<CandidatoTO> candidatosInscritos) {
		this.candidatosInscritos = candidatosInscritos;
	}

	public ArrayList<VagaTO> getTodasVagas() {
		return todasVagas;
	}

	public void setTodasVagas(ArrayList<VagaTO> todasVagas) {
		this.todasVagas = todasVagas;
	}


	

}
