package vo.Produto;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class CategoriaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @Column(length = 30,nullable = false)
    private String nome;
    @Column(precision = 5,scale = 2,nullable = false)
    private float margemLucro;
    @Column(precision = 5,scale = 2,nullable = false)
    private float percPromocao;
    @Column(precision = 5,scale = 2,nullable = false)
    private float percComissao;

    public CategoriaVO() {
    }

    public CategoriaVO(long ID, String nome, float margemLucro, float percPromocao, float percComissao) {
        this.ID = ID;
        this.nome = nome;
        this.margemLucro = margemLucro;
        this.percPromocao = percPromocao;
        this.percComissao = percComissao;
    }

    public float getPercComissao() {
        return percComissao;
    }

    public void setPercComissao(float percComissao) {
        this.percComissao = percComissao;
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

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public float getPercPromocao() {
        return percPromocao;
    }

    public void setPercPromocao(float percPromocao) {
        this.percPromocao = percPromocao;
    }
    
}
