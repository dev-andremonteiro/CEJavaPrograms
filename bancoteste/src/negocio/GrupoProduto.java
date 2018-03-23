package negocio;

import DAO.GrupoProdutoDAO;
import persistencia.FabricaEntityManager;
import persistencia.PersistenciaException;
import vo.GrupoProdutoVO;

public class GrupoProduto {

    GrupoProdutoDAO grupoDAO;

    public GrupoProduto() throws NegocioException {
        try {
            grupoDAO = new GrupoProdutoDAO(FabricaEntityManager.getEntityManager());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar persistência" + ex.getMessage());
        }
    }

    public void inserir(GrupoProdutoVO grupoVO) throws NegocioException {

        String mensagemErros = this.validarDados(grupoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            grupoDAO.iniciarTransacao();
            grupoDAO.incluir(grupoVO);
            grupoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao incluir Grupo de Produto -" + ex.getMessage());
        }

    }

    public void alterar(GrupoProdutoVO grupoVO) throws NegocioException {

        String mensagemErros = this.validarDados(grupoVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            grupoDAO.iniciarTransacao();
            grupoDAO.alterar(grupoVO);
            grupoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao alterar Grupo de Produto -" + ex.getMessage());
        }

    }
    
    public void exlcuir(GrupoProdutoVO grupoVO) throws NegocioException {

        try {
            grupoDAO.iniciarTransacao();
            grupoDAO.excluir(grupoVO);
            grupoDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao excluir Grupo de Produto -" + ex.getMessage());
        }

    }
    
    private String validarDados(GrupoProdutoVO grupoVO) {
        String mensagemErros = "";

        if (grupoVO.getNome().length() == 0) {
            mensagemErros += "\nNome não pode ser vazio.";
        }

        if (grupoVO.getMargemlucro() < 0) {
            mensagemErros += "\n Margem deve ser maior que zero.";
        }

        if (grupoVO.getPromocao() < 0 || grupoVO.getPromocao() > 100) {
            mensagemErros += "\nO Percentual de Promoção deve ser entre 0 e 100.";
        }
        return mensagemErros;
    }

}
