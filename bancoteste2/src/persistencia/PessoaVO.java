/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author André
 */
@Entity
@Table(name = "pessoa")
public class PessoaVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;
    @Column(length = 40,nullable = false)
    private String nome;
    @ElementCollection
    @CollectionTable(
            name = "telefone",
            joinColumns = @JoinColumn(name = "pessoa_fone"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"pessoa_fone","tipofone"})
            )
    private Set<TelefoneVO> listaFone;

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

    public Set<TelefoneVO> getListaFone() {
        return listaFone;
    }

    public void setListaFone(Set<TelefoneVO> listaFone) {
        this.listaFone = listaFone;
    }
    
    
    
}
