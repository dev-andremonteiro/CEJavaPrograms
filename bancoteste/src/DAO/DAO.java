package DAO;

import javax.persistence.EntityManager;
import persistencia.PersistenciaException;


public class DAO<VO>{
    
    EntityManager ent;
    
    public DAO(EntityManager ent){
        this.ent = ent;
    }
    
    public void incluir(VO vo) throws PersistenciaException{
        this.ent.persist(vo);
    }
    public void alterar(VO vo) throws PersistenciaException{
        this.ent.merge(vo);
    }
    public void excluir(VO vo) throws PersistenciaException{
        this.ent.remove(vo);
    }
    
    public void iniciarTransacao(){
        this.ent.getTransaction().begin();
    }
    
    public void confirmarTransacao(){
        this.ent.getTransaction().commit();
    }
    
    public void cancelarTransacao(){
        this.ent.getTransaction().rollback();
    }

}
