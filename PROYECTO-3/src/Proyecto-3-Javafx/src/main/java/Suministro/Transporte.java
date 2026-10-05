package Suministro;

public class Transporte {
    private String placa = "";
    private String tipo = "";
    private String destino = "";
    private double pesoMaximo = 0;
    private String estado = "En espera";
    private int ordenSalida = 0;
    private SuministroEmergencia[] carga = new SuministroEmergencia[0];

    public Transporte() {
    }

    public Transporte(String placa, String tipo, String destino, double pesoMaximo) {
        this.placa = placa;
        this.tipo = tipo;
        this.destino = destino;
        this.pesoMaximo = pesoMaximo;
    }

    public Transporte(String placa, String tipo, String destino, double pesoMaximo, int ordenSalida) {
        this(placa, tipo, destino, pesoMaximo);
        this.ordenSalida = ordenSalida;
    }

    public String getPlaca() { return placa; }
    public String getTipo() { return tipo; }
    public String getDestino() { return destino; }
    public double getPesoMaximo() { return pesoMaximo; }
    public String getEstado() { return estado; }
    public int getOrdenSalida() { return ordenSalida; }
    public SuministroEmergencia[] getCarga() { return carga; }

    public void setPlaca(String placa) { this.placa = placa; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setDestino(String destino) { this.destino = destino; }
    public void setPesoMaximo(double pesoMaximo) { this.pesoMaximo = pesoMaximo; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setOrdenSalida(int ordenSalida) { this.ordenSalida = ordenSalida; }

    public double pesoActual() {
        double total = 0;
        for (int i = 0; i < carga.length; i++) {
            total += carga[i].getPesoKg();
        }
        return total;
    }

    public boolean estaLleno() {
        return pesoMaximo > 0 && pesoActual() >= pesoMaximo;
    }

    public void agregarLote(SuministroEmergencia lote) {
        SuministroEmergencia[] nuevos = new SuministroEmergencia[carga.length + 1];
        System.arraycopy(carga, 0, nuevos, 0, carga.length);
        nuevos[carga.length] = lote;
        carga = nuevos;
        lote.asignarTransporte(this);
        if (estaLleno()) {
            setEstado("Listo para salir");
        }
    }
}