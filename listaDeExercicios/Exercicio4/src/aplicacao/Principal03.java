
package aplicacao;

import negocio.*;
import classes.Sexo;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;


public class Principal03 {
    public static void main(String[] args) {
        int op;
         boolean finalizou = false, sai = true;
        Crianca crianca;
        Gerencia gerencia = new Gerencia();
        do{
            try{
                
                op = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar criança \n2 - Imprimir \n3 - Sair"));
                
                switch(op){
                      case 1: 
                          int ano;
                          float peso;
                          Sexo sexo;
                          
                          do{
                              crianca = new Crianca();
                              try{
                                  ano = Integer.parseInt(JOptionPane.showInputDialog("Forneca o ano que a criança nasceu"));
                                  crianca.setAno(ano);
                                  
                                  peso= Float.parseFloat(JOptionPane.showInputDialog("Forneca o peso da criança"));
                                  crianca.setPeso(peso);
                                  
                                  sexo = (Sexo)JOptionPane.showInputDialog(null,"Escolha um item", "Opçao",JOptionPane.INFORMATION_MESSAGE, null,Sexo.values(),Sexo.values()[0]);
                                  crianca.setSexo(sexo);
                                  
                                  gerencia.AdicionarCrianca(crianca);
                                  
                                  int vali = JOptionPane.showConfirmDialog(null, "Quer cadastra outra criança??",
                                              "Criança" ,JOptionPane.YES_NO_OPTION);
              
                                   if(vali == 1)finalizou = true;
                                   if(vali == -1) finalizou = true; 
                                   
                              }catch (InputMismatchException IME){
                                  JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro da criança");
                              }
                          }while(!finalizou);
                          break;
                           
                       case 2:
                           ano = Integer.parseInt(JOptionPane.showInputDialog("O periodo a ser impresso"));
                           gerencia.imprimi(ano);
                        break;
                          
                        case 3:
                            sai = false;
                        break;
                              
                        default:
                        JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                        break;
                      }
                
                }catch(NumberFormatException nu){
                  JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                  
                 }
            
        }while(sai);
        
        
        
    }
}
