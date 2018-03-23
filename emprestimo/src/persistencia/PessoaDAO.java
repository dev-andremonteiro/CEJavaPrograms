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
import vo.PessoaVO;

/**
 *
 * @author Daniel
 */
public class PessoaDAO extends DAO<PessoaVO>{
    
    public PessoaDAO(EntityManager entityManager) {
        super(entityManager);
    }
    public List<PessoaVO> buscarTodos() throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from pessoa a order by a.nome");
            return query.getResultList();
        } catch (PersistenceException ex) {
            throw new PersistenciaException("Não foi possível obter a lista de Pessoas "+ex.getMessage());
        }
    }
    
    public PessoaVO buscarPorId(int id){
        return this.entityManager.find(PessoaVO.class, id);
    }
    
    public List<PessoaVO> buscarPessoaPorNome(String nome) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from pessoa a where UPPER(a.nome) like '%"
                    +nome.trim().toUpperCase()+ "%' order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Pessoas "+e.getMessage());
        }
    }
    
    public List<PessoaVO> buscarPorPatrulha(int idPatrulha) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from pessoa a where a.id_patrulha ="+idPatrulha+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Pessoas "+e.getMessage());
        }
    }
    
    public List<PessoaVO> buscarPorFuncao(int idFuncao) throws PersistenciaException{
        try {
            Query query = this.entityManager.createQuery("select a from pessoa a where a.id_funcao ="+idFuncao+" order by a.nome");
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Não foi possível obter a lista de Pessoas "+e.getMessage());
        }
    }
}
