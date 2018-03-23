package vo.Endereco;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class CidadeVO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 40,nullable = false)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoVO estadoVO;

    public CidadeVO() {
    }

    public CidadeVO(long ID, String nome, EstadoVO estadoVO) {
        this.ID = ID;
        this.nome = nome;
        this.estadoVO = estadoVO;
    }

    public EstadoVO getEstadoVO() {
        return estadoVO;
    }

    public void setEstadoVO(EstadoVO estadoVO) {
        this.estadoVO = estadoVO;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
