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
import vo.MaterialTipoAtividadePKVO;
import vo.MaterialTipoAtividadeVO;

/**
 *
 * @author Daniel
 */
public class MaterialTipoAtividade extends DAO<MaterialTipoAtividadeVO>{
    
    public MaterialTipoAtividade(EntityManager entityManager) {
        super(entityManager);
    }
    
    public List<MaterialTipoAtividadeVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_tipo_atividade a order by a.id_tipo");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de materiais emprestados "+ex.getMessage());
        }
    }
    
    public MaterialTipoAtividadeVO buscarPorId(MaterialTipoAtividadePKVO id){
        return this.entityManager.find(MaterialTipoAtividadeVO.class, id);
    }
    
    public List<MaterialTipoAtividadeVO> buscarPorIdMaterial(int id) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_tipo_atividade a where a.id_material="+id);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de tipos que um material está associado "+e.getMessage());
        }
    }
    
    public List<MaterialTipoAtividadeVO> buscarPorIdTipoAtividade(int id) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_tipo_atividade a where a.id_tipo="+id);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de materiais associados a um tipo de atividade "+e.getMessage());
        }
    }
}