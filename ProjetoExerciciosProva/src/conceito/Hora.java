
package conceito;

public class Hora {
    
    private byte hora;
    private byte minuto;
    private byte segundo;

    Hora(byte hora, byte minuto, byte segundo) {
            this.hora = hora;
            this.minuto = minuto;
            this. segundo = segundo;
    }

    public byte getHora() {
        return hora;
    }

    public void setHora(byte hora) {
        this.hora = hora;
    }

    public byte getMinuto() {
        return minuto;
    }

    public void setMinuto(byte minuto) {
        this.minuto = minuto;
    }

    public byte getSegundo() {
        return segundo;
    }

    public void setSegundo(byte segundo) {
        this.segundo = segundo;
    }
    
    
    
}
