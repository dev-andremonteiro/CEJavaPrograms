
package execucao;

import classes.*;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
       int op;
       boolean finalizou = true, sai = true;
       Mercadoria produto;
       Controle controle = new Controle();
       
       do{
          try{
            op = Integer.parseInt(JOptionPane.showInputDialog("1 - Adicionar Mercadoria \n2 - valor total de Compra\n3 - Valor total de venda\n4 - Lucro total"+
                    "\n5 - Mercadoria mais comprada\n6 - Mercadoria menos comprada\n7 - Mercadoria mais vendida\n8 - Mercadoria menos vendida\n9 - SAIR"));
               
            switch(op){
                case 1:
                   do{
                       String nomeProduto;
                      float precoCompra,  precoVenda;
                      int quantidadeComprada, quantidadeVendida;
                
                        try{
                            produto = new Mercadoria();
                            
                            nomeProduto = JOptionPane.showInputDialog("Forneça o nome do produto");
                            produto.setNomeProduto(nomeProduto);
                              
                            quantidadeComprada= Integer.parseInt(JOptionPane.showInputDialog("Forneça a quantidade comprada"));
                            produto.setQuantidadeComprada(quantidadeComprada);
                                                          
                            quantidadeVendida = Integer.parseInt(JOptionPane.showInputDialog("Forneça a quantidade vendida"));
                            produto.setQuantidadeVendida(quantidadeVendida);
                
                            precoCompra = Float.parseFloat(JOptionPane.showInputDialog("Forneça o preço da compra"));
                            produto.setPrecoCompra(precoCompra);
                
                            precoVenda = Float.parseFloat(JOptionPane.showInputDialog("Forneça o preço da venda"));
                            produto.setPrecoVenda(precoVenda);
                                            
                           controle.adicionar(produto);
                           
                           int vali = JOptionPane.showConfirmDialog(null, "Quer cadastra outro produto??",
                              "ALUNO" ,JOptionPane.YES_NO_OPTION);
              
                              if(vali == 1)finalizou = false;
                              if(vali == -1) finalizou = false;
                          
                        }catch (InputMismatchException IME){
                           JOptionPane.showMessageDialog(null, "Valor inconsistente. Por favor refaça o cadastro do produto");
                        }catch(NumberFormatException nu){
                          JOptionPane.showMessageDialog(null, "Por favor insira um valor valido");
                        }   
                
                   }while(finalizou);
                   break;
                   
                case 2:
                     
                    break;
                
                case 3:
                    
                    break;
                case 4:
                    controle.lucroTotal();    
                    break;
                case 5:
                    controle.mercadoriaMaisComprada();
                    break;
                case 6:
                    controle.mercadoriaMenosComprada();
                    break;
                case 7:
                    controle.mercadoriaMaisVendida();
                    break;
                case 8:
                    controle.mercadoriaMenosVendida();
                    break;
                                                
                case 9:
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
