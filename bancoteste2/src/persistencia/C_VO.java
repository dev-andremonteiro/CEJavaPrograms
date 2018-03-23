/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.*;

/**
 *
 * @author André
 */
@Entity
@Table(name ="c")
@PrimaryKeyJoinColumn(name = "codigoa")
public class C_VO extends A_VO{
    
    @Column(nullable = false)
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
    