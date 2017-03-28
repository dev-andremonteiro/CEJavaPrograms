package aplicacao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.CorCabelo;
import negocio.CorOlho;
import negocio.Pesquisa;
import negocio.Pessoa;
import negocio.Sexo;

public class Principal2 {

    public static void main(String[] args) {

        Pesquisa pesquisa = new Pesquisa();
        Pessoa pessoa;

        int totalPessoas, contador1;
        ArrayList<Pessoa> listaTemp;
        int resp = 0;
        int idade;
        CorOlho corOlho;
        CorCabelo corCabelo;
        Sexo sexo;

        do {
            sexo = (Sexo)JOptionPane.showInputDialog(null, "Escolha o Sexo", "Escolha", 
                    JOptionPane.QUESTION_MESSAGE, null, Sexo.values(), Sexo.values()[0]);
            corOlho = (CorOlho)JOptionPane.showInputDialog(null, "Escolha a cor dos olhos", "Escolha", 
                    JOptionPane.QUESTION_MESSAGE, null, CorOlho.values(), CorOlho.values()[0]);
            corCabelo = (CorCabelo)JOptionPane.showInputDialog(null, "Escolha a cor dos cabelos", "Escolha", 
                    JOptionPane.QUESTION_MESSAGE, null, CorCabelo.values(), CorCabelo.values()[0]);
            idade = Integer.parseInt(JOptionPane.showInputDialog("Forneça a Idade - em anos"));

            pessoa = new Pessoa();
            pessoa.setSexo(sexo);
            pessoa.setCorOlhos(corOlho);
            pessoa.setCorCabelo(corCabelo);
            pessoa.setIdade(idade);

            pesquisa.adicionarPessoa(pessoa);

            resp = JOptionPane.showConfirmDialog(null, "Deseja fornecer dados de outra pessoa", "Responda", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (resp == JOptionPane.YES_OPTION);

        totalPessoas = pesquisa.obterNumeroTotalPessoa();
        System.out.println("Total de Pessoas: "+totalPessoas);
        System.out.println("Maior Idade: "+pesquisa.obterMaiorIdade(pesquisa.obterListaPessoa()));
        System.out.println("Média de Idade: "+pesquisa.obterMediaIdade(pesquisa.obterListaPessoa()));
        contador1 = pesquisa.obterNumeroPessoaPorFaixaIdade(20, 35, pesquisa.obterListaPessoa());
        System.out.println("Idade entre 20 e 35: "+contador1+" - "+(contador1 * 100 / totalPessoas)+"%");
        
        listaTemp = pesquisa.obterPessoaPorFaixaIdade(18, 35, pesquisa.obterListaPessoa());
        listaTemp = pesquisa.obterPessoaPorSexo(Sexo.FEMININO, listaTemp);
        listaTemp = pesquisa.obterPessoaPorCorOlho(CorOlho.VERDE, listaTemp);
        contador1 = pesquisa.obterNumeroPessoaPorCorCabelo(CorCabelo.LOIRO, listaTemp);
        System.out.println("Feminino, Idade entre 18 e 35 Olhos Verdes e Cabelos Loiros: "+contador1+
                " - "+(contador1 * 100 / totalPessoas)+"%");
    }
}
