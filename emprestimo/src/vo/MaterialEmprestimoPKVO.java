/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Daniel
 */
@Embeddable
public class MaterialEmprestimoPKVO {
    
    @Column (name = "id_material",nullable = false)
    private int id_material;
    
    @Column (name = "id_emprestimo",nullable = false)
    private int id_emprestimo;
    
    //private static long serialVersionUID = 1L;
    public MaterialEmprestimoPKVO(){
        
    }
    public MaterialEmprestimoPKVO (int material, int emprestimo){
        this.id_emprestimo = emprestimo;
        this.id_material = material;
                
    }

    /**
     * @return the id_material
     */
    public int getId_material() {
        return id_material;
    }

    /**
     * @param id_material the id_material to set
     */
    public void setId_material(int id_material) {
        this.id_material = id_material;
    }

    /**
     * @return the id_emprestimo
     */
    public int getId_emprestimo() {
        return id_emprestimo;
    }

    /**
     * @param id_emprestimo the id_emprestimo to set
     */
    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }
    
}
