package vo.Pagamento;

import javax.persistence.*;

@Entity
@Table(name = "documentopagamento")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentoPagamentoVO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    public DocumentoPagamentoVO() {
    }

    public DocumentoPagamentoVO(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    
}
