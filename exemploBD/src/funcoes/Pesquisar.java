package funcoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pesquisar {
    private Connection con = null;
    
    
    public Pesquisar(int matricula,Connection con) throws SQLException{
        this.con = con;
        this.pesquisarMatricula(matricula,con);
    }

    public Pesquisar(String nome,Connection con) throws SQLException{
        this.con = con;
        this.pesquisarNome(nome,con);
    }
    
    private void pesquisarMatricula(int matricula,Connection con) throws SQLException {
        PreparedStatement comando = con.prepareStatement("SELECT * FROM aluno WHERE matricula = ?");
        comando.setInt(1, matricula);
        ResultSet result = comando.executeQuery();
        if(result.next()){
            System.out.println("Encontrado: "+ result.getString("maticula")+".\n"
                    + "\t Nome:"+result.getString("nome")
                    + "\t Nome Mãe:"+result.getString("nomemae")
                    + "\t Nome Pai:"+result.getString("nomepai")
                    + "\t Endereco:"+result.getString("endereco")
                    + "\t Sexo:"+result.getString("sexo"));
        }else{
            System.out.println("Nao Encontrado!");
        }
        comando.close();       
    }

    private void pesquisarNome(String nome,Connection con) throws SQLException {
        
        PreparedStatement comando = con.prepareStatement("SELECT * FROM aluno WHERE nome = ?");
        comando.setString(1, nome);
        ResultSet result = comando.executeQuery();
        if(result.next()){
            System.out.println("Encontrado: "+ result.getString("nome")+".\n"
                    + "\t Matricula:"+result.getString("matricula")
                    + "\t Nome Mãe:"+result.getString("nomemae")
                    + "\t Nome Pai:"+result.getString("nomepai")
                    + "\t Endereco:"+result.getString("endereco")
                    + "\t Sexo:"+result.getString("sexo"));
        }else{
            System.out.println("Nao Encontrado!");
        }
        comando.close(); 
        
    }
    
}
