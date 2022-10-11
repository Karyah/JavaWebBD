package br.com.fiap.resources;

import java.util.ArrayList;
import java.util.Random;


public class VagaTO {
	private String id;
	private String nome;
	private String descricao;
//	private ArrayList<Tags> tagsVaga;
	private EmpresaTO empresa;
	private ArrayList<CandidatoTO> candidatosInscritos;
	private ArrayList<VagaTO> todasVagas;
	
	Random random =new Random();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String gerarId() {
		id = "V" + random.nextInt(999);
		return id;
	}
	

}
