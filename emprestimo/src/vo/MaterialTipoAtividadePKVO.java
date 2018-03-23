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
public class MaterialTipoAtividadePKVO {
    
    @Column (name = "id_material",nullable = false)
    private int id_material;
    
    @Column (name = "id_tipo",nullable = false)
    private int id_tipo;
    
    //private static long serialVersionUID = 1L;
    public MaterialTipoAtividadePKVO(){
        
    }
    public MaterialTipoAtividadePKVO (int material, int tipo){
        this.id_tipo = tipo;
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
     * @return the id_tipo
     */
    public int getId_tipo() {
        return id_tipo;
    }

    /**
     * @param id_tipo the id_tipo to set
     */
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    
}
