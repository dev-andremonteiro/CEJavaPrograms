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
import vo.EmprestimoVO;

/**
 *
 * @author Daniel
 */
public class EmprestimoDAO extends DAO<EmprestimoVO>{
    
    public EmprestimoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public List<EmprestimoVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from emprestimo a");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Emprestimos "+ex.getMessage());
        }
    }
    
    public EmprestimoVO buscarPorId(int id){
        return this.entityManager.find(EmprestimoVO.class, id);
    }
    
    public List<EmprestimoVO> buscarPorMembro(int idMembro) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from emprestimo a where a.id_membro ="+idMembro);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Emprestimos "+e.getMessage());
        }
    }
    
    public List<EmprestimoVO> buscarPorEmprestimo(int idAtividade) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from emprestimo a where a. ="+idAtividade);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Emprestimos "+e.getMessage());
        }
    }
}
