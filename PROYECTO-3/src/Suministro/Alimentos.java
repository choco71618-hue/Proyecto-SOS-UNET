package Suministro;

import java.util.Scanner;

public class Alimentos extends SuministroEmergencia {
    private String tipoAlimento = "";
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Alimentos() {
        super("", "", "", 0, false, "Alimentos");
    }

    public Alimentos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoAlimento, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, pesoKg, listoParaEnvio, "Alimentos");
        this.tipoAlimento = tipoAlimento;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTipoAlimento() { return tipoAlimento; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setTipoAlimento(String tipoAlimento) { this.tipoAlimento = tipoAlimento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    @Override
    public void registrarLote() {
        super.registrarLote();
        Scanner sc = ENTRADA;

        System.out.print("Ingrese el tipo de alimento: ");
        this.tipoAlimento = sc.nextLine();
        System.out.print("Ingrese la fecha de vencimiento: ");
        this.fechaVencimiento = sc.nextLine();
        System.out.print("Ingrese el nivel de prioridad (1-5): ");
        this.nivelPrioridad = leerInt(sc);
    }

    @Override
    protected String datosEspecificos() {
        return "\nTipo de alimento: " + tipoAlimento
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }
}
