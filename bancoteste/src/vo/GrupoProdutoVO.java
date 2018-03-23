
package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupoproduto")
public class GrupoProdutoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    
    @Column(name="nome",length = 40,nullable=false)
    private String nome;
    
    @Column(name="margemlucro",precision = 5,scale = 2)
    private float margemlucro;
    
    @Column(name="promocao",precision = 5,scale = 2)
    private float promocao;

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

    public float getMargemlucro() {
        return margemlucro;
    }

    public void setMargemlucro(float margemlucro) {
        this.margemlucro = margemlucro;
    }

    public float getPromocao() {
        return promocao;
    }

    public void setPromocao(float promocao) {
        this.promocao = promocao;
    }
    
    
}
