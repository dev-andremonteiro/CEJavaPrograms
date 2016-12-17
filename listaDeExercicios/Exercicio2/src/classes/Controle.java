
package classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controle {
    
     ArrayList<Mercadoria> gerencia;
    
    public Controle(){
        gerencia = new ArrayList();
    }
    
    public void adicionar(Mercadoria mercadoria){
        gerencia.add(mercadoria);
   }
    
    public void mercadoriaMaisVendida(){
       Mercadoria aux = this.gerencia.get(0);
       
       for(Mercadoria temp : this.gerencia){
           if(temp.getQuantidadeVendida() > aux.getQuantidadeVendida())aux = temp;
       }
       JOptionPane.showMessageDialog(null,"mercadoira mais vendida é "+aux.getNomeProduto());
   }
   
    public void mercadoriaMenosVendida(){
       Mercadoria aux = this.gerencia.get(0);
       
       for(Mercadoria temp : this.gerencia){
           if(temp.getQuantidadeVendida() < aux.getQuantidadeVendida())aux = temp;
       }
       
       JOptionPane.showMessageDialog(null,"mercadoira menos vendida é "+aux.getNomeProduto());
    }
        
    public void mercadoriaMaisComprada(){
       Mercadoria aux = this.gerencia.get(0);
       
       for(Mercadoria temp : this.gerencia){
           if(temp.getQuantidadeComprada() > aux.getQuantidadeComprada())aux = temp;
       }
       
       JOptionPane.showMessageDialog(null,"mercadoira mais comprada  é "+aux.getNomeProduto());
   }
     
    public void mercadoriaMenosComprada(){
       Mercadoria aux = this.gerencia.get(0);
       
       for(Mercadoria temp : this.gerencia){
           if(temp.getQuantidadeComprada() < aux.getQuantidadeComprada())aux = temp;
       }
       JOptionPane.showMessageDialog(null,"mercadoira menos comprada  é "+aux.getNomeProduto());
        
   }
    
    public void valorTotalDaCompra(){
             float aux = 0;
       
           for(Mercadoria temp : this.gerencia){
            aux = aux + temp.getPrecoCompra();
       }
       JOptionPane.showMessageDialog(null,"A compra total é de  "+aux);
    }
    
    public void valorTotalDaVenda(){
             float aux = 0;
       
       for(Mercadoria temp : this.gerencia){
          aux = aux + temp.getPrecoVenda();
       }
       JOptionPane.showMessageDialog(null,"O valor da venda total é de "+aux);
    }
    
    public void lucroTotal(){
       float aux = 0;
       
       for(Mercadoria temp : this.gerencia){
          aux = aux + temp.lucro();
       }
       JOptionPane.showMessageDialog(null,"O lucro total é de "+aux);
    }
   
}
