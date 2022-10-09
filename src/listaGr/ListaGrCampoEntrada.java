package listaGr;


import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

import constantes.ConstantesCores;

public class ListaGrCampoEntrada extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	//atributos da classe
	
	private String inputPesquisaAtual;
	
	//componentes swing
	
	private JComboBox<String> boxPesquisa;
	private JTextComponent campoPesquisa;
	private JButton btPesquisa;

	public ListaGrCampoEntrada(String input) {
		
		this.inputPesquisaAtual = input;
		this.setBackground(ConstantesCores.CINZA);
		
		//instanciando componentes swing com os paramêtros do construtor
		
		boxPesquisa = new JComboBox<String>();
		campoPesquisa = (JTextComponent) boxPesquisa.getEditor().getEditorComponent();
		campoPesquisa.setText(input);
		btPesquisa = new JButton("?"); 
		
		
		//atributos do JPanel
		
		boxPesquisa.setEditable(true);
		boxPesquisa.setPreferredSize(new Dimension(370, 27));
		boxPesquisa.setMaximumSize(new Dimension(370, 27));
		campoPesquisa.setDocument(new PlainDocument());
		
				
		//add itens ao componente swing da classe

		this.add(boxPesquisa);
		this.add(btPesquisa);
		
	}
	
	//getters e setters
	
	

	public String getInputPesquisaAtual() {
		return inputPesquisaAtual;
	}

	public void setInputPesquisaAtual(String inputPesquisaAtual) {
		this.inputPesquisaAtual = inputPesquisaAtual;
	}
	
	
	
	public JButton getBtPesquisa() {
		return btPesquisa;
	}

	public void setBtPesquisa(JButton btPesquisa) {
		this.btPesquisa = btPesquisa;
	}

	public JComboBox<String> getBoxPesquisa() {
		return boxPesquisa;
	}

	public void setBoxPesquisa(JComboBox<String> boxPesquisa) {
		this.boxPesquisa = boxPesquisa;
	}

	public JTextComponent getCampoPesquisa() {
		return campoPesquisa;
	}

	public void setCampoPesquisa(JTextComponent campoPesquisa) {
		this.campoPesquisa = campoPesquisa;
	}
	

	public void atualizarInput() {

		this.inputPesquisaAtual = (String)campoPesquisa.getText();
		System.out.println(this.inputPesquisaAtual);
	}
	
	/*public void pesquisar(){
	CriptoMoedaSimples criptoMoeda;
	String id, nome, simbolo;
	
	List<String> listaNomesCripto = new ArrayList<String>();
	
	inputPesquisaAtual = (String)boxPesquisa.getEditor().getItem(); //entrada do usuario
	
	int tam = criptoMoedasInfo.size();
	
	criarBoxPesquisa(listaNomesCripto);
	
}*/
	
	public void criarBoxPesquisa(List<String> moedas) {
		int tam = moedas.size();
		String[] arrayMoedas = new String[tam];
		
		for(int i = 0; i < tam ; i++) arrayMoedas[i] = moedas.get(i);
		
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<String>(arrayMoedas);
		
		boxPesquisa.setModel(modelo);
		boxPesquisa.setSelectedIndex(-1);
	}
		
}

