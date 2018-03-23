package vo.Endereco;

import javax.persistence.*;

@Embeddable
public class TelefoneVO {
    @Enumerated(EnumType.ORDINAL)
    private TipoUsoTelefoneEnum tipoUsoFone;
    @Enumerated(EnumType.ORDINAL)
    private TipoTelefoneEnum tipoFone;
    @Column(length = 3,nullable = false)
    private String ddi;
    @Column(length = 2,nullable = false)
    private String ddd;
    @Column(length = 9,nullable = false)
    private String numero;

    public TelefoneVO() {
    }

    public TelefoneVO(TipoUsoTelefoneEnum tipoUsoFone, TipoTelefoneEnum tipoFone, String ddi, String ddd, String numero) {
        this.tipoUsoFone = tipoUsoFone;
        this.tipoFone = tipoFone;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoUsoTelefoneEnum getTipoUsoFone() {
        return tipoUsoFone;
    }

    public void setTipoUsoFone(TipoUsoTelefoneEnum tipoUsoFone) {
        this.tipoUsoFone = tipoUsoFone;
    }

    public TipoTelefoneEnum getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(TipoTelefoneEnum tipoFone) {
        this.tipoFone = tipoFone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    
}
