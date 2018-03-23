
package DAO;

import javax.persistence.EntityManager;
import vo.BaixaVO;

public class RegistroBaixaDAO extends DAO<BaixaVO>{
    
    public RegistroBaixaDAO(EntityManager ent) {
        super(ent);
    }
    
}
