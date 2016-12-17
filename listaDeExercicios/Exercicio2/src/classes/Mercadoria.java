
package classes;

import javax.swing.JOptionPane;

  
public class Mercadoria {
   
    private String nomeProduto;
    private float precoCompra;
    private float precoVenda;
    private int quantidadeComprada;
    private int quantidadeVendida;

    public String getNomeProduto() {
        return nomeProduto;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setNomeProduto(String nomeProduto) {
        boolean sai; 
        do{
            sai = false;
           if(nomeProduto !=null && nomeProduto != " ") this.nomeProduto = nomeProduto;
           else{
                JOptionPane.showMessageDialog(null, "Digitar o nome do produto");
                nomeProduto = JOptionPane.showInputDialog("Digite novamente");
                sai = true;
           }
        }while(sai);
      
    }

    public void setPrecoCompra(float precoCompra) {
        
        boolean sai; 
        do{
            sai = false;
           if(precoCompra >=0) this.precoCompra = precoCompra;
           else{
                JOptionPane.showMessageDialog(null, "Numero de compras esta errado");
                precoCompra =  Float.parseFloat(JOptionPane.showInputDialog("Digite novamente o numero das compras"));
                sai = true;
           }
        }while(sai);
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
        boolean sai; 
        do{
            sai = false;
           if(precoVenda >=0) this.precoVenda = precoVenda;
           else{
                JOptionPane.showMessageDialog(null, "Numero do preço da venda esta errado");
                precoVenda=  Float.parseFloat(JOptionPane.showInputDialog("Digite novamente o numero do preço das vendas"));
                sai = true;
           }
        }while(sai);
    }

    public void setQuantidadeComprada(int quantidadeComprada) {
       
        boolean sai; 
        do{
            sai = false;
           if(quantidadeComprada >=0)  this.quantidadeComprada = quantidadeComprada;
           else{
                JOptionPane.showMessageDialog(null, "Numero da quantidade comprada esta errado");
                quantidadeComprada = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o numero da quantidade comprada"));
                sai = true;
           }
        }while(sai);
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        
         boolean sai; 
        do{
            sai = false;
           if(quantidadeVendida >=0)  this.quantidadeVendida = quantidadeVendida;
           else{
                JOptionPane.showMessageDialog(null, "Numero da quantidade vendida a esta errado");
                quantidadeVendida = Integer.parseInt(JOptionPane.showInputDialog("Digite novamente o numero da quantidade vendida"));
                sai = true;
           }
        }while(sai);
    }
    
    public float lucro(){
        return(this.precoVenda-this.precoCompra)*this.quantidadeVendida;
    }
}
