package vo.Pessoa;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class ClienteVO extends PessoaJuridicaVO{
    
    @OneToOne(fetch = FetchType.EAGER)
    private VendedorVO vendedorVO;

    public ClienteVO() {
    }

    
    public ClienteVO(VendedorVO vendedorVO) {
        this.vendedorVO = vendedorVO;
    }

    public VendedorVO getVendedorVO() {
        return vendedorVO;
    }

    public void setVendedorVO(VendedorVO vendedorVO) {
        this.vendedorVO = vendedorVO;
    }
    
}
