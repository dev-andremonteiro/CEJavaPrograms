
package funcoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletar {
    Connection con = null;

    public Deletar(int matricula,Connection con) throws SQLException{
        this.con = con;
        this.deletarAluno(matricula);
    }
    
    public void deletarAluno(int matricula) throws SQLException{
        PreparedStatement comando = this.con.prepareStatement("SELECT * FROM aluno WHERE matricula = ?");
        comando.setInt(1, matricula);
        int aux = comando.executeUpdate();
        System.out.println("["+aux+"]Exclusão(ões) realizada(s) com sucesso!");
        comando.close();
    }
    
}
