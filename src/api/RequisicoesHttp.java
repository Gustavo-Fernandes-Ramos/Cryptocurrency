package api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import constantes.ConstantesLista;
import criptomoeda.CriptoMoedaSimplesGr;

public class RequisicoesHttp {

	//constantes
	public static final String API_STATUS = "https://api.coingecko.com/api/v3/ping";
	public static final String SUPPORTED_CURRENCIES = "https://api.coingecko.com/api/v3/simple/supported_vs_currencies";
	public static final String COINS_LIST = "https://api.coingecko.com/api/v3/coins/list";
	public static final String ASSET_PLATFORMS = "https://api.coingecko.com/api/v3/asset_platforms";
	public static final String CATEGORIES_LIST = "https://api.coingecko.com/api/v3/coins/categories/list";
	
	//realizar requisicao de acordo com string passada
		
	public static String obterRequisicao(String stringUrl) {
		String inline = null;
		
		try {
            URL url = new URL(stringUrl);

            HttpURLConnection conexaoHttp = (HttpURLConnection) url.openConnection();
            conexaoHttp.setRequestMethod("GET");
            conexaoHttp.connect();

            int respostaHttp = conexaoHttp.getResponseCode();

            if (respostaHttp != 200) {
                throw new RuntimeException("HttpResponseCode: " + respostaHttp);
            } else {
                inline = "";
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) inline += scanner.nextLine();
                scanner.close(); 
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return inline;
	}
	
	//pesquisar
	
	public static String obterPesquisaDeCriptoMoedas(String input) {
		String inline = null;
		
		String stringUrl = "https://api.coingecko.com/api/v3/search?query=" + input;
		
		inline = obterRequisicao(stringUrl);

		return inline;
	}
	
	//obter dados de mercado de criptomoedas

	public static String obterListaDeCriptoMoedas(String categoria, String moedaConversao, String ordem, int qtdPorPagina, int paginaAtual) {
		
		String stringUrl, inline = null;
		
		if(categoria.equals(ConstantesLista.FANTASMA_STR)) {
			stringUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + moedaConversao + "&order=" + ordem + 
            		"&per_page=" + qtdPorPagina + "&page=" + paginaAtual + "&sparkline=true&price_change_percentage=1h%2C24h%2C7d";
		}else {
			stringUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + moedaConversao + "&category=" + categoria + "&order=" + ordem + 
            		"&per_page=" + qtdPorPagina + "&page=" + paginaAtual + "&sparkline=true&price_change_percentage=1h%2C24h%2C7d";
		}
		
		inline = obterRequisicao(stringUrl);
		
		return inline;
	}
	
	//obter dados de mercado de criptomoedas especificas
	
	public static String obterListaDeCriptoMoedasEspecificas(List<String> favoritos, String moedaConversao, String ordem, int qtdPorPagina, int paginaAtual) {
		String inline = null;
		
		String stringUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + moedaConversao + "&ids=";
		
		int tam = favoritos.size();
		for(int i = 0 ; i < tam ; i++) {
			stringUrl += favoritos.get(i) + "%2C";
		}
		
		stringUrl += "&order=" + ordem + "&per_page=" + qtdPorPagina + "&page=" + paginaAtual + "&sparkline=true&price_change_percentage=1h%2C24h%2C7d";
		
		inline = obterRequisicao(stringUrl);
		
		return inline;
	}
	
	public static String obterListaDeCriptoMoedasPesquisa(List<CriptoMoedaSimplesGr> listaPesquisa, String moedaConversao, String ordem, int qtdPorPagina, int paginaAtual) {
		String inline = null;
		
		String stringUrl = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + moedaConversao + "&ids=";
		
		int tam = listaPesquisa.size();
		for(int i = 0 ; i < tam ; i++) {
			stringUrl += listaPesquisa.get(i).getId() + "%2C";
		}
		
		stringUrl += "&order=" + ordem + "&per_page=" + qtdPorPagina + "&page=" + paginaAtual + "&sparkline=true&price_change_percentage=1h%2C24h%2C7d";
		
		inline = obterRequisicao(stringUrl);
		
		return inline;
	}

}
