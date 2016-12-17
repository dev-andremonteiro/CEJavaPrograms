package conceito;

public class Agregacao {
    private Data estaData;
    private Hora estaHora;
    
    Agregacao(byte hora,byte minuto,byte segundo,byte dia,byte mês,short ano){
        estaData = new Data(dia,mês,ano);
        estaHora = new Hora(hora,minuto,segundo);
    }

    Agregacao(byte dia,byte mês,byte ano){
        this((byte)0,(byte)0,(byte)0,dia,mês,ano);
    }

    @Override
    public String toString() {
        return "Agregacao{" + "estaData=" + estaData + ", estaHora=" + estaHora + '}';
    }

    
}
