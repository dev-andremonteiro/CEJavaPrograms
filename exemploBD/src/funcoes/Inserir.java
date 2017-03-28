package funcoes;

import entrada.Menu;
import execucao.FabricaConexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserir {
    
    Connection con = null;
    Statement comando = null;
    
    public Inserir(){
        FabricaConexao fbc = new FabricaConexao("banco.properties");
        con = fbc.Conectar();
    }
        
    public void inserirAluno(){
        
        String sql = "INSERT INTO ALUNO ( MATRICULA, NOME, NOMEPAI, NOMEMAE, ENDERECO, SEXO ) VALUES ";
        
        Menu menu = new Menu();
        
        String matricula = menu.getEntrada("Matricula: ");
        String nome = menu.getEntrada("Nome: ");
        String nomepai = menu.getEntrada("Nome Pai:");
        String nomemae = menu.getEntrada("Nome mae:");
        String endereco = menu.getEntrada("Endereco Completo:");
        String sexo = menu.getEntrada("Sexo:");
        
        sql += "( '"+ matricula +"', '"+ nome +"', '"+ nomepai +"', '"+ nomemae +"', '"+ endereco +"', '"+ sexo +"' )";
        try{
            comando = con.createStatement();
            comando.executeUpdate(sql);
            System.out.println("Valores Inseridos");
        } catch (SQLException ex) {
            System.out.println("Não foi possivel inserir no grupode produto - "+ex.getMessage());
        } finally {
            try{
                comando.close();
                con.close();
            }catch(SQLException ex) {
                System.out.println("Não foi possivel desconectar - "+ex.getMessage());
            }
        }
        
    }
    
}
