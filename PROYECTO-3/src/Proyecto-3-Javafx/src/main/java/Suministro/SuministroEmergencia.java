package Suministro;

import java.util.Scanner;

public class SuministroEmergencia {

    public static final Scanner ENTRADA = new Scanner(System.in);

    private String idLote = "";
    private String nombreInsumo = "";
    private String descripcionUso = "";
    private double pesoKg = 0;
    private boolean listoParaEnvio = false;
    private String tipoAyuda = "";
    private String estado = "Registrado";
    private Transporte transporteAsignado = null;

    public SuministroEmergencia() {
        this.idLote = "";
        this.nombreInsumo = "";
        this.descripcionUso = "";
        this.pesoKg = 0.0;
        this.listoParaEnvio = false;
        this.tipoAyuda = "";
        this.estado = "Registrado";
    }

    public SuministroEmergencia(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoAyuda) {
        this.idLote = idLote;
        this.nombreInsumo = nombreInsumo;
        this.descripcionUso = descripcionUso;
        this.pesoKg = pesoKg;
        this.listoParaEnvio = listoParaEnvio;
        this.tipoAyuda = tipoAyuda;
        this.estado = "Registrado";
    }

    public String getIdLote () { return idLote; }
    public String getNombreInsumo () { return nombreInsumo; }
    public String getDescripcionUso () { return descripcionUso; }
    public double getPesoKg () { return pesoKg; }
    public boolean isListoParaEnvio () { return listoParaEnvio; }
    public String getTipoAyuda () { return tipoAyuda; }
    public String getEstado () { return estado; }
    public Transporte getTransporteAsignado () { return transporteAsignado; }

    public void setNombreInsumo (String nombreInsumo) { this.nombreInsumo = nombreInsumo; }
    public void setIdLote (String idLote) { this.idLote = idLote; }
    public void setDescripcionUso (String descripcionUso) { this.descripcionUso = descripcionUso; }
    public void setPesoKg (double pesoKg) { this.pesoKg = pesoKg; }
    public void setListoParaEnvio (boolean listoParaEnvio) { this.listoParaEnvio = listoParaEnvio; }
    public void setTipoAyuda (String tipoAyuda) { this.tipoAyuda = tipoAyuda; }
    public void setEstado (String estado) { this.estado = estado; }

    protected static double leerDouble (Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Entrada no valida, intente de nuevo: ");
            }
        }
    }

    protected static int leerInt (Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada no valida, intente de nuevo: ");
            }
        }
    }

    public void registrarLote () {
        Scanner sc = ENTRADA;

        System.out.println("");
        System.out.println("--- REGISTRO DE LOTE ---");
        System.out.print("Ingrese el id del lote: ");
        this.idLote = sc.nextLine();
        System.out.print("Ingrese el nombre del insumo: ");
        this.nombreInsumo = sc.nextLine();
        System.out.print("Ingrese la descripcion de uso: ");
        this.descripcionUso = sc.nextLine();
        System.out.print("Ingrese el peso en kg: ");
        this.pesoKg = leerDouble(sc);
        System.out.print("Ingrese el tipo de ayuda (Medicina, Alimentos, Herramientas): ");
        this.tipoAyuda = sc.nextLine();
        System.out.print("¿Listo para envio? (Si/No): ");
        String respuesta = sc.nextLine();
        this.listoParaEnvio = respuesta.equalsIgnoreCase("Si");

        System.out.println("Lote registrado correctamente.");
    }

    public void asignarTransporte (Transporte transporteAsignado) {
        this.transporteAsignado = transporteAsignado;
    }

    public void avanzarEstado () {
        if (this.estado.equals("Registrado")) {
            this.estado = "Cargando";
        } else if (this.estado.equals("Cargando")) {
            this.estado = "Listo";
        } else if (this.estado.equals("Listo")) {
            this.estado = "EnTransito";
        } else if (this.estado.equals("EnTransito")) {
            this.estado = "Entregado";
        }
    }

    protected String datosEspecificos () {
        return "";
    }

    public String generarReporte () {
        String reporte = "========== FICHA LOGISTICA =========="
                + "\nId lote: " + getIdLote()
                + "\nTipo de ayuda: " + getTipoAyuda()
                + "\nNombre del insumo: " + getNombreInsumo()
                + "\nDescripcion de uso: " + getDescripcionUso()
                + "\nPeso: " + getPesoKg() + " kg"
                + "\nListo para envio: " + (isListoParaEnvio() ? "Si" : "No")
                + "\nEstado: " + getEstado()
                + datosEspecificos();

        if (transporteAsignado != null) {
            reporte += "\nMedio de transporte: " + transporteAsignado.getTipo()
                    + "\nPlaca: " + transporteAsignado.getPlaca()
                    + "\nDestino: " + transporteAsignado.getDestino();
        } else {
            reporte += "\nMedio de transporte: sin asignar"
                    + "\nPlaca: sin asignar"
                    + "\nDestino: sin asignar";
        }

        reporte += "\n=====================================";
        return reporte;
    }

    public void mostrarFichaLogistica () {
        System.out.println("");
        System.out.println(generarReporte());
    }

    public void alternarEstadoEnvio () {
        this.listoParaEnvio = !this.listoParaEnvio;
    }
}