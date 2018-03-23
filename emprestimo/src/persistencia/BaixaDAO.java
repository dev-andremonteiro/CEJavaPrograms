/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import vo.BaixaVO;

/**
 *
 * @author Daniel
 */
public class BaixaDAO extends DAO<BaixaVO>{
    
    public BaixaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public List<BaixaVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from baixa a");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Baixas "+ex.getMessage());
        }
    }
    
    public BaixaVO buscarPorId(int id){
        return this.entityManager.find(BaixaVO.class, id);
    }
    
    public List<BaixaVO> buscarPorTipoBaixa(int idTipoBaixa) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from baixa a where a.id_tipo_baixa ="+idTipoBaixa);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Baixas "+e.getMessage());
        }
    }
    
    public List<BaixaVO> buscarPorEmprestimo(int idEmprestimo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from baixa a where a.id_emprestimo ="+idEmprestimo);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Baixas "+e.getMessage());
        }
    }
}
