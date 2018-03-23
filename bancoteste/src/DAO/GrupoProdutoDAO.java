package DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import persistencia.PersistenciaException;
import vo.GrupoProdutoVO;

public class GrupoProdutoDAO extends DAO<GrupoProdutoVO>{
    
    public GrupoProdutoDAO(EntityManager ent) {
        super(ent);
    }
    
    public GrupoProdutoVO buscarPorCodigo(int codigo) throws PersistenceException, PersistenciaException{
        try{
            return this.ent.find(GrupoProdutoVO.class, codigo);
        }catch(PersistenceException ex){
            throw new PersistenciaException("Não foi possivel obter a lista de Grupos Produtos");
        }
    }
    
    public List<GrupoProdutoVO> buscarPorNome(String nome) throws PersistenciaException{
        try{
            Query q = ent.createQuery("SELECT G FROM GrupoProdutoVO G WHERE TRIM(G.nome)= 'nome'");
            return q.getResultList();
        }catch(PersistenceException ex){
            throw new PersistenciaException("Não foi possivel obter a lista de Grupos Produtos");
        }
    }
    
    
}
