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
import vo.RamoVO;

/**
 *
 * @author Daniel
 */
public class RamoDAO extends DAO<RamoVO>{
    
    public RamoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<RamoVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from ramo a order by a.nome");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Ramos "+ex.getMessage());
        }
    }
    
    public RamoVO buscarPorId(int id){
        return this.entityManager.find(RamoVO.class, id);
    }
    
    public List<RamoVO> buscarRamoPorNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from ramo a where UPPER(a.nome) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Ramos "+e.getMessage());
        }
    }
    
    public List<RamoVO> buscarPorGrupo(int idGrupo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from ramo a where a.id_grupo ="+idGrupo+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Ramos "+e.getMessage());
        }
    }
}
