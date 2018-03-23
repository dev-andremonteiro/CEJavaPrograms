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
import vo.FuncaoVO;

/**
 *
 * @author Daniel
 */
public class FuncaoDAO extends DAO<FuncaoVO>{
    
    public FuncaoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<FuncaoVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from funcao a order by a.descricao");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Funções "+ex.getMessage());
        }
    }
    
    public FuncaoVO buscarPorId(int id){
        return this.entityManager.find(FuncaoVO.class, id);
    }
    
    public List<FuncaoVO> buscarFuncaoPorDescricao(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from funcao a where UPPER(a.descricao) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.descricao");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Funções "+e.getMessage());
        }
    }
}
