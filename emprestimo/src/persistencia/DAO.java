package persistencia;

import javax.persistence.EntityManager;

public class DAO<VO>{
    protected EntityManager entityManager;
    
    public DAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void incluir(VO vo) throws PersistenciaException{
        this.entityManager.persist(vo);
    }
    
    public void alterar(VO vo) throws PersistenciaException{
        this.entityManager.merge(vo);
    }
    
    public void excluir(VO vo) throws PersistenciaException{
        this.entityManager.remove(vo);
    }
    
    public void iniciarTransacao(){
        this.entityManager.getTransaction().begin();
    }
    
    public void confirmarTransacao(){
        this.entityManager.getTransaction().commit();
    }
    
    public void cancelarTransacao(){
        this.entityManager.getTransaction().rollback();
    }
}