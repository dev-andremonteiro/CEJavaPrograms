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
import vo.PatrulhaVO;

/**
 *
 * @author Daniel
 */
public class PatrulhaDAO extends DAO<PatrulhaVO>{
    
    public PatrulhaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<PatrulhaVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from patrulha a order by a.nome");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Patrulhas "+ex.getMessage());
        }
    }
    
    public PatrulhaVO buscarPorId(int id){
        return this.entityManager.find(PatrulhaVO.class, id);
    }
    
    public List<PatrulhaVO> buscarPatrulhaPorNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from ramo a where UPPER(a.nome) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Patrulhas "+e.getMessage());
        }
    }
    
    public List<PatrulhaVO> buscarPorRamo(int idRamo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from patrulha a where a.id_ramo ="+idRamo+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Patrulhas "+e.getMessage());
        }
    }
}
