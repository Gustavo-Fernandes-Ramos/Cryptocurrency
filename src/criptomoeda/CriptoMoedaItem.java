 package criptomoeda;

public class CriptoMoedaItem extends CriptoMoedaSimples{
	
	private double precoAtual;				//preço atual de cada ação***
	private double capitalizMercado; 			//valor de mercado ( total de ações X valor de cada ação )
	private int capitalizMercadoRanking; 	//numera as moedas com maior mercado em ordem crescente
	
	private double volumeTotal;	//Total number of shares, contracts traded on national and regional exchanges of coin on a certain day
	
	private double porcentAlteracaoDePreco1hr;  //porcentagem de mudanca do preco em 1 hora
	private double porcentAlteracaoDePreco24hr; //porcentagem de mudanca do preco em 24 horas
	private double porcentAlteracaoDePreco7d;   //porcentagem de mudanca do preco em 7 dias

	public CriptoMoedaItem(String id, String nome, String simbolo) {
		super(id, nome, simbolo);
	}

	public CriptoMoedaItem(String id, String nome, String simbolo, double precoAtual, double capitalizMercado,
			int capitalizMercadoRanking, double volumeTotal, double porcentAlteracaoDePreco1hr,
			double porcentAlteracaoDePreco24hr, double porcentAlteracaoDePreco7d) {
		
		super(id, nome, simbolo);
		
		this.precoAtual = precoAtual;
		this.capitalizMercado = capitalizMercado;
		this.capitalizMercadoRanking = capitalizMercadoRanking;
		this.volumeTotal = volumeTotal;
		this.porcentAlteracaoDePreco1hr = porcentAlteracaoDePreco1hr;
		this.porcentAlteracaoDePreco24hr = porcentAlteracaoDePreco24hr;
		this.porcentAlteracaoDePreco7d = porcentAlteracaoDePreco7d;
	}


	public double getPrecoAtual() {
		return precoAtual;
	}

	public void setPrecoAtual(double precoAtual) {
		this.precoAtual = precoAtual;
	}

	public double getCapitalizMercado() {
		return capitalizMercado;
	}

	public void setCapitalizMercado(double capitalizMercado) {
		this.capitalizMercado = capitalizMercado;
	}

	public int getCapitalizMercadoRanking() {
		return capitalizMercadoRanking;
	}

	public void setCapitalizMercadoRanking(int capitalizMercadoRanking) {
		this.capitalizMercadoRanking = capitalizMercadoRanking;
	}

	public double getVolumeTotal() {
		return volumeTotal;
	}

	public void setVolumeTotal(double volumeTotal) {
		this.volumeTotal = volumeTotal;
	}

	public double getPorcentAlteracaoDePreco1hr() {
		return porcentAlteracaoDePreco1hr;
	}

	public void setPorcentAlteracaoDePreco1hr(double porcentAlteracaoDePreco1hr) {
		this.porcentAlteracaoDePreco1hr = porcentAlteracaoDePreco1hr;
	}

	public double getPorcentAlteracaoDePreco24hr() {
		return porcentAlteracaoDePreco24hr;
	}

	public void setPorcentAlteracaoDePreco24hr(double porcentAlteracaoDePreco24hr) {
		this.porcentAlteracaoDePreco24hr = porcentAlteracaoDePreco24hr;
	}

	public double getPorcentAlteracaoDePreco7d() {
		return porcentAlteracaoDePreco7d;
	}

	public void setPorcentAlteracaoDePreco7d(double porcentAlteracaoDePreco7d) {
		this.porcentAlteracaoDePreco7d = porcentAlteracaoDePreco7d;
	}
	
	
	
}
