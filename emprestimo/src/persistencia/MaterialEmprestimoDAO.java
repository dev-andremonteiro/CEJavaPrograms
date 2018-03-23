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
import vo.MaterialEmprestimoPKVO;
import vo.MaterialEmprestimoVO;

/**
 *
 * @author Daniel
 */
public class MaterialEmprestimoDAO extends DAO<MaterialEmprestimoVO>{
    
    public MaterialEmprestimoDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public List<MaterialEmprestimoVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_emprestimo a order by a.id_emprestimo");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de materiais emprestados "+ex.getMessage());
        }
    }
    
    public MaterialEmprestimoVO buscarPorId(MaterialEmprestimoPKVO id){
        return this.entityManager.find(MaterialEmprestimoVO.class, id);
    }
    
    public List<MaterialEmprestimoVO> buscarPorIdMaterial(int id) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_emprestimo a where a.id_material="+id);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de emprestimos que um material está associado "+e.getMessage());
        }
    }
    
    public List<MaterialEmprestimoVO> buscarPorIdEmprestimo(int id) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from material_emprestimo a where a.id_emprestimo="+id);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de materiais associados a um emprestimo "+e.getMessage());
        }
    }
    
}
