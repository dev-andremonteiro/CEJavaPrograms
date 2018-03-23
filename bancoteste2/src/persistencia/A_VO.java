package persistencia;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author André
 */

@Entity
@Table(name="a")
@Inheritance(strategy = InheritanceType.JOINED)
public class A_VO {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int codigo;
    @Column(length=40, nullable = false)
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
