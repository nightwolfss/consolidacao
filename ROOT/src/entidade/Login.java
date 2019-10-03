package entidade;

public class Login {

	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String admin;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(Integer id, String nome, String senha, String email, String admin) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.admin = admin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", usuario=" + nome + ", senha=" + senha + ", email=" + email + ", admin=" + admin
				+ "]";
	}
	
	
}
