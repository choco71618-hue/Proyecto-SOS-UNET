package Suministro;

public class Verficador extends Personas {
    private String zonaVerificacion = "";
    private int lotesVerificados = 0;

    public Verficador() {
        super("", "", "VerificadorDeCarga");
    }

    public Verficador(String nombre, String cedula, String zonaVerificacion) {
        super(nombre, cedula, "VerificadorDeCarga");
        this.zonaVerificacion = zonaVerificacion;
    }

    public String getZonaVerificacion() { return zonaVerificacion; }
    public int getLotesVerificados() { return lotesVerificados; }

    public void setZonaVerificacion(String zonaVerificacion) { this.zonaVerificacion = zonaVerificacion; }
    public void setLotesVerificados(int lotesVerificados) { this.lotesVerificados = lotesVerificados; }

    public String verificarLote(SuministroEmergencia lote) {
        lotesVerificados++;
        lote.setListoParaEnvio(true);
        return "Lote " + lote.getNombreInsumo() + " verificado y aprobado para envio";
    }
}