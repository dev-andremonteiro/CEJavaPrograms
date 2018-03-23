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
import vo.TipoBaixaVO;

/**
 *
 * @author Daniel
 */
public class TipoBaixaDAO extends DAO<TipoBaixaVO>{
    
    public TipoBaixaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<TipoBaixaVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from tipo_baixa a order by a.descricao");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Tipos de Baixa "+ex.getMessage());
        }
    }
    
    public TipoBaixaVO buscarPorId(int id){
        return this.entityManager.find(TipoBaixaVO.class, id);
    }
    
    public List<TipoBaixaVO> buscarTipoBaixaPorDescricao(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from tipo_baixa a where UPPER(a.descricao) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.descricao");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Tipos de Baixa"+e.getMessage());
        }
    }
}
