package br.com.fiap.resource;

import java.util.List;
import java.util.Random;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class UsuarioTO {
	private String id;
	private String nome;
	private String senha;
	private List<FoneTO> telefones;
	private String email;
	private EnumTipoUsuario tipoUsuario;
	
	Random random = new Random();

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<FoneTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<FoneTO> telefones) {
		this.telefones = telefones;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTipoUsuario(EnumTipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public abstract String tipoUsuario();
	
	public boolean confirmarSenhaLogin(String senha1, String senha2) {
		if((senha1.equals(senha2))) {
			return true;
		}else {
			System.out.println("Suas senhas são se coincidem");
			return false;
		}
	}
	
	public boolean confirmarLogin(String email, String senha) {
		if(this.email.equals(email)&&this.senha.equals(senha)) {
			System.out.println("Você foi logado com sucesso.");
			return true;
		}else {
			System.out.println("Você errou seu e-mail ou senha.");
			return false;
		}
	}
	
	public void gerarID() {
		if(tipoUsuario==EnumTipoUsuario.EMPRESA){
			id = "E" + random.nextInt(999); 
		}else {
			id = "C" + random.nextInt(999);
			
		}
	}
}
