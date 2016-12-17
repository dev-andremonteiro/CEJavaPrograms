// André Vinícius Borges de Gois Monteiro
// Engenharia da Computação IFMT 5º Semestre

package execução;

import conceito.Produto;

public class ExercicioProduto {
    public static void main(String[] args) {
        Produto pro1,pro2,pro3;
        pro1 = new Produto();
        pro1.setNome("yyyyyyyyyyyy");
        pro1.setPreco(100);
        pro1.setMargem(30);
        System.out.println("nome = "+pro1.getNome());
        System.out.println("preco de venda = "+pro1.calcularValorVenda());
        
        System.out.println("----------------------");
        pro2 = new Produto();
        pro2.setNome("xxxxxxxxxxx");
        pro2.setPreco(200);
        pro2.setMargem(20);
        System.out.println("nome = "+pro2.getNome());
        System.out.println("preco de venda = "+pro2.calcularValorVenda());
        
        System.out.println("----------------------");
        pro3 = new Produto();
        pro3.setNome("zzzzzzzzzzz");
        pro3.setPreco(-200);
        pro3.setMargem(120);
        System.out.println("nome = "+pro3.getNome());
        System.out.println("preco de venda = "+pro3.calcularValorVenda());
    }
}
