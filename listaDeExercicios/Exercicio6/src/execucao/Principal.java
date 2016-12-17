
package execucao;

import classes.*;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;


public class Principal {
    
    public static void main(String[] args) {
        
        int op;
        boolean finalizou = true, sai = true;
        Aluno aluno;
        Controle controle = new Controle();
        
        
           do{
              try{
                   
                  op = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar aluno \n2 - Imprimir \n3 - Sair"));
              
             
                  switch(op){
                      case 1:    
                          do{
                              int numMatricula,frequencia, aulas;
                               float nota1,nota2,nota3;
           
                             try{
                              aluno = new Aluno();
               
                              numMatricula = Integer.parseInt(JOptionPane.showInputDialog("Forneca o valor do numerado da matricula"));
                              aluno.setNumMatricula(numMatricula, controle);
                              
                              aulas = Integer.parseInt(JOptionPane.showInputDialog("Forneca o numero de aulas dadas"));
                              aluno.setAulas(aulas);
                              
                              frequencia = Integer.parseInt(JOptionPane.showInputDialog("Frequencia das aulas do aluno entre 0 - 100"));
                              aluno.setFrequencia(frequencia);
                
                              nota1 = Float.parseFloat(JOptionPane.showInputDialog("Forneca a primeira nota do aluno entre 0 - 10"));
                              aluno.setNota1(nota1);
                
                              nota2 = Float.parseFloat(JOptionPane.showInputDialog("Forneca a segunda nota do aluno entre 0 - 10"));
                              aluno.setNota2(nota2);
                
                              nota3 = Float.parseFloat(JOptionPane.showInputDialog("Forneca a terceira nota do aluno entre 0 - 10"));
                              aluno.setNota3(nota3);
                
                              controle.adicionar(aluno);
                
                              int vali = JOptionPane.showConfirmDialog(null, "Quer cadastra outro aluno??",
                              "ALUNO" ,JOptionPane.YES_NO_OPTION);
              
                              if(vali == 1)finalizou = false;
                              if(vali == -1) finalizou = false;
                
                              } catch (InputMismatchException IME){
                                  JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro do aluno");
                              }
                               catch(NumberFormatException nu){
                                  JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                                }   
                      
                        }while(finalizou);
                        break;
                    
                       case 2:
                           controle.ImprimirTodosOsDadosDosAlunos();
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

