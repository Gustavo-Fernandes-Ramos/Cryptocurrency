package criptomoedaGr;

import java.math.BigDecimal;

import javax.swing.BoxLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import constantes.ConstantesCores;
import criptomoeda.CriptoMoedaItemGui;

public class CriptoListaItem extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//componentes swing
	
	private String id;
	
	private CriptoListaCheckBox checkBoxFavorito; //checkbox de favoritos
	private CriptoListaIcone painelImagem; //painel de exibicao da imagem
	
	private CriptoListaLabel labelRankingSimbolo;
	private CriptoListaLabel labelNome;
	private CriptoListaLabel labelPrecoAtual;
	private CriptoListaLabel labelCapitalizMercado;
	private CriptoListaLabel labelPorcentAlteracaoDePreco1hr;
	private CriptoListaLabel labelPorcentAlteracaoDePreco24hr;
	private CriptoListaLabel labelPorcentAlteracaoDePreco7d;
	
	private CriptoListaGrafico painelGrafico;  //painel de exibicao do grafico

	//construtor
	
	public CriptoListaItem(CriptoMoedaItemGui moeda, String moedaConversao) {
		
		//seta atributos da classe
		
		this.setMaximumSize(ConstantesLista.DIMENSOES_MAX_ITEM); //tamanho máximo
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, ConstantesCores.CINZA_ESCURO, ConstantesCores.CINZA));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setBackground(ConstantesCores.BRANCA);
		
		//instância componentes
		
		checkBoxFavorito = new CriptoListaCheckBox(ConstantesLista.DIMENSOES_PREFER_CHECKBOX, ConstantesLista.DIMENSOES_MAX_CHECKBOX);  
		
		painelImagem = new CriptoListaIcone(moeda.getIcone(), ConstantesLista.DIMENSOES_PREFER_ICONE, ConstantesLista.DIMENSOES_MAX_ICONE);
		
		//instância as classes JLabel customizadas 
		
		id = moeda.getId();
		
		String label;
		
		label = String.valueOf(moeda.getCapitalizMercadoRanking()) + "º  -  " + moeda.getSimbolo();
		labelRankingSimbolo = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL, ConstantesLista.DIMENSOES_MAX_LABEL);
		
		label = moeda.getNome();
		labelNome = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL, ConstantesLista.DIMENSOES_MAX_LABEL);
		
		label =  moedaConversao + ":  " + new BigDecimal(String.valueOf(moeda.getPrecoAtual())).toPlainString();
		labelPrecoAtual = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL, ConstantesLista.DIMENSOES_MAX_LABEL);
		
		label = String.valueOf(Math.round(moeda.getPorcentAlteracaoDePreco1hr() * 100.0) / 100.0);
		labelPorcentAlteracaoDePreco1hr = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL_PORCENT, ConstantesLista.DIMENSOES_MAX_LABEL_PORCENT);
		
		label = String.valueOf(Math.round(moeda.getPorcentAlteracaoDePreco24hr() * 100.0) / 100.0);
		labelPorcentAlteracaoDePreco24hr = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL_PORCENT, ConstantesLista.DIMENSOES_MAX_LABEL_PORCENT);
		
		label = String.valueOf(Math.round(moeda.getPorcentAlteracaoDePreco7d() * 100.0) / 100.0);
		labelPorcentAlteracaoDePreco7d = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL_PORCENT, ConstantesLista.DIMENSOES_MAX_LABEL_PORCENT);
		
		label = moedaConversao + ":  " + new BigDecimal(String.valueOf(moeda.getCapitalizMercado())).toPlainString();
		labelCapitalizMercado = new CriptoListaLabel(label, ConstantesLista.DIMENSOES_PREFER_LABEL, ConstantesLista.DIMENSOES_MAX_LABEL);
		
		//instância o JPanel onde o gráfico será tracejado
		
		painelGrafico = new CriptoListaGrafico(moeda.getPrecos(), ConstantesLista.DIMENSOES_PREFER_GRAFICO, ConstantesLista.DIMENSOES_MAX_GRAFICO);
		
		//define a cor dos JLabels
		
		if(moeda.getPorcentAlteracaoDePreco1hr() > 0) labelPorcentAlteracaoDePreco1hr.setForeground(ConstantesCores.VERDE);
		else labelPorcentAlteracaoDePreco1hr.setForeground(ConstantesCores.VERMELHO);
		
		if(moeda.getPorcentAlteracaoDePreco24hr() > 0) labelPorcentAlteracaoDePreco24hr.setForeground(ConstantesCores.VERDE);
		else labelPorcentAlteracaoDePreco24hr.setForeground(ConstantesCores.VERMELHO);
		
		if(moeda.getPorcentAlteracaoDePreco7d() > 0) labelPorcentAlteracaoDePreco7d.setForeground(ConstantesCores.VERDE);
		else labelPorcentAlteracaoDePreco7d.setForeground(ConstantesCores.VERMELHO);
		
		//adiciona os componentes a classe
		
		this.add(checkBoxFavorito);
		this.add(painelImagem);
		this.add(labelRankingSimbolo);
		this.add(labelNome);
		this.add(labelPrecoAtual);
		this.add(labelPorcentAlteracaoDePreco1hr);
		this.add(labelPorcentAlteracaoDePreco24hr);
		this.add(labelPorcentAlteracaoDePreco7d);
		this.add(labelCapitalizMercado);
		this.add(painelGrafico);
		
	}

	public CriptoListaCheckBox getCheckBoxFavorito() {
		return checkBoxFavorito;
	}

	public void setCheckBoxFavorito(CriptoListaCheckBox checkBoxFavorito) {
		this.checkBoxFavorito = checkBoxFavorito;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
