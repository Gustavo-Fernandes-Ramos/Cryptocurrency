package criptomoedaGr;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class CriptoListaCheckBox extends JCheckBox{
	
	private static final long serialVersionUID = 1L;
	
	public CriptoListaCheckBox(Dimension tamanhoPref, Dimension tamanhoMax) {
		super();
		
		this.setPreferredSize(tamanhoPref); //tamanho m�nimo
		this.setMaximumSize(tamanhoMax); //tamanho m�ximo
		
		this.setHorizontalAlignment(JLabel.RIGHT);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setOpaque(false);
		
	}
}
