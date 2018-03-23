package vo.Pagamento;

import javax.persistence.*;

@Entity
@Table(name = "banco")
public class BancoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 10,nullable = false)
    private String codigo;
    @Column(length = 30,nullable = false)
    private String nome;

    public BancoVO() {
    }

    public BancoVO(long ID, String codigo, String nome) {
        this.ID = ID;
        this.codigo = codigo;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
