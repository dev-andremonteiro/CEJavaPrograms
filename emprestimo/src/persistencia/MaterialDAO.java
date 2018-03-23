package persistencia;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import vo.MaterialVO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class MaterialDAO extends DAO<MaterialVO>{
    
    public MaterialDAO(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<MaterialVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material a order by a.descricao");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Materiais "+ex.getMessage());
        }
    }
    
    public MaterialVO buscarPorId(int id){
        return this.entityManager.find(MaterialVO.class, id);
    }
    
    public List<MaterialVO> buscarMaterialPorNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material a where UPPER(a.descricao) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.descricao");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Materiais "+e.getMessage());
        }
    }
    
    public List<MaterialVO> buscarPorGrupo(int idGrupo) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material a where a.id_grupo ="+idGrupo+" order by a.descricao");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Materiais "+e.getMessage());
        }
    }
    
}
