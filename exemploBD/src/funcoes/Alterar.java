package funcoes;

import entrada.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Alterar {

    Connection con = null;
    
    public Alterar(int matricula,Connection con) throws SQLException {
        this.con = con;
        alterarAluno(matricula);
    }

    private void alterarAluno(int matricula) throws SQLException {
        Menu menu = new Menu();
        
        String nome = menu.getEntrada("Nome: ");
        String nomepai = menu.getEntrada("Nome Pai:");
        String nomemae = menu.getEntrada("Nome mae:");
        String endereco = menu.getEntrada("Endereco Completo:");
        String sexo = menu.getEntrada("Sexo:");
        
        PreparedStatement comando = con.prepareStatement("UPDATE ALUNO SET NOME=?, NOMEPAI=?, NOMEMAE=?, ENDERECO=?, SEXO=? WHERE MATRICULA= ?");
        comando.setString(1,nome);
        comando.setString(2,nomepai);
        comando.setString(3,nomemae);
        comando.setString(4,endereco);
        comando.setString(5,sexo);
        comando.setInt(6,matricula);
        
        int aux = comando.executeUpdate();

        System.out.println("["+aux+"] Registros alterados com sucesso!");
        comando.close();
    }
    
    
    
}
