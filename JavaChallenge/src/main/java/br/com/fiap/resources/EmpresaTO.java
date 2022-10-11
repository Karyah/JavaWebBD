package br.com.fiap.resources;


public class EmpresaTO extends UsuarioTO{
	private String cnpj;
	private VagaTO vaga;
//	private ArrayList<Vaga> minhasVagas;
	
	public String getCnpj() {
		return cnpj;
	}
	public EmpresaTO() {
		super();
	}

	public EmpresaTO(String id, String nome, String senha, String tipoUsuario, String email, String cnpj2) {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public VagaTO getVaga() {
		return vaga;
	}

	public void setVaga(VagaTO vaga) {
		this.vaga = vaga;
	}

//	public ArrayList<Vaga> getMinhasVagas() {
//		return minhasVagas;
//	}
//
//	public void setMinhasVagas(ArrayList<Vaga> minhasVagas) {
//		this.minhasVagas = minhasVagas;
//	}

	@Override
	public String tipoUsuario() {
		setTipoUsuario(EnumTipoUsuario.EMPRESA);
		return "Empresa";
	}
	
	public void cadastrar(String nome, String email,String CNPJ, String senha) {
		super.setNome(nome);
		super.setEmail(email);
		setCnpj(CNPJ);
		setSenha(senha);
	}
	
	public void criarVaga(String nome, String descricao) {
		vaga = new VagaTO();
		vaga.gerarId();
		vaga.setNome(nome);
		vaga.setDescricao(descricao);
		vaga.setEmpresa(this);

	}
	
//	public void mostrarMinhasVagas() {
//		for(int i =0 ; i<minhasVagas.size();i++) {
//			System.out.println("Vagas criadas: "+minhasVagas.get(i));
//		}
//	}

}
