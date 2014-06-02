package dominio;

public class Usuario {
	private String nome;
	private String login;
	private String senha;
	private String confirmaSenha;
	
	public Usuario(){
		super();
	}
	
	
	
	public Usuario(String nome, String login, String senha, String confirmaSenha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.confirmaSenha = confirmaSenha;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	
	

}
