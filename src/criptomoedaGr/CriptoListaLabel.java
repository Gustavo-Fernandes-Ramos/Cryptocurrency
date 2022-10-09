package criptomoedaGr;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;

public class CriptoListaLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	
	public CriptoListaLabel(String texto, Dimension tamanhoPref, Dimension tamanhoMax) {
		super(texto);

		this.setPreferredSize(tamanhoPref); //tamanho m�nimo
		this.setMaximumSize(tamanhoMax); //tamanho m�ximo
		this.setFont(new Font("Courier", Font.PLAIN, 12));
		
		this.setHorizontalAlignment(JLabel.LEFT);
	    this.setVerticalAlignment(JLabel.CENTER);
	    
	}
}
