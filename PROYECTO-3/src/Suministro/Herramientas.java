package Suministro;

import java.util.Scanner;

public class Herramientas extends SuministroEmergencia {
    private String tipoHerramienta = "";
    private int cantidad = 0;
    private int nivelPrioridad = 0;

    public Herramientas() {
        super("", "", "", 0, false, "Herramientas");
    }

    public Herramientas(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoHerramienta, int cantidad, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, pesoKg, listoParaEnvio, "Herramientas");
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
    public void registrarLote() {
        super.registrarLote();
        Scanner sc = ENTRADA;

        System.out.print("Ingrese el tipo de herramienta: ");
        this.tipoHerramienta = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        this.cantidad = leerInt(sc);
        System.out.print("Ingrese el nivel de prioridad (1-5): ");
        this.nivelPrioridad = leerInt(sc);
    }

    @Override
    protected String datosEspecificos() {
        return "\nTipo de herramienta: " + tipoHerramienta
                + "\nCantidad: " + cantidad
                + "\nPrioridad: " + nivelPrioridad;
    }
}
