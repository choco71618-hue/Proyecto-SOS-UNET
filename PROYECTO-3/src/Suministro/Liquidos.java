package Suministro;

public class Liquidos extends SuministroEmergencia {
    private String tipoLiquido = "";
    private double volumenLitros = 0;
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Liquidos() {
        super("", "", "", "Liquidos", 0, false);
    }

    public Liquidos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoLiquido, double volumenLitros, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, "Liquidos", pesoKg, listoParaEnvio);
        this.tipoLiquido = tipoLiquido;
        this.volumenLitros = volumenLitros;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTipoLiquido() { return tipoLiquido; }
    public double getVolumenLitros() { return volumenLitros; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setTipoLiquido(String tipoLiquido) { this.tipoLiquido = tipoLiquido; }
    public void setVolumenLitros(double volumenLitros) { this.volumenLitros = volumenLitros; }
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
                + "\nTipo de liquido: " + tipoLiquido
                + "\nVolumen: " + volumenLitros + " L"
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }

    @Override
    public boolean alternarEstadoDeEnvio() {
        setListoParaEnvio(!getListoParaEnvio());
        return getListoParaEnvio();
    }
}