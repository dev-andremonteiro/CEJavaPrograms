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
import vo.EnumModalidade;
import vo.EnumUF;
import vo.GrupoVO;

/**
 *
 * @author Daniel
 */
public class GrupoDAO extends DAO<GrupoVO>{
    
    public GrupoDAO(EntityManager entityManager)throws PersistenciaException{
        super(entityManager);
    }
    public GrupoVO buscarPorId(int id){
        return this.entityManager.find(GrupoVO.class, id);
    }
    
    public List<GrupoVO> buscarGrupoNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from grupo a where UPPER(a.nome) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Grupos"+e.getMessage());
        }
    }
     public GrupoVO buscarGrupoCnpj(int cnpj) throws PersistenciaException{
       return this.entityManager.find(GrupoVO.class,cnpj);
    }
     
    public List<GrupoVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from grupo a order by a.nome");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Grupos"+ex.getMessage());
        }
    }
}
