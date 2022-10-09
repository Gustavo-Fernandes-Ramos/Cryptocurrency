package listaGr;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import api.RequisicoesHttp;
import arquivoJson.EscritaJson;
import arquivoJson.LeituraJson;
import constantes.ConstantesLista;
import criptomoeda.CriptoMoedaItemGui;
import criptomoeda.CriptoMoedaSimplesGr;
import criptomoedaGr.CriptoListaItem;

public class ListaGr extends JFrame implements ActionListener, KeyListener{
	
	private static final long serialVersionUID = 1L;
	
	//atributos da classe
	
	private String inputPesquisaAtual = "";
	private String categoriaAtual = ConstantesLista.FANTASMA_STR;
	private String moedaConversaoAtual = "usd";
	private String ordemAtual = "ConstantesLista.ORDEM[0]";
	private int paginaAtual = 1;
	private int qtdPorPaginaAtual = 25;
	
	//Estruturas de dados para armazenar os diferentes tipos de dados obtidos através da API
	
	private List<String> favoritos = null; 			//a id de todas as criptomoedas favoritas
	private List<String> categorias = null; 		//todas as categorias disponibilizadas pela API
	private List<String> moedasConversao = null; 	//obtem todas as possíveis moedas de conversão as quais os valores são convertidos (ex: usd )
	private List<CriptoMoedaSimplesGr> criptoMoedasPesquisa = null; 	//todas as criptomoedas vinculadas à API (atributos: nome, id e simbolo).
	private List<CriptoMoedaItemGui> criptoMoedasAtuais = null; 		//lista de criptomoedas atualmente sendo exibidas no painel
	
	//menu de navegação no formato de um formulário
	
	private ListaGrMenuEntrada formularioInput = new ListaGrMenuEntrada(inputPesquisaAtual, categoriaAtual, moedaConversaoAtual, ordemAtual, paginaAtual, qtdPorPaginaAtual);
	
	//painel principal
	
	private JPanel painelMoedas = new JPanel();
	private JScrollPane scrollPainelMoedas = new JScrollPane(painelMoedas, 
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	//menu de navegacao inferior
	
	private ListaGrMenuRapido menuRapido = new  ListaGrMenuRapido();
	
	//construtor
	
	public ListaGr(int largura, int altura) {
		
		//atributos do JFrame
		
		super("Cryptocurrency");
		this.setSize(largura, altura);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		painelMoedas.setLayout(new BoxLayout(painelMoedas, BoxLayout.PAGE_AXIS));
		painelMoedas.setBorder(new EmptyBorder(27, 27, 27, 27));
		
		formularioInput.getPainelPesquisa().getCampoPesquisa().addKeyListener(this);
		
		favoritos = LeituraJson.lerListaDeFavoritos();
		
		//obtem todas as moedas de conversão da API
		
		categorias = LeituraJson.lerCategorias(RequisicoesHttp.obterRequisicao(RequisicoesHttp.CATEGORIES_LIST));
		formularioInput.criarBoxCategorias(categorias);

		//obtem todas as moedas de conversão da API
		
		moedasConversao = LeituraJson.lerMoedasDeConversao(RequisicoesHttp.obterRequisicao(RequisicoesHttp.SUPPORTED_CURRENCIES));
		formularioInput.criarBoxMoedasConversao(moedasConversao);
		
		//obtem da API todas as criptomoedas que terão suas informações básicas exibidas
		
		criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedas(
				this.categoriaAtual, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
		
		
		
		criarPainelMoedas(criptoMoedasAtuais);

		//add os componentes abaixo no componente desta classe 
		
		this.getContentPane().add(formularioInput, BorderLayout.NORTH);
		this.getContentPane().add(scrollPainelMoedas, BorderLayout.CENTER);
		this.getContentPane().add(menuRapido, BorderLayout.SOUTH);
        this.setVisible(true);  
        
        //eventos

        formularioInput.btOK.addActionListener(e -> {
        	solicitarPagina();
		});
        
		formularioInput.btApagar.addActionListener(e -> {
        	apagarPagina();
		});
        
        menuRapido.getBtPaginaProxima().addActionListener(e -> {
        	solicitarNovaPagina(1);
		});
        
        menuRapido.getBtPaginaMuitoProxima().addActionListener(e -> {
        	solicitarNovaPagina(5);
		});
        
        menuRapido.getBtPaginaAnterior().addActionListener(e -> {
        	solicitarNovaPagina(-1);
		});
        
        menuRapido.getBtPaginaMuitoAnterior().addActionListener(e -> {
        	solicitarNovaPagina(-5);
		});
        
        menuRapido.getBtFavoritos().addActionListener(e -> {
        	solicitarPaginaFavoritos();
        });
        
        formularioInput.getPainelPesquisa().getBtPesquisa().addActionListener(e -> {
        	solicitarPaginaPesquisa();
        	
        });
        
        this.addWindowListener(new WindowAdapter() {
    	    public void windowClosing(WindowEvent e) {
    	        EscritaJson.escreverListaDeFavoritos(favoritos);
    	    }
    	});

	}
	

	public void criarPainelMoedas(List<CriptoMoedaItemGui> listaDeCriptomoedas) {		
		CriptoListaItem criptoItem;
		String nomeCripto;
		boolean ok;
		int i, j, tam, tamFavoritos;
		
		tam = listaDeCriptomoedas.size();
		for(i = 0 ; i < tam ; i++) {
			
			criptoItem = new CriptoListaItem(listaDeCriptomoedas.get(i), this.moedaConversaoAtual); 
			nomeCripto = criptoItem.getId();
			
			tamFavoritos = favoritos.size();
			j = 0;
			ok = false;
			while((j < tamFavoritos) && (ok != true)) {
				
				if(nomeCripto.equals(favoritos.get(j))) ok = true;
				j++;
			}
			
			if(ok == true) criptoItem.getCheckBoxFavorito().setSelected(true);
				
			criptoItem.getCheckBoxFavorito().addActionListener(this);
			painelMoedas.add(criptoItem);
			painelMoedas.add(Box.createRigidArea(new Dimension(0, 5)));
			//seta o valor da scrollbar para o valor mínimo (topo da página)
			scrollPainelMoedas.getVerticalScrollBar().setValue(scrollPainelMoedas.getVerticalScrollBar().getMinimum());
		}

		this.revalidate();
		this.repaint();
		
	}
	
	public void apagarPagina() {
		painelMoedas.removeAll();
    	painelMoedas.revalidate();
    	painelMoedas.repaint();
	}
	
	public void solicitarPaginaPesquisa() {
		this.inputPesquisaAtual = (String)formularioInput.getPainelPesquisa().getCampoPesquisa().getText(); //entrada do usuario
    	criptoMoedasPesquisa = LeituraJson.lerCriptoMoedasPesquisa(RequisicoesHttp.obterPesquisaDeCriptoMoedas(this.inputPesquisaAtual));
    	//realizar uma nnova requisicao que obtenha as informações de lista das criptomoedas classe CriptoMoedaItemGui
    	
    	criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedasPesquisa(
    			this.criptoMoedasPesquisa, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
    	
    	painelMoedas.removeAll();
    	criarPainelMoedas(criptoMoedasAtuais);
	}
	
	public void solicitarPaginaFavoritos() {
		formularioInput.atualizarInput();
    	
		this.moedaConversaoAtual = formularioInput.getMoedaConversaoAtual();
		this.ordemAtual = formularioInput.getOrdemAtual();
		this.paginaAtual = formularioInput.getPaginaAtual();
		this.qtdPorPaginaAtual = formularioInput.getQtdPorPaginaAtual();
    	
    	criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedasEspecificas(
    			this.favoritos, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
    	
    	painelMoedas.removeAll();
    	criarPainelMoedas(criptoMoedasAtuais);
	}
	
	public void solicitarPagina() {
		formularioInput.atualizarInput();
    	
    	this.inputPesquisaAtual = formularioInput.getInputPesquisaAtual();
		this.categoriaAtual = formularioInput.getCategoriaAtual();
		this.moedaConversaoAtual = formularioInput.getMoedaConversaoAtual();
		this.ordemAtual = formularioInput.getOrdemAtual();
		this.paginaAtual = formularioInput.getPaginaAtual();
		this.qtdPorPaginaAtual = formularioInput.getQtdPorPaginaAtual();
    	
    	criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedas(
    			this.categoriaAtual, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
    	
    	painelMoedas.removeAll();
    	criarPainelMoedas(criptoMoedasAtuais);
	}
	
	/*altera a pagina atual sendo exibida através de uma nova requisição, a página
	a ser exibida avança ou retrocede de acordo com o sinal do parâmetro da função*/
	public void solicitarNovaPagina(int numPaginas) {
		formularioInput.atualizarInput();
		
		int novaPagina, paginaAnterior = this.paginaAtual;

		if(numPaginas != 0) {
			novaPagina = paginaAnterior + numPaginas;
	
			if((novaPagina <= ConstantesLista.MAX_PAGINA) && (novaPagina >= ConstantesLista.MIN_PAGINA)) {
				
	        	this.paginaAtual = novaPagina;
	        	
	        	formularioInput.setPaginaAtual(this.paginaAtual);
	        	formularioInput.getSpinnerPagina().setValue(this.paginaAtual);
	        	
	        	criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedas(
	        			this.categoriaAtual, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
	        	
	        	painelMoedas.removeAll();
	        	criarPainelMoedas(criptoMoedasAtuais);
			}
		}	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JCheckBox componente = (JCheckBox)e.getSource();
		CriptoListaItem parente = (CriptoListaItem) componente.getParent();
		
		if(componente.isSelected()) favoritos.add(parente.getId());
		else favoritos.remove(parente.getId());
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		/*
		this.inputPesquisaAtual = (String)formularioInput.getPainelPesquisa().getCampoPesquisa().getText(); //entrada do usuario
		
    	criptoMoedasPesquisa = LeituraJson.lerCriptoMoedasPesquisa(RequisicoesHttp.obterPesquisaDeCriptoMoedas(this.inputPesquisaAtual));
    	
    	criptoMoedasAtuais = LeituraJson.lerListaDeCriptoMoedas(RequisicoesHttp.obterListaDeCriptoMoedasPesquisa(
    			this.criptoMoedasPesquisa, this.moedaConversaoAtual, this.ordemAtual, this.qtdPorPaginaAtual, this.paginaAtual));
    	
    	painelMoedas.removeAll();
    	criarPainelMoedas(criptoMoedasAtuais);
    	*/
		
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) { }


	
}
