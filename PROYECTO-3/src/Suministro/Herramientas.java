package Suministro;

public class Herramientas extends SuministroEmergencia {
    private String tipoHerramienta = "";
    private int cantidad = 0;
    private int nivelPrioridad = 0;

    public Herramientas() {
        super("", "", "", "Herramientas", 0, false);
    }

    public Herramientas(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoHerramienta, int cantidad, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, "Herramientas", pesoKg, listoParaEnvio);
        this.tipoHerramienta = tipoHerramienta;
        this.cantidad = cantidad;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTipoHerramienta() { return tipoHerramienta; }
    public int getCantidad() { return cantidad; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setTipoHerramienta(String tipoHerramienta) { this.tipoHerramienta = tipoHerramienta; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    @Override
    public String mostrarFichaLogistica() {
        return "=== FICHA LOGISTICA ==="
                + "\nId lote: " + getIdLote()
                + "\nTipo de ayuda: " + getTipoAyuda()
                + "\nNombre: " + getNombreInsumo()
                + "\nDescripcion: " + getDescripcionUso()
                + "\nPeso: " + getPesoKg() + " kg"
                + "\nListo para envio: " + (getListoParaEnvio() ? "Si" : "No")
                + "\nTipo de herramienta: " + tipoHerramienta
                + "\nCantidad: " + cantidad
                + "\nPrioridad: " + nivelPrioridad;
    }

    @Override
    public boolean alternarEstadoDeEnvio() {
        setListoParaEnvio(!getListoParaEnvio());
        return getListoParaEnvio();
    }
}