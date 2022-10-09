
package criptomoedaGr;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class CriptoListaIcone extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Image imagem = null;
	
	public CriptoListaIcone(Image imagem, Dimension tamanhoPref, Dimension tamanhoMax) {
		super();
		this.imagem = imagem;
		
		this.setPreferredSize(tamanhoPref); //tamanho mínimo
		this.setMaximumSize(tamanhoMax); //tamanho máximo
		
	}
	
	public void paint(Graphics g) {
		
		int diametro = 30;
		int largura = this.getWidth();
		int altura = this.getHeight();
		
		g.drawImage(imagem,  (largura-diametro)/2, (altura-diametro)/2, diametro, diametro, this);
	}
}
