package arquivoJson;

import java.io.IOException;
import java.util.List;
import org.json.simple.JSONArray;
import java.io.FileWriter;

public class EscritaJson {

	public static void escreverListaDeFavoritos(List<String> listaFavoritos) {
		JSONArray arrayFavoritosJson = new JSONArray();
		
		int tam = listaFavoritos.size();
		
		for(int i = 0 ; i < tam ; i++) {
			arrayFavoritosJson.add(listaFavoritos.get(i));
		}
		
		try (FileWriter file = new FileWriter("favoritos.json")) {
            file.write(arrayFavoritosJson.toJSONString());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
