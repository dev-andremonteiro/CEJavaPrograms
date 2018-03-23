
package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import persistencia.PersistenciaException;
import vo.GrupoProdutoVO;
import vo.ProdutoVO;

public class ProdutoDAO extends DAO<ProdutoVO>{
    
    public ProdutoDAO(EntityManager ent) {
        super(ent);
    }
    
    public ProdutoVO buscarPorCodigo(int codigo) throws PersistenciaException{
        try{
            return this.ent.find(ProdutoVO.class,codigo);
        }catch(PersistenceException ex){
            throw new PersistenciaException("Não foi possivel obter a lista de Produtos");
        }
    }
    
    public List<ProdutoVO> buscarPorNome(String nome) throws PersistenciaException{
        try{
        Query q = ent.createQuery("SELECT G FROM ProdutoVO G WHERE UPPER(G.nome) LIKE '"+nome.trim().toUpperCase()+"%' ORDER BY NOME");
        return q.getResultList();
        }catch(PersistenceException ex){
            throw new PersistenciaException("Não foi possivel obter a lista de Produtos");
        }
    }
    
    public List<ProdutoVO> buscarTodos() throws PersistenciaException{
        try{
        Query q = ent.createQuery("FROM ProdutoVO ORDER BY NOME");
        return q.getResultList();
        }catch(PersistenceException ex){
            throw new PersistenciaException("Não foi possivel obter a lista de Produtos");
        }
    }   
    
    
    
}
