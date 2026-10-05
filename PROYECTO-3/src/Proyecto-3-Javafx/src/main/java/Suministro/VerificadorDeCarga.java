package Suministro;

public class VerificadorDeCarga extends Personas {
    private boolean puedeAprobar = false;

    public VerificadorDeCarga() {
        super("", "", "VerificadorDeCarga");
    }

    public VerificadorDeCarga(String nombre, String cedula, boolean puedeAprobar) {
        super(nombre, cedula, "VerificadorDeCarga");
        this.puedeAprobar = puedeAprobar;
    }

    public boolean isPuedeAprobar() { return puedeAprobar; }

    public void setPuedeAprobar(boolean puedeAprobar) { this.puedeAprobar = puedeAprobar; }
}