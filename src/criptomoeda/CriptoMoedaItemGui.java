package criptomoeda;

import java.awt.Image;
import java.util.List;

public class CriptoMoedaItemGui extends CriptoMoedaItem {
	
	private Image icone = null; //icone da moeda***
	private List<Double> precos = null; //array de precos da moeda(nos ultimos 7 dias)***
	

	public CriptoMoedaItemGui(String id, String nome, String simbolo) {
		super(id, nome, simbolo);
	}

	public CriptoMoedaItemGui(String id, String nome, String simbolo, double precoAtual, double capitalizMercado,
			int capitalizMercadoRanking, double volumeTotal, double porcentAlteracaoDePreco1hr,
			double porcentAlteracaoDePreco24hr, double porcentAlteracaoDePreco7d, Image icone, List<Double> precos) {
		
		super(id, nome, simbolo, precoAtual, capitalizMercado, capitalizMercadoRanking, volumeTotal,
				porcentAlteracaoDePreco1hr, porcentAlteracaoDePreco24hr, porcentAlteracaoDePreco7d);
		
		this.icone = icone;
		this.precos = precos;
	}
	
	
	public Image getIcone() {
		return icone;
	}

	public void setIcone(Image icone) {
		this.icone = icone;
	}

	public List<Double> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Double> precos) {
		this.precos = precos;
	}

}
