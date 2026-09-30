package Suministro;

public class Transporte {
    private String placa = "";
    private String tipoTransporte = "";
    private String destino = "";
    private double pesoMaximo = 0;
    private double pesoActual = 0;

    public Transporte() {
    }

    public Transporte(String placa, String tipoTransporte, String destino, double pesoMaximo) {
        this.placa = placa;
        this.tipoTransporte = tipoTransporte;
        this.destino = destino;
        this.pesoMaximo = pesoMaximo;
    }

    public String getPlaca() { return placa; }
    public String getTipoTransporte() { return tipoTransporte; }
    public String getDestino() { return destino; }
    public double getPesoMaximo() { return pesoMaximo; }
    public double getPesoActual() { return pesoActual; }

    public void setPlaca(String placa) { this.placa = placa; }
    public void setTipoTransporte(String tipoTransporte) { this.tipoTransporte = tipoTransporte; }
    public void setDestino(String destino) { this.destino = destino; }
    public void setPesoMaximo(double pesoMaximo) { this.pesoMaximo = pesoMaximo; }
    public void setPesoActual(double pesoActual) { this.pesoActual = pesoActual; }

    public void cargarPeso(double peso) {
        pesoActual += peso;
    }

    public boolean estaLleno() {
        return pesoActual >= pesoMaximo;
    }

    public boolean estaListoParaEnvio() {
        return pesoMaximo > 0 && pesoActual >= pesoMaximo;
    }

    public String mostrarEstado() {
        return "Placa: " + placa
                + "\nTipo: " + tipoTransporte
                + "\nDestino: " + destino
                + "\nPeso: " + pesoActual + " / " + pesoMaximo + " kg"
                + "\nEstado: " + (estaListoParaEnvio() ? "Listo para salir" : "Cargando");
    }
}