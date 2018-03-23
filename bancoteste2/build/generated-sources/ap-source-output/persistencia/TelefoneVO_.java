package persistencia;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import persistencia.TipoFoneEnum;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-05T10:44:22")
@StaticMetamodel(TelefoneVO.class)
public class TelefoneVO_ { 

    public static volatile SingularAttribute<TelefoneVO, TipoFoneEnum> tipofone;
    public static volatile SingularAttribute<TelefoneVO, String> fone_numero;
    public static volatile SingularAttribute<TelefoneVO, String> fone_ddi;
    public static volatile SingularAttribute<TelefoneVO, String> fone_ddd;

}