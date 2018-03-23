package persistencia;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistencia.TelefoneVO;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-05T10:44:22")
@StaticMetamodel(PessoaVO.class)
public class PessoaVO_ { 

    public static volatile SingularAttribute<PessoaVO, Integer> codigo;
    public static volatile SetAttribute<PessoaVO, TelefoneVO> listaFone;
    public static volatile SingularAttribute<PessoaVO, String> nome;

}