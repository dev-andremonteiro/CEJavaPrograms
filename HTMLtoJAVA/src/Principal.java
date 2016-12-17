
import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Principal {
    
    public static void main(String[] args) throws IOException {
        
        File input = new File("Tabela Sintatica.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        String [][] campos = new String[63][40]; //35
        Element table = doc.select("table").get(0);
        Elements linhas = table.select("tr");
        String aux = new String();
        
    for (int i = 0; i < linhas.size(); i++) {
        Element linha = linhas.get(i);
        Elements cols = linha.select("td");
        
        for(int j = 0; j < cols.size(); j++){
            aux = cols.get(j).text();
            aux = aux.replaceAll("<", "");
            aux = aux.replaceAll(">", "");
            System.out.print(aux +"  ");
            campos[i][j] = aux;
        }
        System.out.println("");
    }
        
    
    
        
        
        
        
    }
    
}
