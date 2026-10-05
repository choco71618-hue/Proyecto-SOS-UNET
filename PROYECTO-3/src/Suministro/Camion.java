package Suministro;

public class Camion extends Transporte {
    private double capacidadVolumen = 0;

    public Camion() {
        super("", "Camion", "", 0);
    }

    public Camion(String placa, String destino, double pesoMaximo, double capacidadVolumen) {
        super(placa, "Camion", destino, pesoMaximo);
        this.capacidadVolumen = capacidadVolumen;
    }

    public double getCapacidadVolumen() { return capacidadVolumen; }

    public void setCapacidadVolumen(double capacidadVolumen) { this.capacidadVolumen = capacidadVolumen; }
}
