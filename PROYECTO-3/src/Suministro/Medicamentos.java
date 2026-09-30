package Suministro;

public class Medicamentos extends SuministroEmergencia {
    private String principioActivo = "";
    private String dosis = "";
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Medicamentos() {
        super("", "", "", "Medicina", 0, false);
    }

    public Medicamentos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String principioActivo, String dosis, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, "Medicina", pesoKg, listoParaEnvio);
        this.principioActivo = principioActivo;
        this.dosis = dosis;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getPrincipioActivo() { return principioActivo; }
    public String getDosis() { return dosis; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setPrincipioActivo(String principioActivo) { this.principioActivo = principioActivo; }
    public void setDosis(String dosis) { this.dosis = dosis; }
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
                + "\nPrincipio activo: " + principioActivo
                + "\nDosis: " + dosis
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }

    @Override
    public boolean alternarEstadoDeEnvio() {
        setListoParaEnvio(!getListoParaEnvio());
        return getListoParaEnvio();
    }
}