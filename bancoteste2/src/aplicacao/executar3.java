/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import persistencia.C_VO;

/**
 *
 * @author André
 */
public class executar3 {
    
    public static void main(String[] args) {
        
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("unidadebd");
        EntityManager ent = fac.createEntityManager();
        
        
        C_VO c = new C_VO();
        c.setNome("TestandoC");
        c.setY(0);
        
        ent.getTransaction().begin();
        ent.persist(c);
        ent.getTransaction().commit(); 
        
    }
    
}
