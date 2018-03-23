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
import vo.AtividadeVO;

/**
 *
 * @author Daniel
 */
public class AtividadeDAO extends DAO<AtividadeVO>{
    
    public AtividadeDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<AtividadeVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from atividade a order by a.nome");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Atividades "+ex.getMessage());
        }
    }
    
    public AtividadeVO buscarPorId(int id){
        return this.entityManager.find(AtividadeVO.class, id);
    }
    
    public List<AtividadeVO> buscarAtividadePorNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from atividade a where UPPER(a.nome) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Atividades "+e.getMessage());
        }
    }
    
    public List<AtividadeVO> buscarPorGrupo(int idGrupo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from atividade a where a.id_grupo ="+idGrupo+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Atividades "+e.getMessage());
        }
    }
    
    public List<AtividadeVO> buscarPorTipo(int idTipo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from atividade a where a.id_tipo ="+idTipo+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Atividades "+e.getMessage());
        }
    }
}
