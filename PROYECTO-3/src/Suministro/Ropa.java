package Suministro;

import java.util.Scanner;

public class Ropa extends SuministroEmergencia {
    private String categoria = "";
    private String talla = "";
    private boolean esUtil = false;
    private int nivelPrioridad = 0;

    public Ropa() {
        super("", "", "", 0, false, "Ropa");
    }

    public Ropa(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String categoria, String talla, boolean esUtil, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, pesoKg, listoParaEnvio, "Ropa");
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
    public void registrarLote() {
        super.registrarLote();
        Scanner sc = ENTRADA;

        System.out.print("Ingrese la categoria: ");
        this.categoria = sc.nextLine();
        System.out.print("Ingrese la talla: ");
        this.talla = sc.nextLine();
        System.out.print("¿Es util? (Si/No): ");
        this.esUtil = sc.nextLine().equalsIgnoreCase("Si");
        System.out.print("Ingrese el nivel de prioridad (1-5): ");
        this.nivelPrioridad = leerInt(sc);
    }

    @Override
    protected String datosEspecificos() {
        return "\nCategoria: " + categoria
                + "\nTalla: " + talla
                + "\nUtil: " + (esUtil ? "Si" : "No")
                + "\nPrioridad: " + nivelPrioridad;
    }
}
    }

}
