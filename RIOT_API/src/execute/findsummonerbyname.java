package execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import jdk.nashorn.internal.ir.debug.JSONWriter;

public class findsummonerbyname {


    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String key = "?api_key=4877f64d-de4e-410f-b616-26dc6a8ce8ba";
        String api_pvp = ".api.pvp.net/";
        String summonerbyname = "observer-mode/rest/featured";
        String version = "/v1.4/";
        String regiao;
        String summoner; 
        int cont = 3;
        URL url;
        URLConnection yc;
        BufferedReader br;
        StringBuffer sb;
        File arquivo;
        PrintWriter output;
        
        
        summoner = new String();
        summoner = "ND YcY";
        
        regiao = new String();
        regiao = "br";

        summoner = summoner.replace(" ", "");
        summoner = summoner.toLowerCase();
    
    
        //do {
            url = new URL("https://" + regiao + api_pvp + summonerbyname + key);
            yc = url.openConnection();
            yc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

            InputStream result = yc.getInputStream();
            br = new BufferedReader(new InputStreamReader(result));
            String line;
            sb = new StringBuffer();

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');

            }
            br.close();
            
            /*
            arquivo = new File("test.txt");

            output = new PrintWriter(arquivo);
            output.println(sb.toString());
            output.close();
            */
            
            
            System.out.println(sb);
            String palavra = "\"summonerName\":\"TheFoxz1\"";
            line = "";
            int count = 0;
            
            System.out.println(palavra);
            
            
            br = new BufferedReader(new FileReader("C:\\Users\\ANDRÉ\\Documents\\NetBeansProjects\\RIOT_API\\test.txt"));
            while ((line = br.readLine()) != null){
                String [] words = line.split(",");
                         
                
                for(String word: words){
                    if(word.equals(palavra)){
                        count++;
                    }
                    System.out.println(word);
                }
                
            }
            
            
            
            System.out.println(count);

        //    cont++;
            
        /*    try {
                Thread.sleep(300000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
        } while (cont != 10);
        */
            
        
        
            
    }
    
    
}
