package execucao;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.SQLException;


public class FabricaConexao {
    
    Properties proBD = new Properties();
    private String nomePro;
     
    public FabricaConexao(String nomePro){
        FileInputStream leitorArquivo;
        
        this.setNomePro(nomePro);
        try{
            leitorArquivo = new FileInputStream(nomePro);
            proBD.load(leitorArquivo);            
        }catch(FileNotFoundException ex){
            System.out.println("Arquivo de configuracoes nao encontrado - "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro ao ler arquivo de configuracoes - "+ex.getMessage());
        }
    }
 
        
    public  Connection Conectar(){
        String url = proBD.getProperty("url");
        String driver = proBD.getProperty("driver");
        String urs = proBD.getProperty("urs");
        String pass = proBD.getProperty("pass");
        Connection conexao = null;
            
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, urs, pass);            
            System.out.println("Conexao estabelecida - Banco de Dados ("+this.getNomePro()+")");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver nao encontrado -"+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Banco nao conectado - "+ex.getMessage());
        }
        
        return conexao;
    }
        
    public void Desconectar(){
            
    }
        
    public void setNomePro(String nomePro) {
        this.nomePro = nomePro;
    }
    
        public String getNomePro() {
        return nomePro;
    }
        
}
