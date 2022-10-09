package listaGr;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ListaGrMenuRapido extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	//componentes swing
	
	private JButton btPaginaAnterior = new JButton("página anterior");
	private JButton btPaginaMuitoAnterior = new JButton("<<<");
	private JButton btPaginaProxima = new JButton("próxima página");
	private JButton btPaginaMuitoProxima = new JButton(">>>");
	private JButton btFavoritos = new JButton("favoritos");
	
	//construtor

	public ListaGrMenuRapido() {
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		this.add(btPaginaMuitoAnterior);
		this.add(btPaginaAnterior);
		
		this.add(btFavoritos);
		
		this.add(btPaginaProxima);
		this.add(btPaginaMuitoProxima);
	}
	
	//getters e setters

	public JButton getBtPaginaAnterior() {
		return btPaginaAnterior;
	}

	public void setBtPaginaAnterior(JButton btPaginaAnterior) {
		this.btPaginaAnterior = btPaginaAnterior;
	}

	public JButton getBtPaginaMuitoAnterior() {
		return btPaginaMuitoAnterior;
	}

	public void setBtPaginaMuitoAnterior(JButton btPaginaMuitoAnterior) {
		this.btPaginaMuitoAnterior = btPaginaMuitoAnterior;
	}

	public JButton getBtFavoritos() {
		return btFavoritos;
	}

	public void setBtFavoritos(JButton btFavoritos) {
		this.btFavoritos = btFavoritos;
	}

	public JButton getBtPaginaProxima() {
		return btPaginaProxima;
	}

	public void setBtPaginaProxima(JButton btPaginaProxima) {
		this.btPaginaProxima = btPaginaProxima;
	}

	public JButton getBtPaginaMuitoProxima() {
		return btPaginaMuitoProxima;
	}

	public void setBtPaginaMuitoProxima(JButton btPaginaMuitoProxima) {
		this.btPaginaMuitoProxima = btPaginaMuitoProxima;
	}
	
	

	
}
