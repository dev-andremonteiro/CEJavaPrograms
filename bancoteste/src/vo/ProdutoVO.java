package vo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "produto")
public class ProdutoVO implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(nullable = false)
    private int estoque;
    @Column(nullable = false,precision = 8,scale = 2)
    private float valorCompra;
    @Column(nullable = false,precision = 5,scale = 2)
    private float margemLucro;
    @Column(nullable = false,precision = 5,scale = 2)
    private float promocao;
    @Transient
    private float venda;
    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.REFRESH)
    private GrupoProdutoVO grupo;

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

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public float getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(float margemLucro) {
        this.margemLucro = margemLucro;
    }

    public float getPromocao() {
        return promocao;
    }

    public void setPromocao(float promocao) {
        this.promocao = promocao;
    }

    public float getVenda() {
        return venda;
    }

    public void setVenda(float venda) {
        this.venda = venda;
    }

    public GrupoProdutoVO getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProdutoVO grupo) {
        this.grupo = grupo;
    }
    
    
    
}
