package entidade;

public class Consolidador {
	
	private Integer id;
	private String nome;
	private Integer idade;
	private String aniversario;
	private String tribo;
	private String batizado;
	private String email;
	private String telefone;
	private String retiro;
	private String quandoRetiro;
	private String quantoTempoConsolidacao;
	private String servos;
	
	public Consolidador() {
		// TODO Auto-generated constructor stub
	}

	public Consolidador(Integer id, String nome, Integer idade, String aniversario, String tribo, String batizado,
			String email, String telefone, String retiro, String quandoRetiro, String quantoTempoConsolidacao,
			String servos) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.aniversario = aniversario;
		this.tribo = tribo;
		this.batizado = batizado;
		this.email = email;
		this.telefone = telefone;
		this.retiro = retiro;
		this.quandoRetiro = quandoRetiro;
		this.quantoTempoConsolidacao = quantoTempoConsolidacao;
		this.servos = servos;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}

	public String getTribo() {
		return tribo;
	}

	public void setTribo(String tribo) {
		this.tribo = tribo;
	}

	public String getBatizado() {
		return batizado;
	}

	public void setBatizado(String batizado) {
		this.batizado = batizado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRetiro() {
		return retiro;
	}

	public void setRetiro(String retiro) {
		this.retiro = retiro;
	}

	public String getQuandoRetiro() {
		return quandoRetiro;
	}

	public void setQuandoRetiro(String quandoRetiro) {
		this.quandoRetiro = quandoRetiro;
	}

	public String getQuantoTempoConsolidacao() {
		return quantoTempoConsolidacao;
	}

	public void setQuantoTempoConsolidacao(String quantoTempoConsolidacao) {
		this.quantoTempoConsolidacao = quantoTempoConsolidacao;
	}

	public String getServos() {
		return servos;
	}

	public void setServos(String servos) {
		this.servos = servos;
	}

	@Override
	public String toString() {
		return "Consolidador [id=" + id + ", nome=" + nome + ", idade=" + idade + ", aniversario=" + aniversario
				+ ", tribo=" + tribo + ", batizado=" + batizado + ", email=" + email + ", telefone=" + telefone
				+ ", retiro=" + retiro + ", quandoRetiro=" + quandoRetiro + ", quantoTempoConsolidacao="
				+ quantoTempoConsolidacao + ", servos=" + servos + "]";
	}

	
	
	

}
