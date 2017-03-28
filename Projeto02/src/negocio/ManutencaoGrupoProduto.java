package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import persistencia.ConexaoBD;
import persistencia.PersistenciaException;

public class ManutencaoGrupoProduto {

    public void inserir(String nome, float margem, float promocao) throws NegocioException {

        String mensagemErros = this.validarDados(nome, margem, promocao);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement(
                    "INSERT INTO GRUPOPRODUTO ( NOME, MARGEMLUCRO, PROMOCAO ) VALUES (?, ?, ?)");
            comando.setString(1, nome);
            comando.setFloat(2, margem);
            comando.setFloat(3, promocao);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao incluir novo grupo de produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    public void alterar(int codigo, String nome, float margem, float promocao) throws NegocioException {

        String mensagemErros = this.validarDados(nome, margem, promocao);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement("UPDATE GRUPOPRODUTO SET NOME=?, MARGEMLUCRO=?, PROMOCAO=? WHERE CODIGO=?");
            comando.setString(1, nome);
            comando.setFloat(2, margem);
            comando.setFloat(3, promocao);
            comando.setInt(4, codigo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao alterar o grupo de produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    public void excluir(int codigo) throws NegocioException {

        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comando = conexaoBD.getConexao().prepareStatement("DELETE FROM GRUPOPRODUTO WHERE CODIGO=?");
            comando.setInt(1, codigo);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException ex) {
            throw new NegocioException("Erro ao excluuir o grupo de produto" + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao conectar no banco de dados" + ex.toString());
        }
    }

    private String validarDados(String nome, float margem, float promocao) {

        String mensagemErros = "";

        if (nome.length() == 0) {
            mensagemErros += "Nome não pode ser vazio";
        }

        if (margem < 0) {
            mensagemErros += "\nA margem de Lucro não pode ser negativa";
        }

        if (promocao < 0 || promocao > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100";
        }
        return mensagemErros;
    }

    public ResultSet porFiltroNome(String filtro) throws NegocioException {
        ResultSet rs = null;
        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            Statement comando = conexaoBD.getConexao().createStatement();
            String sql = "SELECT * "+
                         " FROM GRUPOPRODUTO"+
                         " WHERE UPPER(NOME) LIKE '%" + filtro + "%'"+
                         " ORDER BY NOME LIMIT 10";
            rs = comando.executeQuery(sql);
        } catch (SQLException ex) {
            throw new NegocioException("Não foi possível recuperar lista de grupos de  produtos - " + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao obter conexão com o banco de dados - " + ex.toString());
        }
        return rs;
    }

    public ResultSet porCodigo(int codigo) throws NegocioException {
        ResultSet rs = null;
        try {
            ConexaoBD conexaoBD = ConexaoBD.getInstancia();
            PreparedStatement comandoGrupoProduto = conexaoBD.getConexao().prepareStatement("SELECT * FROM GRUPOPRODUTO WHERE CODIGO = ? ORDER BY NOME");
            comandoGrupoProduto.setInt(1,codigo);
            rs = comandoGrupoProduto.executeQuery();
        } catch (SQLException ex) {
            throw new NegocioException("Não foi possível recuperar o grupo de  produto - " + ex.toString());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao obter conexão com o banco de dados - " + ex.toString());
        }
        return rs;
    }

}
