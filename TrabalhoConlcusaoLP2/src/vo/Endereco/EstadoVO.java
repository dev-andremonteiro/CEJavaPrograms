package vo.Endereco;

import javax.persistence.*;

@Entity
@Table(name = "estado")

public class EstadoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 2,nullable = false)
    private String uf;
    @Column(length = 40,nullable = false)
    private String nome;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoVO() {
    }

    public EstadoVO(long ID, String uf, String nome) {
        this.ID = ID;
        this.uf = uf;
        this.nome = nome;
    }
    
}
