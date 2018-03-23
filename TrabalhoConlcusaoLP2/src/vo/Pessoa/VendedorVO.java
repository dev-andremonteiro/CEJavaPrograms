package vo.Pessoa;

import java.util.Set;
import javax.persistence.*;
import vo.Endereco.CidadeVO;

@Entity
@Table(name = "vendedor")
public class VendedorVO extends PessoaFisicaVO{
    @OneToMany(fetch = FetchType.LAZY)
    private Set<CidadeVO> listaMunicipios;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ClienteVO> listaClientes;

    public VendedorVO() {
    }

    public VendedorVO(Set<CidadeVO> listaMunicipios, Set<ClienteVO> listaClientes) {
        this.listaMunicipios = listaMunicipios;
        this.listaClientes = listaClientes;
    }

    public Set<ClienteVO> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Set<ClienteVO> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Set<CidadeVO> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaMunicipios(Set<CidadeVO> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }
    
}
