package negocio;

import java.util.ArrayList;
public class Pesquisa {
    private ArrayList<Pessoa> lista;

    public Pesquisa() {
        this.lista = new ArrayList<Pessoa>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        this.lista.add(pessoa);
    }
    
    public ArrayList<Pessoa> obterListaPessoa(){
        return this.lista;
    }

    public int obterNumeroTotalPessoa(){
        return this.lista.size();
    }
    
    public int obterMaiorIdade(ArrayList<Pessoa> listaTemp) {
        int maior = 0;
        for (Pessoa pessoaTemp1 : listaTemp) {
            if (pessoaTemp1.getIdade() > maior) {
                maior = pessoaTemp1.getIdade();
            }
        }
        return maior;
    }

    public int obterSomaIdade(ArrayList<Pessoa> listaTemp) {
        int soma = 0;
        for (Pessoa pessoaTemp1 : listaTemp) {
            soma = soma + pessoaTemp1.getIdade();
        }
        return soma;
    }

    public float obterMediaIdade(ArrayList<Pessoa> listaTemp) {
        return this.obterSomaIdade(listaTemp) / listaTemp.size();
    }

    public ArrayList<Pessoa> obterPessoaPorSexo(Sexo sexo, ArrayList<Pessoa> listaTemp) {
        ArrayList<Pessoa> resposta = new ArrayList<Pessoa>();
        for (Pessoa pessoaTemp1 : listaTemp) {
            if(pessoaTemp1.getSexo() == sexo){
                resposta.add(pessoaTemp1);
            }
        }
        return resposta;
    }

    public int obterNumeroPessoaPorSexo(Sexo sexo, ArrayList<Pessoa> listaTemp) {
        return this.obterPessoaPorSexo(sexo, listaTemp).size();
    }

    public ArrayList<Pessoa> obterPessoaPorCorOlho(CorOlho corOlho, ArrayList<Pessoa> listaTemp) {
        ArrayList<Pessoa> resposta = new ArrayList<Pessoa>();
        for (Pessoa pessoaTemp1 : listaTemp) {
            if(pessoaTemp1.getCorOlhos() == corOlho){
                resposta.add(pessoaTemp1);
            }
        }
        return resposta;
    }

    public int obterNumeroPessoaPorCorOlho(CorOlho corOlho, ArrayList<Pessoa> listaTemp) {
        return this.obterPessoaPorCorOlho(corOlho, listaTemp).size();
    }

    public ArrayList<Pessoa> obterPessoaPorCorCabelo(CorCabelo corCabelo, ArrayList<Pessoa> listaTemp) {
        ArrayList<Pessoa> resposta = new ArrayList<Pessoa>();
        for (Pessoa pessoaTemp1 : listaTemp) {
            if(pessoaTemp1.getCorCabelo() == corCabelo){
                resposta.add(pessoaTemp1);
            }
        }
        return resposta;
    }

    public int obterNumeroPessoaPorCorCabelo(CorCabelo corCabelo, ArrayList<Pessoa> listaTemp) {
        return this.obterPessoaPorCorCabelo(corCabelo, listaTemp).size();
    }

    public ArrayList<Pessoa> obterPessoaPorFaixaIdade(int idadeInicial, int idadeFinal, ArrayList<Pessoa> listaTemp) {
        ArrayList<Pessoa> resposta = new ArrayList<Pessoa>();
        for (Pessoa pessoaTemp1 : listaTemp) {
            if(pessoaTemp1.getIdade() >= idadeInicial && pessoaTemp1.getIdade() <= idadeFinal){
                resposta.add(pessoaTemp1);
            }
        }
        return resposta;
    }

    public int obterNumeroPessoaPorFaixaIdade(int idadeInicial, int idadeFinal, ArrayList<Pessoa> listaTemp) {
        return this.obterPessoaPorFaixaIdade(idadeInicial, idadeFinal, listaTemp).size();
    }
    
}


