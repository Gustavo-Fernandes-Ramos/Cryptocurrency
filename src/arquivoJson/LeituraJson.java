package arquivoJson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import criptomoeda.CriptoMoedaItemGui;
import criptomoeda.CriptoMoedaSimples;
import criptomoeda.CriptoMoedaSimplesGr;

public class LeituraJson {
	
	public static List<String> lerListaDeFavoritos() {
		
		List<String> listaFavoritos = null;
		JSONParser parser = new JSONParser();
		
		 try (Reader reader = new FileReader("favoritos.json")) {

	        JSONArray arrayFavoritosJson = (JSONArray) parser.parse(reader);
	       
	        listaFavoritos = new ArrayList<String>();
	        
	        int tam = arrayFavoritosJson.size();
			
			for(int i = 0 ; i < tam ; i++) {
				listaFavoritos.add((String)arrayFavoritosJson.get(i));
			}

	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
		 
		return listaFavoritos;
	}
	
	//transforma uma string em formato json - ler lista de moedas para conversão de valores
	
	public static List<String> lerMoedasDeConversao(String jsonFormatoString) {
		List<String> moedas = null;
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONArray arrayMoedasJson = (JSONArray) parser.parse(jsonFormatoString);
			
			moedas = new ArrayList<String>();
			
			int tam = arrayMoedasJson.size();
            for(int i = 0 ; i < tam ; i++) moedas.add((String)arrayMoedasJson.get(i));
            

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return moedas;
	}
	
	//transforma uma string em formato json - ler lista de categorias de criptomoedas
	
	public static List<String> lerCategorias(String jsonFormatoString) {
		List<String> categorias = null;
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONArray arrayCategoriasJson = (JSONArray) parser.parse(jsonFormatoString);
			
			categorias = new ArrayList<String>();
			
			String categoriaStr;
			
			JSONObject categoriaJson;
			
			int tam = arrayCategoriasJson.size();
	           for(int i = 0 ; i < tam ; i++) {
	           	categoriaJson = (JSONObject) arrayCategoriasJson.get(i);
	           	
	           	categoriaStr = (String)categoriaJson.get("category_id");
	           	categorias.add(categoriaStr);
	           }
	           
			} catch (ParseException e) {
			e.printStackTrace();
			}
		
		return categorias;
	}
	
	
	//transforma uma string em formato json - ler lista de criptomoedas com id, nome e simbolo de cada criptomoeda
	
	public static List<CriptoMoedaSimples> lerCriptoMoedas(String jsonFormatoString) {
		List<CriptoMoedaSimples> criptoMoedas = null;
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONArray arrayCriptoMoedasJson = (JSONArray) parser.parse(jsonFormatoString);
			
			criptoMoedas = new ArrayList<CriptoMoedaSimples>();
			
			CriptoMoedaSimples criptoMoeda;
			
			String id;
			String nome;
			String simbolo;
			
			JSONObject criptoMoedaJson;

			int tam = arrayCriptoMoedasJson.size();
            for(int i = 0 ; i < tam ; i++) {
            	criptoMoedaJson = (JSONObject) arrayCriptoMoedasJson.get(i);
            	
            	id = (String)criptoMoedaJson.get("id");
            	nome = (String)criptoMoedaJson.get("name");
            	simbolo = (String)criptoMoedaJson.get("symbol");
            	
            	criptoMoeda = new CriptoMoedaSimples(id, nome, simbolo);
            	criptoMoedas.add(criptoMoeda);
            } 

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return criptoMoedas;
	}
	
	
	//transforma uma string em formato json - ler lista de criptomoedas com informações suficientes para criar um item de lista
	
	public static List<CriptoMoedaItemGui> lerListaDeCriptoMoedas(String jsonFormatoString) {
		int tam, tamPreco;
		
		List<CriptoMoedaItemGui> criptoMoedas = null;
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONArray arrayCriptoMoedasJson = (JSONArray) parser.parse(jsonFormatoString);
			
			criptoMoedas = new ArrayList<CriptoMoedaItemGui>();
			CriptoMoedaItemGui criptoMoeda;
			
			JSONObject criptoMoedaJson;
			JSONObject precosJson;
			JSONArray arrayPrecosJson;
			
			String id;
			String nome;
			String simbolo;
			String imagem;
			
			double precoAtual;
			double capitalizMercado;
			int capitalizMercadoRanking;
			double volumeTotal;
			double porcentAlteracaoDePreco1hr;
			double porcentAlteracaoDePreco24hr;
			double porcentAlteracaoDePreco7d;
			
			Object precoAtualObj;
			Object capitalizMercadoObj;
			Object capitalizMercadoRankingObj;
			Object volumeTotalObj;
			Object porcentAlteracaoDePreco1hrObj;
			Object porcentAlteracaoDePreco24hrObj;
			Object porcentAlteracaoDePreco7dObj;
			
			List<Double> precos = null;
			
			tam = arrayCriptoMoedasJson.size();
            for(int i = 0 ; i < tam ; i++) {

            	criptoMoedaJson = (JSONObject)arrayCriptoMoedasJson.get(i);
            	
            	id = (String)criptoMoedaJson.get("id");
            	nome = (String)criptoMoedaJson.get("name");
            	simbolo = (String)criptoMoedaJson.get("symbol");
            	imagem = (String)criptoMoedaJson.get("image");
            	
            	precoAtualObj = criptoMoedaJson.get("current_price");
            	if(precoAtualObj != null) precoAtual = Double.parseDouble(precoAtualObj.toString());
            	else precoAtual = 0.0;
            	
            	capitalizMercadoObj = criptoMoedaJson.get("market_cap");
            	if(capitalizMercadoObj != null) capitalizMercado = Double.parseDouble(capitalizMercadoObj.toString());
            	else capitalizMercado = 0.0;
            	
            	capitalizMercadoRankingObj = criptoMoedaJson.get("market_cap_rank");
            	if(capitalizMercadoRankingObj != null) capitalizMercadoRanking = Integer.parseInt(capitalizMercadoRankingObj.toString());
            	else capitalizMercadoRanking = 0;
            	
            	volumeTotalObj = criptoMoedaJson.get("total_volume");
            	if(volumeTotalObj != null) volumeTotal = Double.parseDouble(volumeTotalObj.toString());
            	else volumeTotal = 0.0;
            	
            	porcentAlteracaoDePreco1hrObj = criptoMoedaJson.get("price_change_percentage_1h_in_currency");
            	if(porcentAlteracaoDePreco1hrObj != null) porcentAlteracaoDePreco1hr = Double.parseDouble(porcentAlteracaoDePreco1hrObj.toString());
            	else porcentAlteracaoDePreco1hr = 0.0;
            	
            	porcentAlteracaoDePreco24hrObj = criptoMoedaJson.get("price_change_percentage_24h_in_currency");
            	if(porcentAlteracaoDePreco24hrObj != null) porcentAlteracaoDePreco24hr = Double.parseDouble(porcentAlteracaoDePreco24hrObj.toString());
            	else porcentAlteracaoDePreco24hr = 0.0;
            			
            	porcentAlteracaoDePreco7dObj = criptoMoedaJson.get("price_change_percentage_7d_in_currency");
            	if(porcentAlteracaoDePreco7dObj != null) porcentAlteracaoDePreco7d = Double.parseDouble(porcentAlteracaoDePreco7dObj.toString());
            	else porcentAlteracaoDePreco7d = 0.0;
            	
            	precosJson = (JSONObject)criptoMoedaJson.get("sparkline_in_7d");
            	arrayPrecosJson = (JSONArray)precosJson.get("price");
            	
            	if(arrayPrecosJson != null) {
            		precos = new ArrayList<Double>();
            		tamPreco = arrayPrecosJson.size();
                    for(int j = 0 ; j < tamPreco ; j++) precos.add(Double.parseDouble(arrayPrecosJson.get(j).toString()));
            	}
       
            	criptoMoeda = new CriptoMoedaItemGui(id, nome, simbolo, precoAtual, capitalizMercado, capitalizMercadoRanking, volumeTotal,  
            			porcentAlteracaoDePreco1hr, porcentAlteracaoDePreco24hr, porcentAlteracaoDePreco7d, ImageIO.read(new URL(imagem)),
            			precos);
            	
            	criptoMoedas.add(criptoMoeda);
            }
			
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return criptoMoedas;
	}
	
	public static List<CriptoMoedaSimplesGr> lerCriptoMoedasPesquisa(String jsonFormatoString) {
		List<CriptoMoedaSimplesGr> criptoMoedas = null;
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject) parser.parse(jsonFormatoString);
			
			String id;
			String nome;
			String simbolo;
			
			int capitalizMercadoRanking;
			String iconePequeno;
			String iconeGrande;
			
			Object capitalizMercadoRankingObj;
			Object iconePequenoObj;
			Object iconeGrandeObj;
			
			JSONArray arrayCriptoMoedasJson = (JSONArray) obj.get("coins");
			JSONObject criptoMoedaJson;
			
			criptoMoedas = new ArrayList<CriptoMoedaSimplesGr>();
			CriptoMoedaSimplesGr criptoMoeda;
			
			int tam = arrayCriptoMoedasJson.size();
            for(int i = 0 ; i < tam ; i++) {
            	criptoMoedaJson = (JSONObject) arrayCriptoMoedasJson.get(i);
            	
            	id = (String)criptoMoedaJson.get("id");
            	nome = (String)criptoMoedaJson.get("name");
            	simbolo = (String)criptoMoedaJson.get("symbol");
            	
            	capitalizMercadoRankingObj = criptoMoedaJson.get("market_cap_rank");
            	if(capitalizMercadoRankingObj != null) capitalizMercadoRanking = Integer.parseInt(capitalizMercadoRankingObj.toString());
            	else capitalizMercadoRanking = 0;
            	
            	iconePequenoObj = criptoMoedaJson.get("thumb");
            	if(iconePequenoObj != null) iconePequeno = (String)iconePequenoObj;
            	else iconePequeno = null;
            	
            	iconeGrandeObj = criptoMoedaJson.get("large");
            	if(iconeGrandeObj != null) iconeGrande = (String)iconeGrandeObj;
            	else iconeGrande = null;
            	
            	criptoMoeda = new CriptoMoedaSimplesGr(id, nome, simbolo, capitalizMercadoRanking, ImageIO.read(new URL(iconePequeno)), ImageIO.read(new URL(iconeGrande)));
            	criptoMoedas.add(criptoMoeda);
            } 

		} catch (ParseException e) {
			e.printStackTrace();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return criptoMoedas;
	}
}
