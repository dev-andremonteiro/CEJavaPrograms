package vo;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vo.ProdutoVO;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-21T16:19:47")
@StaticMetamodel(BaixaVO.class)
public class BaixaVO_ { 

    public static volatile SingularAttribute<BaixaVO, Integer> codigo;
    public static volatile SingularAttribute<BaixaVO, Integer> motivo;
    public static volatile SingularAttribute<BaixaVO, ProdutoVO> produto;
    public static volatile SingularAttribute<BaixaVO, Date> dataRegistro;
    public static volatile SingularAttribute<BaixaVO, Integer> quantidade;

}