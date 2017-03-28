package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.ConexaoBD;
import persistencia.PersistenciaException;

public class ManutencaoProduto {

    private ManutencaoGrupoProduto grupoProduto;

    public ManutencaoProduto(){
        this.grupoProduto = new ManutencaoGrupoProduto();
    }
    
    public void inserir(String nome, int estoque, float compra, float margem, float promocao, int grupo) throws NegocioException {

        String mensagemErros = this.validarDados(nome, estoque, compra, margem, promocao, grupo);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement(
                    "INSERT INTO PRODUTO ( NOME, ESTOQUE, VALORCOMPRA, MARGEMLUCRO, GRUPO )VALUES (? , ?, ?, ?, ?)");
            comando.setString(1, nome);
            comando.setInt(2, estoque);
            comando.setFloat(3, compra);
            comando.setFloat(4, margem);
            comando.setInt(5, grupo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao incluir novo produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    public void alterar(int codigo, String nome, float compra, float margem, float promocao, int grupo) throws NegocioException {

        String mensagemErros = this.validarDados(nome, 0, compra, margem, promocao, grupo);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement("UPDATE PRODUTO SET NOME=?, VALORCOMPRA=?, MARGEMLUCRO=?, PROMOCAO=?, GRUPO=? WHERE CODIGO=?");
            comando.setString(1, nome);
            comando.setFloat(2, compra);
            comando.setFloat(3, margem);
            comando.setFloat(4, promocao);
            comando.setFloat(5, grupo);
            comando.setInt(6, codigo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao alterar o produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    public void excluir(int codigo) throws NegocioException {

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement("DELETE FROM PRODUTO WHERE CODIGO=?");
            comando.setInt(1, codigo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao excluuir o produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    public void baixarEstoqueDefeito(int motivo, int codigo, int quantidade, java.sql.Date data) throws NegocioException {
        String mensagemErros = "";

        if (quantidade <= 0) {
            mensagemErros += "Quantidade fornecida deve ser maior que zero!!!";
        }

        try {
            ResultSet rs = this.porCodigo(codigo);

            if (rs.next()) {
                if (rs.getInt("estoque") < quantidade) {
                    mensagemErros += "Estoque insuficiente para baixa!!!";
                }
            } else {
                mensagemErros += "Produto não encontrado!!!";
            }
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao alterar o produto" + ex.toString());
        }

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        ConexaoBD conexaoBD = null;
        try {
            conexaoBD = ConexaoBD.getInstancia();
            conexaoBD.getConexao().setAutoCommit(false);
            PreparedStatement comando1 = conexaoBD.getConexao().prepareStatement("INSERT INTO REGISTROBAIXA ( MOTIVO, DATA, PRODUTO, QUANTIDADE )VALUES (? , ?, ?, ?)");
            comando1.setInt(1, motivo);
            comando1.setDate(2, data);
            comando1.setInt(3, codigo);
            comando1.setInt(4, quantidade);

            PreparedStatement comando2 = conexaoBD.getConexao().prepareStatement("UPDATE PRODUTO SET ESTOQUE=(ESTOQUE - ?) WHERE CODIGO=?");
            comando2.setInt(1, quantidade);
            comando2.setInt(2, codigo);

            comando1.executeUpdate();
            comando2.executeUpdate();
            conexaoBD.getConexao().commit();
            comando1.close();
            comando2.close();
        } catch (SQLException ex) {
            try {
                conexaoBD.getConexao().rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
            throw new NegocioException("Erro ao baixar estoque do produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao baixar estoque do produto" + ex.toString());
        }finally{
            try {
                conexaoBD.getConexao().setAutoCommit(true);
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
    }

    private String validarDados(String nome, int estoque, float compra, float margem, float promocao, int grupo) {

        String mensagemErros = "";

        if (nome.length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }

        if (estoque < 0) {
            mensagemErros += "\nEstoque não pode ser negativo";
        }

        if (compra <= 0) {
            mensagemErros += "\nPreço de compra deve ser maior que zero";
        }

        if (margem < 0) {
            mensagemErros += "\nA margem de Lucro não pode ser negativa";
        }

        if (promocao < 0 || promocao > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100";
        }

        try {
            if (this.grupoProduto.porCodigo(grupo) == null) {
                mensagemErros += "\nO grupo do produto é inválido";
            }
        } catch (NegocioException ex) {
            mensagemErros += "\nErro ao validar o grupo do produto";
        }

        return mensagemErros;
    }

    public ResultSet porFiltroNome(String filtro) throws NegocioException {
        ResultSet rs = null;
        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            Statement comando = conexaoBD.getConexao().createStatement();
            String sql = "SELECT p.*, g.promocao as promocao_g, g.margemlucro as margem_g"+
                         " FROM PRODUTO p INNER JOIN GRUPOPRODUTO g ON (p.GRUPO = g.CODIGO)"+
                         " WHERE UPPER(p.NOME) LIKE '%" + filtro + "%'"+
                         " ORDER BY p.NOME LIMIT 10";
            rs = comando.executeQuery(sql);
        } catch (SQLException ex) {
            throw new NegocioException("Não foi possível recuperar lista de produtos - " + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao obter conexão com o banco de dados - " + ex.toString());
        }
        return rs;
    }

    public ResultSet porCodigo(int codigo) throws NegocioException {
        ResultSet rs = null;
        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comandoProduto = conexaoBD.getConexao().prepareStatement("SELECT * FROM PRODUTO WHERE CODIGO = ? ORDER BY NOME");
            comandoProduto.setInt(1,codigo);
            rs = comandoProduto.executeQuery();
        } catch (SQLException ex) {
            throw new NegocioException("Não foi possível recuperar o produto - " + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao obter conexão com o banco de dados - " + ex.toString());
        }
        return rs;
    }

}
