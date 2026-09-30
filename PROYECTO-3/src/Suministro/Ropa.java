package Suministro;

public class Ropa extends SuministroEmergencia {
    private String categoria = "";
    private String talla = "";
    private boolean esUtil = false;
    private int nivelPrioridad = 0;

    public Ropa() {
        super("", "", "", "Ropa", 0, false);
    }

    public Ropa(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String categoria, String talla, boolean esUtil, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, "Ropa", pesoKg, listoParaEnvio);
        this.categoria = categoria;
        this.talla = talla;
        this.esUtil = esUtil;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getCategoria() { return categoria; }
    public String getTalla() { return talla; }
    public boolean getEsUtil() { return esUtil; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setTalla(String talla) { this.talla = talla; }
    public void setEsUtil(boolean esUtil) { this.esUtil = esUtil; }
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
                + "\nCategoria: " + categoria
                + "\nTalla: " + talla
                + "\nUtil: " + (esUtil ? "Si" : "No")
                + "\nPrioridad: " + nivelPrioridad;
    }

    @Override
    public boolean alternarEstadoDeEnvio() {
        setListoParaEnvio(!getListoParaEnvio());
        return getListoParaEnvio();
    }

}
