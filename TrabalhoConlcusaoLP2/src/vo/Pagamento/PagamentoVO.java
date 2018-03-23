package vo.Pagamento;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class PagamentoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<ParcelaPagamentoVO> listaParcelas;

    public PagamentoVO() {
    }

    public PagamentoVO(long ID, Set<ParcelaPagamentoVO> listaParcelas) {
        this.ID = ID;
        this.listaParcelas = listaParcelas;
    }
    

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Set<ParcelaPagamentoVO> getListaParcelas() {
        return listaParcelas;
    }

    public void setListaParcelas(Set<ParcelaPagamentoVO> listaParcelas) {
        this.listaParcelas = listaParcelas;
    }
    
    
    
}
