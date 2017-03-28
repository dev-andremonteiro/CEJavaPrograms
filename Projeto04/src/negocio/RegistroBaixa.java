package negocio;

import java.util.Calendar;
import persistencia.ConexaoBD;
import persistencia.PersistenciaException;
import persistencia.ProdutoDAO;
import persistencia.RegistroBaixaDAO;
import vo.BaixaVO;

public class RegistroBaixa {

    private RegistroBaixaDAO registroBaixaDAO;
    private ProdutoDAO produtoDAO;

    public RegistroBaixa() throws NegocioException {
        try {
            this.registroBaixaDAO = new RegistroBaixaDAO(ConexaoBD.getInstancia());
            this.produtoDAO = new ProdutoDAO(ConexaoBD.getInstancia());
        } catch (PersistenciaException ex) {
            throw new NegocioException("Erro ao iniciar a Persistencia - " + ex.getMessage());
        }
    }

    public void baixarEstoque(BaixaVO baixaVO) throws NegocioException {

        String mensagemErros = this.validaRegistroBaixaVO(baixaVO);

        if (!mensagemErros.isEmpty()) {
            throw new NegocioException(mensagemErros);
        }

        try {
            this.registroBaixaDAO.iniciarTransacao();
            this.produtoDAO.baixarEstoque(baixaVO);
            this.registroBaixaDAO.registrarBaixaEstoque(baixaVO);
            this.registroBaixaDAO.confirmarTransacao();
        } catch (PersistenciaException ex) {
            this.registroBaixaDAO.cancelarTransacao();
            throw new NegocioException("Erro ao tentar baixar estoque - " + ex.getMessage());
        }
    }

    
    private String validaRegistroBaixaVO(BaixaVO baixaVO) {

        String mensagemErros = "";


        if (baixaVO.getMotivo() < 1 || baixaVO.getMotivo() > 2) {
            mensagemErros += "\nMotivo de baixa inválido";
        }

        if (baixaVO.getQuantidade() < 1) {
            mensagemErros += "\nQuantidade para a baixa de estoque deve ser maior que zero";
        }

        if (baixaVO.getData().getTime() > (Calendar.getInstance().getTimeInMillis())) {
            mensagemErros += "\nA data da operação deve se menor ou igual a data atual";
        }

        try {
            if (produtoDAO.buscarPorCodigo(baixaVO.getProduto()) == null) {
                mensagemErros += "\nProduto inválido inválido";
            }
        } catch (Exception ex) {
            mensagemErros += "\nNão foi possível consultar o produto para fazer a baixa";
        }

        return mensagemErros;
    }
}
