package conceito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ColecaoGenerica implements IColecaoGenerica{
 
    ArrayList listaGenerica;
    

    public ColecaoGenerica(){
        listaGenerica = new ArrayList();
    }
    
    public void adicionaGenerico(IPossuiNome generico){
        listaGenerica.add(generico);
    }
    
    public Iterator getIterator(){
        return listaGenerica.iterator();
    }
    
    public void ordena(){
        Collections.sort(listaGenerica, new ComparaNome());
    }
    
    
}
