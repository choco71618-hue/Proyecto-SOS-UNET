package Suministro;

import java.util.Scanner;

public class Liquidos extends SuministroEmergencia {
    private String tipoLiquido = "";
    private double volumenLitros = 0;
    private String fechaVencimiento = "";
    private int nivelPrioridad = 0;

    public Liquidos() {
        super("", "", "", 0, false, "Liquidos");
    }

    public Liquidos(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoLiquido, double volumenLitros, String fechaVencimiento, int nivelPrioridad) {
        super(idLote, nombreInsumo, descripcionUso, pesoKg, listoParaEnvio, "Liquidos");
        this.tipoLiquido = tipoLiquido;
        this.volumenLitros = volumenLitros;
        this.fechaVencimiento = fechaVencimiento;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getTipoLiquido() { return tipoLiquido; }
    public double getVolumenLitros() { return volumenLitros; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public int getNivelPrioridad() { return nivelPrioridad; }

    public void setTipoLiquido(String tipoLiquido) { this.tipoLiquido = tipoLiquido; }
    public void setVolumenLitros(double volumenLitros) { this.volumenLitros = volumenLitros; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public void setNivelPrioridad(int nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }

    @Override
    public void registrarLote() {
        super.registrarLote();
        Scanner sc = ENTRADA;

        System.out.print("Ingrese el tipo de liquido: ");
        this.tipoLiquido = sc.nextLine();
        System.out.print("Ingrese el volumen en litros: ");
        this.volumenLitros = leerDouble(sc);
        System.out.print("Ingrese la fecha de vencimiento: ");
        this.fechaVencimiento = sc.nextLine();
        System.out.print("Ingrese el nivel de prioridad (1-5): ");
        this.nivelPrioridad = leerInt(sc);
    }

    @Override
    protected String datosEspecificos() {
        return "\nTipo de liquido: " + tipoLiquido
                + "\nVolumen: " + volumenLitros + " L"
                + "\nFecha de vencimiento: " + fechaVencimiento
                + "\nPrioridad: " + nivelPrioridad;
    }
}