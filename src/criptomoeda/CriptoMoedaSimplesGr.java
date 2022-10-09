package criptomoeda;

import java.awt.Image;

public class CriptoMoedaSimplesGr extends CriptoMoedaSimples{
	
	//atributos da classe
	
	private int capitalizMercadoRanking;
	private Image iconePequeno = null;
	private Image iconeGrande = null;
		
	//construtor
	
	public CriptoMoedaSimplesGr(String id, String nome, String simbolo, int capitalizMercadoRanking, Image iconePequeno,
			Image iconeGrande) {
		super(id, nome, simbolo);
		this.capitalizMercadoRanking = capitalizMercadoRanking;
		this.iconePequeno = iconePequeno;
		this.iconeGrande = iconeGrande;
	}
	
	//getters e setters

	public int getCapitalizMercadoRanking() {
		return capitalizMercadoRanking;
	}

	public void setCapitalizMercadoRanking(int capitalizMercadoRanking) {
		this.capitalizMercadoRanking = capitalizMercadoRanking;
	}

	public Image getIconePequeno() {
		return iconePequeno;
	}

	public void setIconePequeno(Image iconePequeno) {
		this.iconePequeno = iconePequeno;
	}

	public Image getIconeGrande() {
		return iconeGrande;
	}

	public void setIconeGrande(Image iconeGrande) {
		this.iconeGrande = iconeGrande;
	}

}
