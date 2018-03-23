package vo.Endereco;

import javax.persistence.*;

@Entity
@Table(name = "bairro")
public class BairroVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 40,nullable = false)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    private CidadeVO cidadeVO;

    public BairroVO(long ID, String nome, CidadeVO cidadeVO) {
        this.ID = ID;
        this.nome = nome;
        this.cidadeVO = cidadeVO;
    }

    public BairroVO() {
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

    public CidadeVO getCidadeVO() {
        return cidadeVO;
    }

    public void setCidadeVO(CidadeVO cidadeVO) {
        this.cidadeVO = cidadeVO;
    }
}
