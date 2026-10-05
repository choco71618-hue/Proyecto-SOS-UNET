package Suministro;

public class Avion extends Transporte {
    private String modelo = "";
    private double capacidadCombustible = 0;

    public Avion() {
        super("", "Avion", "", 0);
    }

    public Avion(String placa, String modelo, String destino, double pesoMaximo, double capacidadCombustible) {
        super(placa, "Avion", destino, pesoMaximo);
        this.modelo = modelo;
        this.capacidadCombustible = capacidadCombustible;
    }

    public String getModelo() { return modelo; }
    public double getCapacidadCombustible() { return capacidadCombustible; }

    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCapacidadCombustible(double capacidadCombustible) { this.capacidadCombustible = capacidadCombustible; }
}
