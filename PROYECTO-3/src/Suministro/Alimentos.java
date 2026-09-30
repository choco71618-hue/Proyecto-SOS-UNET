package Suministro;

public class Alimentos extends SuministroEmergencia {
    private String tipoAlimento = "";
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Alimentos() {
        super("", "", "", "Alimentos", 0, false);
    }

    public Alimentos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoAlimento, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, "Alimentos", pesoKg, listoParaEnvio);
        this.tipoAlimento = tipoAlimento;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTipoAlimento() { return tipoAlimento; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setTipoAlimento(String tipoAlimento) { this.tipoAlimento = tipoAlimento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
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
                + "\nTipo de alimento: " + tipoAlimento
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }

    @Override
    public boolean alternarEstadoDeEnvio() {
        setListoParaEnvio(!getListoParaEnvio());
        return getListoParaEnvio();
    }
}