package Suministro;

public class Conductor {
    private String nombre = "";
    private String cedula = "";
    private String tipoLicencia = "";
    private Transporte transporteAsignado = null;

    public Conductor() {
    }

    public Conductor(String nombre, String cedula, String tipoLicencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoLicencia = tipoLicencia;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getTipoLicencia() { return tipoLicencia; }
    public Transporte getTransporteAsignado() { return transporteAsignado; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setTipoLicencia(String tipoLicencia) { this.tipoLicencia = tipoLicencia; }

    public void asignarTransporte(Transporte transporteAsignado) {
        this.transporteAsignado = transporteAsignado;
    }
}
