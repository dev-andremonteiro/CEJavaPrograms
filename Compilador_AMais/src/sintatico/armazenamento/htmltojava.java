package sintatico.armazenamento;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class htmltojava {

    private String[][] campos; //35

    public htmltojava(String caminho, int x) throws IOException {

        File input = new File(caminho);
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
        Element table = doc.select("table").get(x);
        Elements linhas = table.select("tr");
        String aux;
        if (x == 1) {
            campos = new String[67][40];
        } else {
            campos = new String[37][40];
        }
        for (int i = 0; i < linhas.size(); i++) {
            Element linha = linhas.get(i);
            Elements cols = linha.select("td");

            for (int j = 0; j < cols.size(); j++) {
                aux = cols.get(j).text();
                aux = aux.replaceAll("<", "");
                aux = aux.replaceAll(">", "");
                this.campos[i][j] = aux;
            }
        }

        if (x == 1) {
            for (int w = 0; w < 67; w++) {
                this.campos[w][0] = "1" + this.campos[w][0];
                if (w < 10) {
                    this.campos[w][0] = this.campos[w][0].substring(1, 2);
                } else {
                    this.campos[w][0] = this.campos[w][0].substring(1, 3);
                }

                String[] palavras = this.campos[w][1].split(" ");
                int t = 2;
                int z = 1;
                while (t < palavras.length) {
                    this.campos[w][z] = palavras[t];
                    t++;
                    z++;
                }
            }
        }

        for (int w = 0; w < campos.length; w++) {
            this.campos[w] = Arrays.stream(this.campos[w])
                    .filter(s -> (s != null && s.length() > 0))
                    .toArray(String[]::new);
        }

    }

    public void imprimirTabela() {
        System.out.println("");
        for (String[] aux : this.campos) {
            for (int w = 0; w < aux.length; w++) {
                System.out.print(aux[w] + " ");
            }
            System.out.println("");
        }
    }

    public String[][] getCampos() {
        return campos;
    }

    public void setCampos(String[][] campos) {
        this.campos = campos;
    }
}
