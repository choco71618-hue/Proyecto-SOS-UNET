package Suministro;

public class Personas {
    private String nombre = "";
    private String cedula = "";
    private String rol = "";

    public Personas() {
    }

    public Personas(String nombre, String cedula, String rol) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.rol = rol;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getRol() { return rol; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setRol(String rol) { this.rol = rol; }
}