package aplicacao;

import java.util.ArrayList;
import negocio.CorCabelo;
import negocio.CorOlho;
import negocio.Pesquisa;
import negocio.Pessoa;
import negocio.Sexo;

public class Principal1 {
    
    public static void main(String args[]){

        Pessoa pessoa;
        Pesquisa pesquisa = new Pesquisa();
        int totalPessoas, contador1;
        ArrayList<Pessoa> listaTemp;

        pessoa = new Pessoa();
        pessoa.setSexo(Sexo.FEMININO);
        pessoa.setCorCabelo(CorCabelo.PRETO);
        pessoa.setIdade(10);
        pessoa.setCorOlhos(CorOlho.AZUL);
        pesquisa.adicionarPessoa(pessoa);
        //-----------------------------------------------------------------------
        pessoa = new Pessoa();
        pessoa.setSexo(Sexo.FEMININO);
        pessoa.setCorCabelo(CorCabelo.LOIRO);
        pessoa.setIdade(30);
        pessoa.setCorOlhos(CorOlho.VERDE);
        pesquisa.adicionarPessoa(pessoa);
        //-----------------------------------------------------------------------
        pessoa = new Pessoa();
        pessoa.setSexo(Sexo.FEMININO);
        pessoa.setCorCabelo(CorCabelo.LOIRO);
        pessoa.setIdade(19);
        pessoa.setCorOlhos(CorOlho.VERDE);
        pesquisa.adicionarPessoa(pessoa);
        //-----------------------------------------------------------------------
        pessoa = new Pessoa();
        pessoa.setSexo(Sexo.MASCULINO);
        pessoa.setCorCabelo(CorCabelo.LOIRO);
        pessoa.setIdade(50);
        pessoa.setCorOlhos(CorOlho.VERDE);
        pesquisa.adicionarPessoa(pessoa);

        System.out.println("Maior Idade: "+pesquisa.obterMaiorIdade(pesquisa.obterListaPessoa()));
        System.out.println("Média de Idade: "+pesquisa.obterMediaIdade(pesquisa.obterListaPessoa()));
        totalPessoas = pesquisa.obterNumeroTotalPessoa();
        contador1 = pesquisa.obterNumeroPessoaPorFaixaIdade(20, 35, pesquisa.obterListaPessoa());
        System.out.println("Idade entre 20 e 35: "+contador1+" - "+(contador1 * 100 / totalPessoas)+"%");
        
        listaTemp = pesquisa.obterPessoaPorFaixaIdade(18, 35, pesquisa.obterListaPessoa());
        listaTemp = pesquisa.obterPessoaPorSexo(Sexo.FEMININO, listaTemp);
        listaTemp = pesquisa.obterPessoaPorCorOlho(CorOlho.VERDE, listaTemp);
        contador1 = pesquisa.obterNumeroPessoaPorCorCabelo(CorCabelo.LOIRO, listaTemp);
        System.out.println("Feminino, Idade entre 18 e 35 Olhos Verdes e Cabelos Loiros: "+contador1+" - "+(contador1 * 100 / totalPessoas)+"%");
    }
}
