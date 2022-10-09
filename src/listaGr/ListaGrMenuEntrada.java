package listaGr;


import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import constantes.ConstantesLista;


public class ListaGrMenuEntrada extends JToolBar{
	
	private static final long serialVersionUID = 1L;
	
	//atributos da classe
	
	private String inputPesquisaAtual;
	
	private String categoriaAtual;
	private String moedaConversaoAtual;
	private String ordemAtual;
	private int paginaAtual;
	private int qtdPorPaginaAtual;
	
	//componentes swing
	
	private ListaGrCampoEntrada painelPesquisa;
	
	private JLabel labelCategoria;
	private JComboBox<String> boxCategoria;
	
	private JLabel labelMoedaConversao;
	private JComboBox<String> boxMoedaConversao;
	
	private JLabel labelOrdem;
	private JComboBox<String> boxOrdem;
	
	private JLabel labelPagina;
	private JSpinner spinnerPagina;
	
	private JLabel labelQtdPorPagina;
	private JSpinner spinnerQtdPorPagina;
	
	public JButton btOK = new JButton("   OK   ");
	public JButton btApagar = new JButton("   apagar   ");
	
	//construtor

	public ListaGrMenuEntrada(String input, String categoria, String moedaConversao, String ordem, int pagina, int qtdPorPagina) {
		
		//instanciando atributos da classe com os paramêtros do construtor
		
		this.inputPesquisaAtual = input;
		this.categoriaAtual = categoria;
		this.moedaConversaoAtual = moedaConversao;
		this.ordemAtual = ordem;
		this.paginaAtual = pagina;
		this.qtdPorPaginaAtual = qtdPorPagina;
		
		
		//atributos de JToolBar
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 3));
		
		
		//instanciando componentes com os paramêtros do construtor
		
		painelPesquisa = new ListaGrCampoEntrada(input);
		
		labelCategoria = new JLabel("   categoria:   ");
		boxCategoria = new JComboBox<String>();
		
		labelMoedaConversao = new JLabel("   converter para:   ");
		boxMoedaConversao = new JComboBox<String>();
		
		labelOrdem = new JLabel("   ordem:   ");
		boxOrdem = new JComboBox<String>(ConstantesLista.ORDEM);
		
		labelPagina = new JLabel("   página:   ");
		spinnerPagina = new JSpinner(new SpinnerNumberModel(pagina, 
				ConstantesLista.MIN_PAGINA, ConstantesLista.MAX_PAGINA, 1));
		
		labelQtdPorPagina = new JLabel("   qtd por página:   ");
		spinnerQtdPorPagina = new JSpinner(new SpinnerNumberModel(qtdPorPagina, 
				ConstantesLista.MIN_QTD_PAGINA, ConstantesLista.MAX_QTD_PAGINA, 1));
		
		
		//pesquisar
		this.add(painelPesquisa);
		
		//categoria
		this.add(labelCategoria);
		this.add(boxCategoria);
				
		//moeda de conversão
		this.add(labelMoedaConversao);
		this.add(boxMoedaConversao);
				
		//ordem
		this.add(labelOrdem);
		this.add(boxOrdem);
				
		//página atual
		this.add(labelPagina);
		this.add(spinnerPagina);
				
		//qtd de itens por página
		this.add(labelQtdPorPagina);
		this.add(spinnerQtdPorPagina);
				
		//botões de controle
		this.add(btOK);
		this.add(btApagar);		
        
	}
	
	
	public String getInputPesquisaAtual() {
		return inputPesquisaAtual;
	}


	public void setInputPesquisaAtual(String inputPesquisaAtual) {
		this.inputPesquisaAtual = inputPesquisaAtual;
	}


	public String getCategoriaAtual() {
		return categoriaAtual;
	}


	public void setCategoriaAtual(String categoriaAtual) {
		this.categoriaAtual = categoriaAtual;
	}


	public String getMoedaConversaoAtual() {
		return moedaConversaoAtual;
	}


	public void setMoedaConversaoAtual(String moedaConversaoAtual) {
		this.moedaConversaoAtual = moedaConversaoAtual;
	}


	public String getOrdemAtual() {
		return ordemAtual;
	}


	public void setOrdemAtual(String ordemAtual) {
		this.ordemAtual = ordemAtual;
	}


	public int getPaginaAtual() {
		return paginaAtual;
	}


	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}



	public int getQtdPorPaginaAtual() {
		return qtdPorPaginaAtual;
	}


	public void setQtdPorPaginaAtual(int qtdPorPaginaAtual) {
		this.qtdPorPaginaAtual = qtdPorPaginaAtual;
	}


	public JSpinner getSpinnerPagina() {
		return spinnerPagina;
	}
	

	public void setSpinnerPagina(JSpinner spinnerPagina) {
		this.spinnerPagina = spinnerPagina;
	}
	
	public ListaGrCampoEntrada getPainelPesquisa() {
		return painelPesquisa;
	}


	public void setPainelPesquisa(ListaGrCampoEntrada painelPesquisa) {
		this.painelPesquisa = painelPesquisa;
	}


	public void atualizarInput() {
		
		this.inputPesquisaAtual = painelPesquisa.getInputPesquisaAtual();
		this.categoriaAtual = (String) boxCategoria.getSelectedItem();
		this.moedaConversaoAtual = (String) boxMoedaConversao.getSelectedItem();
		
		this.ordemAtual = (String) boxOrdem.getSelectedItem();
    	this.paginaAtual = (int)spinnerPagina.getValue();
    	this.qtdPorPaginaAtual = (int)spinnerQtdPorPagina.getValue();
    	
	}
	
	public void criarBoxMoedasConversao(List<String> moedas) {
		int tam = moedas.size();
		String[] arrayMoedas = new String[tam];
		
		for(int i = 0; i < tam ; i++) arrayMoedas[i] = moedas.get(i);
		
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(arrayMoedas);
		
		boxMoedaConversao.setModel(modelo);
		boxMoedaConversao.setSelectedItem("usd");
	}
	
	public void criarBoxCategorias(List<String> categorias) {
		int tam = categorias.size();
		String[] arrayCategorias = new String[tam+1];
		
		arrayCategorias[0] = ConstantesLista.FANTASMA_STR;
		
		for(int i = 0; i < tam ; i++) arrayCategorias[i+1] = categorias.get(i);
		
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(arrayCategorias);
		
		boxCategoria.setModel(modelo);
		
		boxMoedaConversao.setSelectedItem(ConstantesLista.FANTASMA_STR);
		//boxCategoria.setSelectedIndex(-1);
	}
	
	
}




