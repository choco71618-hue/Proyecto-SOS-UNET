package Suministro;

public class Coche extends Transporte {
    private String modelo = "";

    public Coche() {
        super("", "Coche", "", 0);
    }

    public Coche(String placa, String modelo, String destino, double pesoMaximo) {
        super(placa, "Coche", destino, pesoMaximo);
        this.modelo = modelo;
    }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) { this.modelo = modelo; }
}
