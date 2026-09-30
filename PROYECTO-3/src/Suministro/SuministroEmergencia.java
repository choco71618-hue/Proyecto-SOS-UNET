package Suministro;

public abstract class SuministroEmergencia {
    private String idLote = "";
    private String nombreInsumo = "";
    private String descripcionUso = "";
    private String tipoAyuda = "";
    private double pesoKg = 0;
    private boolean listoParaEnvio = false;
    
    public SuministroEmergencia(String idLote, String nombreInsumo, String descripcionUso, String tipoAyuda, double pesoKg, boolean listoParaEnvio) {
        this.idLote = idLote;
        this.nombreInsumo = nombreInsumo;
        this.descripcionUso = descripcionUso;
        this.tipoAyuda = tipoAyuda;
        this.pesoKg = pesoKg;
        this.listoParaEnvio = listoParaEnvio;
    }

    public String getIdLote () { return idLote; }
    public String getNombreInsumo () { return nombreInsumo; }
    public String getDescripcionUso () { return descripcionUso; }
    public String getTipoAyuda () { return tipoAyuda; }
    public double getPesoKg () { return pesoKg; }
    public boolean getListoParaEnvio () { return listoParaEnvio; }

    public void setNombreInsumo (String nombreInsumo) { this.nombreInsumo = nombreInsumo; }
    public void setIdLote (String idLote) { this.idLote = idLote; }
    public void setDescripcionUso (String descripcionUso) { this.descripcionUso = descripcionUso; }
    public void setTipoAyuda (String tipoAyuda) { this.tipoAyuda = tipoAyuda; }
    public void setPesoKg (double pesoKg) { this.pesoKg = pesoKg; }
    public void setListoParaEnvio (boolean listoParaEnvio) { this.listoParaEnvio = listoParaEnvio; }

    public String registrarLote (String idLote) {
        this.idLote = idLote;
        return getNombreInsumo() + " agregado al lote: " + idLote;
    }
    public abstract String mostrarFichaLogistica ();
    public abstract boolean alternarEstadoDeEnvio ();
}
