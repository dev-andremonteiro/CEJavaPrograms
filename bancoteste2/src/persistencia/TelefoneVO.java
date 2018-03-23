/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author André
 */

@Embeddable
public class TelefoneVO {
    
    @Enumerated(EnumType.ORDINAL)
    private TipoFoneEnum tipofone;
    @Column(length = 3,nullable = false)
    private String fone_ddi;
    @Column(length = 3,nullable = false)
    private String fone_ddd;
    @Column(length = 9,nullable = false)
    private String fone_numero;
    
    public TelefoneVO(){
        
    }

    public TelefoneVO(TipoFoneEnum tipofone, String fone_ddi, String fone_ddd, String fone_numero) {
        this.tipofone = tipofone;
        this.fone_ddi = fone_ddi;
        this.fone_ddd = fone_ddd;
        this.fone_numero = fone_numero;
    }
    
    public TipoFoneEnum getFone() {
        return tipofone;
    }

    public void setFone(TipoFoneEnum fone) {
        this.tipofone = fone;
    }

    public String getFone_ddi() {
        return fone_ddi;
    }

    public void setFone_ddi(String fone_ddi) {
        this.fone_ddi = fone_ddi;
    }

    public String getFone_ddd() {
        return fone_ddd;
    }

    public void setFone_ddd(String fone_ddd) {
        this.fone_ddd = fone_ddd;
    }

    public String getFone_numero() {
        return fone_numero;
    }

    public void setFone_numero(String fone_numero) {
        this.fone_numero = fone_numero;
    }
    
}
