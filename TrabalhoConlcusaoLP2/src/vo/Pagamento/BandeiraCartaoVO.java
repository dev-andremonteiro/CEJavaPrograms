package vo.Pagamento;

import javax.persistence.*;

@Entity
@Table(name = "bandeiracartao")
public class BandeiraCartaoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 20,nullable = false)
    private String nome;

    public BandeiraCartaoVO() {
    }

    public BandeiraCartaoVO(long ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
}
