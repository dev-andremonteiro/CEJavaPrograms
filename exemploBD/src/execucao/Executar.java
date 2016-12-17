package execucao;

import funcoes.Inserir;
import entrada.Menu;
import funcoes.Alterar;
import funcoes.Deletar;
import funcoes.Pesquisar;
import java.sql.Connection;
import java.sql.SQLException;


public class Executar {
    
    public static void main(String[] args) {
        Connection con = null;
        Menu menu = new Menu();
        int entrada = menu.exibirMenu(false);
        int aux;
        
        try{
            FabricaConexao fbc = new FabricaConexao("banco.properties");
            con = fbc.Conectar();
            switch(entrada){
            case 0:
                Inserir ins = new Inserir(con);
                break;
            case 1:
                aux = Integer.parseInt(menu.getEntrada("Digite o numero de matricula: "));
                Alterar alt = new Alterar(aux,con);
                break;
            case 2:
                aux = Integer.parseInt(menu.getEntrada("Digite o numero de matricula: "));
                Deletar del = new Deletar(aux,con);
                break;
            case 3:
                int entrada2 = menu.exibirMenu(true);
                if(entrada2 == 1){
                    aux = Integer.parseInt(menu.getEntrada("Digite o numero de matricula: "));
                    Pesquisar pes = new Pesquisar(aux,con);
                }else if(entrada2 == 2){
                    String aux2 = menu.getEntrada("Digite o nome do aluno: ");
                    Pesquisar pes = new Pesquisar(aux2,con);
                }
                break;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Não foi possivel inserir no grupode produto - "+ex.getMessage());
        } finally {
            try{
                con.close();
            }catch(SQLException ex) {
                System.out.println("Não foi possivel desconectar - "+ex.getMessage());
            }
        }
        
        
       
        
        
    }
    
}
