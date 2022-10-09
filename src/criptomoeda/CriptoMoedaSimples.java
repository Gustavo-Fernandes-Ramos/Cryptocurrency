package criptomoeda;

public class CriptoMoedaSimples {
	
	private String id;			//id utilizada para fazer requisições a API***
	private String nome;		//nome da Moeda ou Token***
	private String simbolo;		//simbolo da Moeda ou Token ( ex: btc )***
	
	public CriptoMoedaSimples(String id, String nome, String simbolo) {
		super();
		this.id = id;
		this.nome = nome;
		this.simbolo = simbolo;
	}

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

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
}
