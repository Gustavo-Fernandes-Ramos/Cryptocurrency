package criptomoedaGr;

import java.awt.Dimension;

/*alterar a estrutura de dados List<Double>, para uma que possua acesso rápido ao maior, o menor, o primeiro e  elementos dentre a coleção */

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

import constantes.ConstantesCores;


public class CriptoListaGrafico extends JPanel {

	private static final long serialVersionUID = 1L;
	
	//atributos da classe
	
	private List<Double> precos; //lista com os precos da moeda nos últimos 7 dias
	private double maiorPreco;
	private double menorPreco;
	
	//construtor
	
	public CriptoListaGrafico(List<Double> precos, Dimension tamanhoPref, Dimension tamanhoMax) {
		super();
		this.precos = precos;

		//atributos JPanel swing

		this.setPreferredSize(tamanhoPref); //tamanho mínimo
		this.setMaximumSize(tamanhoMax); //tamanho máximo

		//obtem o maior e o menor preco dentre a lista de precos
		
		double preco;
		int tam = this.precos.size();
		
		if(tam > 0) {
			maiorPreco = this.precos.get(0);
			menorPreco = this.precos.get(0);
			for(int i = 1 ; i < tam ; i++) {
				preco = precos.get(i);
				if(preco > maiorPreco) this.maiorPreco = preco;
				if(preco < menorPreco) this.menorPreco = preco;
			}
		}
	}
	
	//tentar aprimorar ainda mais o algoritmo de exibicao do grafico
	
	public void paint(Graphics g) {
		int xvMax, xvMin, yvMax, yvMin;
		double y, yAnt, deltaY, preco;
		double ultimo, penultimo;
		
		//coordenadas da viewport
		
		xvMax = this.precos.size();	
		yvMax = this.getHeight()-30;
		
		xvMin = 0;	
		yvMin = 15;
		
		//caso haja ao menos 2 valores de preço
		
		if(xvMax >= 2) {
			
			//define a cor do grafico com base no penúltimo e último valor cronológico da moeda
			
			penultimo = this.precos.get(xvMax-2);
			ultimo = this.precos.get(xvMax-1);
			
			if(ultimo > penultimo) g.setColor(ConstantesCores.VERDE);
			else g.setColor(ConstantesCores.VERMELHO);
			
			//algoritmo que calcula as coordenadas e traça o grafico
			
			deltaY = (maiorPreco - menorPreco);
			
			preco = this.precos.get(0) - menorPreco;	//obtem o primeiro valor da moeda
			y = yvMax - (preco * yvMax / deltaY)+yvMin;
			
			for(int x = xvMin+1 ; x < xvMax ; x++) {
				
				yAnt = y;
				preco = this.precos.get(x) - menorPreco;
				y = yvMax - (preco * yvMax / deltaY)+yvMin;	//transforma o valor do preco em coordenada
				
				g.drawLine(x-1, (int)yAnt, x, (int)y);	//traceja retas com a coordenada atual e a anterior
			}
		}	
	}
}
