package conceito;

public class Data {
    
    private byte dia;
    private byte mês;
    private short ano;

    Data(byte dia, byte mês, short ano) {
        this.dia = dia;
        this.mês = mês;
        this.ano = ano;
    }

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getMês() {
        return mês;
    }

    public void setMês(byte mês) {
        this.mês = mês;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }
    
    
    
}
