package Suministro;

public class Colaborador extends Personas {
    private String area = "";

    public Colaborador() {
        super("", "", "Colaborador");
    }

    public Colaborador(String nombre, String cedula, String area) {
        super(nombre, cedula, "Colaborador");
        this.area = area;
    }

    public String getArea() { return area; }

    public void setArea(String area) { this.area = area; }
}