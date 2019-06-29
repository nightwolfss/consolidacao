package entidade;

public class Campanha {

	private Integer id;
	private String nome;
	private String texto;
	
	public Campanha() {
		// TODO Auto-generated constructor stub
	}

	public Campanha(Integer id, String nome, String texto) {
		super();
		this.id = id;
		this.nome = nome;
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Campanha [id=" + id + ", nome=" + nome + ", texto=" + texto + "]";
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
