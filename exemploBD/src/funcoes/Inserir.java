package funcoes;

import entrada.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserir {
    
    Connection con = null;
    PreparedStatement comando = null;
    
    public Inserir(Connection con) throws SQLException{
        this.con = con;
        inserirAluno();
    }
    
    public void inserirAluno() throws SQLException{
        
        Menu menu = new Menu();
        
        int matricula = Integer.parseInt(menu.getEntrada("Matricula: "));
        String nome = menu.getEntrada("Nome: ");
        String nomepai = menu.getEntrada("Nome Pai:");
        String nomemae = menu.getEntrada("Nome mae:");
        String endereco = menu.getEntrada("Endereco Completo:");
        String sexo = menu.getEntrada("Sexo:");
      
        comando = con.prepareStatement("INSERT INTO ALUNO ( MATRICULA, NOME, NOMEPAI, NOMEMAE, ENDERECO, SEXO ) VALUES (?, ?, ?, ?, ?, ?)");
        comando.setInt(1,matricula);
        comando.setString(2,nome);
        comando.setString(3,nomepai);
        comando.setString(4,nomemae);
        comando.setString(5,endereco);
        comando.setString(6,sexo);
        comando.executeUpdate();

        System.out.println("Valores Inseridos");
        comando.close();
        
        
    }
    
}
