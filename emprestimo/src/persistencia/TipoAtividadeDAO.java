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
import vo.TipoAtividadeVO;

/**
 *
 * @author Daniel
 */
public class TipoAtividadeDAO extends DAO<TipoAtividadeVO>{

    public TipoAtividadeDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<TipoAtividadeVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from tipo_Atividade a order by a.nome_tipo");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Tipos de Atividade"+ex.getMessage());
        }
    }
    
    public TipoAtividadeVO buscarPorId(int id){
        return this.entityManager.find(TipoAtividadeVO.class, id);
    }
    
    public List<TipoAtividadeVO> buscarTipoAtividadePorNom(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from tipo_Atividade a where UPPER(a.nome_tipo) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome_tipo");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Tipos de Atividade"+e.getMessage());
        }
    }
    
}
