package lexico.conceito.entrada;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitor {

    private String Entrada;

    public Leitor(String caminho) {

        try {
            InputStream IS = new FileInputStream(caminho);
            InputStreamReader ISR = new InputStreamReader(IS);
            BufferedReader BR = new BufferedReader(ISR);
            String s = BR.readLine();

            Entrada = "";

            int x = -1;

            do {
                Entrada += s + "\n";
                s = BR.readLine();
                x++;
            } while (s != null);

            Entrada = Entrada.replaceAll("\t", "");

        } catch (FileNotFoundException ex) {
            System.out.println("Não foi possivel encontrar o arquivo fonte - " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String getEntrada() {
        return Entrada;
    }

}
