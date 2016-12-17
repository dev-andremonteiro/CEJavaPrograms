
package executavel;

import java.io.*;
import java.util.regex.Pattern;


public class Executar {

    public static void main(String[] args) throws IOException{
        
        InputStream IS = new FileInputStream("arquivo.txt");
        InputStreamReader ISR = new InputStreamReader(IS);
        BufferedReader BR = new BufferedReader (ISR);
        String s = BR.readLine();
        String Entrada = "";
        
        int x = -1;
        
        do{
            Entrada += s + "\n";
            s = BR.readLine();
            x++;
        }while(s != null);
        
        String Dados[] = Entrada.split(Pattern.quote("\n"));
        
        OutputStream OS = new FileOutputStream("saida.txt");
        OutputStreamWriter OSW = new OutputStreamWriter(OS);
        BufferedWriter BW = new BufferedWriter(OSW);
        
        
        do{
            BW.write(Dados[x]);
            BW.newLine();
            x--;
        }while(x != -1);

        BR.close();
        BW.close();
        
        
    }

    
}

