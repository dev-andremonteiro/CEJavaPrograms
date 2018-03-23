package vo.Pessoa;

import vo.Endereco.TelefoneVO;
import vo.Endereco.EnderecoVO;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 50,nullable = false)
    private String nome;
    @Embedded
    private EnderecoVO enderecoVO;
    @ElementCollection
    @CollectionTable(
            name = "telefone",
            joinColumns = @JoinColumn(name = "pessoa_fone"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"pessoa_fone,tipoFone,tipoUsoFone"})
    )
    private Set<TelefoneVO> listaFone;

    public PessoaVO() {
    }

    public PessoaVO(long ID, String nome, EnderecoVO enderecoVO, Set<TelefoneVO> listaFone) {
        this.ID = ID;
        this.nome = nome;
        this.enderecoVO = enderecoVO;
        this.listaFone = listaFone;
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

    public EnderecoVO getEnderecoVO() {
        return enderecoVO;
    }

    public void setEnderecoVO(EnderecoVO enderecoVO) {
        this.enderecoVO = enderecoVO;
    }

    public Set<TelefoneVO> getListaFone() {
        return listaFone;
    }

    public void setListaFone(Set<TelefoneVO> listaFone) {
        this.listaFone = listaFone;
    }
    
    
}
