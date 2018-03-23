package vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import vo.GrupoProdutoVO;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-21T16:19:47")
@StaticMetamodel(ProdutoVO.class)
public class ProdutoVO_ { 

    public static volatile SingularAttribute<ProdutoVO, Integer> estoque;
    public static volatile SingularAttribute<ProdutoVO, Integer> codigo;
    public static volatile SingularAttribute<ProdutoVO, Float> promocao;
    public static volatile SingularAttribute<ProdutoVO, Float> margemLucro;
    public static volatile SingularAttribute<ProdutoVO, Float> valorCompra;
    public static volatile SingularAttribute<ProdutoVO, GrupoProdutoVO> grupo;
    public static volatile SingularAttribute<ProdutoVO, String> nome;

}