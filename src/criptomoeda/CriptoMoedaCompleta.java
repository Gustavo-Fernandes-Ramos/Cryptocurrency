package criptomoeda;

public class CriptoMoedaCompleta extends CriptoMoedaItem{
	
	//private long fdv;			//(fully_diluted_valuation) futura capitalizacao de mercado após ser atingido o numero maximo de moedas
	//private double maiorPreco24hr;		//maior preco nas ultimas 24 horas
	//private double menorPreco24hr;		//menor preco nas ultimas 24 horas
	//private double alteracaoDePreco24hr;	//mudanca do preco em 24 horas
	
	//private long alteracaoDeCapitalizMercado24hr;			//mudanca da capitalização de mercado em 24 horas
	//private double porcentAlteracaoDeCapitalizMercado24hr;	//porcentagem de mudanca da capitalização de mercado em 24 horas

	//private double qtdMoedasCirculantes;	//qtd de moedas disponiveis publicamente e em circulação no mercado
	//private long qtdTotalDeMoedas;			//qtd de moedas existentes, estando em circulação ou trancadas
	//private long qtdMaximaDeMoedas;			//qtd máxima de moedas que serão criadas, para sempre
			
	//private double ath; 					//maior preco historico
	//private double athPorcentAlteracao;		//porcentagem de mudanca do preco com relacao ao maior preco historico
	//private String ath_data; 				//data do maior preco historico
			
	//private double atl; 					//menor preco historico
	//private double atlPorcentAlteracao;		//porcentagem de mudanca do preco com relacao ao menor preco historico
	//private String atl_data; 				//data do menor preco historico
			
	//private String ultimoUpdate; 	//string com a data da ultima atualizacao(ex: "2022-01-11T16:58:06.121Z")

	public CriptoMoedaCompleta(String id, String nome, String simbolo, double precoAtual, double capitalizMercado,
			int capitalizMercadoRanking, double volumeTotal, double porcentAlteracaoDePreco1hr,
			double porcentAlteracaoDePreco24hr, double porcentAlteracaoDePreco7d) {
		
		super(id, nome, simbolo, precoAtual, capitalizMercado, capitalizMercadoRanking, volumeTotal, porcentAlteracaoDePreco1hr,
				porcentAlteracaoDePreco24hr, porcentAlteracaoDePreco7d);

	}
	


}
