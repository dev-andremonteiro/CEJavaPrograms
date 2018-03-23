package persistencia;

import java.util.Set;
import javax.persistence.*;


/**
 *
 * @author André
 */
@Entity
@Table(name = "b")
public class B_VO extends A_VO{
    
    @Column(nullable = false)
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    
    
    
}
