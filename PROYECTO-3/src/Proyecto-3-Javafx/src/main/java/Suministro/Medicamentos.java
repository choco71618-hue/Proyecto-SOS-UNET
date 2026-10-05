package Suministro;

import java.util.Scanner;

public class Medicamentos extends SuministroEmergencia {
    private String principioActivo = "";
    private String dosis = "";
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Medicamentos() {
        super("", "", "", 0, false, "Medicina");
    }

    public Medicamentos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String principioActivo, String dosis, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, pesoKg, listoParaEnvio, "Medicina");
        this.principioActivo = principioActivo;
        this.dosis = dosis;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getPrincipioActivo() { return principioActivo; }
    public String getDosis() { return dosis; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setPrincipioActivo(String principioActivo) { this.principioActivo = principioActivo; }
    public void setDosis(String dosis) { this.dosis = dosis; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    @Override
    public void registrarLote() {
        super.registrarLote();
        Scanner sc = ENTRADA;

        System.out.print("Ingrese el principio activo: ");
        this.principioActivo = sc.nextLine();
        System.out.print("Ingrese la dosis: ");
        this.dosis = sc.nextLine();
        System.out.print("Ingrese la fecha de vencimiento: ");
        this.fechaVencimiento = sc.nextLine();
        System.out.print("Ingrese el nivel de prioridad (1-5): ");
        this.nivelPrioridad = leerInt(sc);
    }

    @Override
    protected String datosEspecificos() {
        return "\nPrincipio activo: " + principioActivo
                + "\nDosis: " + dosis
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }
}