package Implementacion;

import Suministro.SuministroEmergencia;
import Suministro.Alimentos;
import Suministro.Medicamentos;
import Suministro.Liquidos;
import Suministro.Transporte;
import Suministro.Personas;
import Suministro.Colaborador;
import Suministro.VerificadorDeCarga;

public class GestorControlTransporte {
    private SuministroEmergencia[] lotes;
    private SuministroEmergencia[] sectorAlimentos;
    private Transporte[] flota;
    private Personas[] usuarios;

    public GestorControlTransporte() {
        this.lotes = new SuministroEmergencia[0];
        this.sectorAlimentos = new SuministroEmergencia[3];
        this.flota = new Transporte[0];
        this.usuarios = new Personas[0];
    }

    public GestorControlTransporte(SuministroEmergencia[] lotes, SuministroEmergencia[] sectorAlimentos) {
        this.lotes = lotes;
        this.sectorAlimentos = sectorAlimentos;
        this.flota = new Transporte[0];
        this.usuarios = new Personas[0];
    }

    private SuministroEmergencia[] agregar(SuministroEmergencia[] arr, SuministroEmergencia nuevo) {
        SuministroEmergencia[] ampliado = new SuministroEmergencia[arr.length + 1];
        System.arraycopy(arr, 0, ampliado, 0, arr.length);
        ampliado[arr.length] = nuevo;
        return ampliado;
    }

    private Transporte[] agregar(Transporte[] arr, Transporte nuevo) {
        Transporte[] ampliado = new Transporte[arr.length + 1];
        System.arraycopy(arr, 0, ampliado, 0, arr.length);
        ampliado[arr.length] = nuevo;
        return ampliado;
    }

    private Personas[] agregar(Personas[] arr, Personas nuevo) {
        Personas[] ampliado = new Personas[arr.length + 1];
        System.arraycopy(arr, 0, ampliado, 0, arr.length);
        ampliado[arr.length] = nuevo;
        return ampliado;
    }

    public void registrarLote(SuministroEmergencia lote) {
        lotes = agregar(lotes, lote);
    }

    public void registrarTransporte(Transporte transporte) {
        flota = agregar(flota, transporte);
    }

    public void registrarUsuario(Personas usuario) {
        usuarios = agregar(usuarios, usuario);
    }

    public void cargarDatosSemilla() {
        this.lotes = new SuministroEmergencia[] {
            new Alimentos("ALI001", "Arroz", "Saco de 5kg para cocina", 25.0, true, "Granos", "2027-01-10", 2),
            new Medicamentos("MED001", "Paracetamol", "Cajas para aliviar el dolor", 3.5, true, "Paracetamol", "500mg", "2028-05-20", 1),
            new Liquidos("LIQ001", "Agua Mineral", "Botellas de 1L", 14.5, false, "Agua", 20.0, "2027-08-01", 1)
        };

        this.flota = new Transporte[] {
            new Transporte("PBX-123", "Camion", "Hospital Central", 40.0, 1),
            new Transporte("YV-777", "Avion", "Refugio Norte", 120.0, 2),
            new Transporte("AB-450", "Coche", "Ambulatorio Sur", 20.0, 3)
        };

        this.usuarios = new Personas[] {
            new Colaborador("Maria Perez", "V-12345678", "Logistica"),
            new VerificadorDeCarga("Jose Ramirez", "V-87654321", true)
        };
    }

    public boolean asignarLoteATransporte(SuministroEmergencia lote, Transporte transporte) {
        if (transporte.estaLleno()) {
            return false;
        }

        transporte.agregarLote(lote);

        if (lote.getEstado().equals("Registrado")) {
            lote.avanzarEstado();
        }

        if (transporte.estaLleno()) {
            SuministroEmergencia[] carga = transporte.getCarga();
            for (int i = 0; i < carga.length; i++) {
                carga[i].setListoParaEnvio(true);
                carga[i].setEstado("Listo");
            }
        }

        return true;
    }

    public Transporte transporteProximoASalir() {
        Transporte proximo = null;
        for (int i = 0; i < flota.length; i++) {
            Transporte t = flota[i];
            if (t.getEstado().equals("EnTransito") || t.getEstado().equals("Entregado")) {
                continue;
            }
            if (proximo == null || t.getOrdenSalida() < proximo.getOrdenSalida()) {
                proximo = t;
            }
        }
        return proximo;
    }

    public void avanzarCarga() {
        for (int i = 0; i < lotes.length; i++) {
            lotes[i].avanzarEstado();
        }
    }

    public String reporteLote(SuministroEmergencia lote) {
        return lote.generarReporte();
    }

    public void mostrarLotes() {
        for (int i = 0; i < lotes.length; i++) {
            System.out.println("Lote #" + (i + 1));
            lotes[i].mostrarFichaLogistica();
        }
    }

    public double getPesoTotal() {
        double total = 0;
        for (int i = 0; i < lotes.length; i++) {
            total += lotes[i].getPesoKg();
        }
        return total;
    }

    public void demoLogistica() {
        System.out.println("");
        System.out.println("--- DEMO LOGISTICA ---");

        Transporte proximo = transporteProximoASalir();
        System.out.println("Transporte proximo a salir: " + (proximo != null ? proximo.getPlaca() : "ninguno"));

        if (proximo != null) {
            for (int i = 0; i < lotes.length; i++) {
                boolean cargado = asignarLoteATransporte(lotes[i], proximo);
                if (cargado) {
                    System.out.println("Lote " + lotes[i].getIdLote() + " cargado. Peso actual: " + proximo.pesoActual() + " kg");
                } else {
                    System.out.println("El transporte " + proximo.getPlaca() + " esta lleno, el lote " + lotes[i].getIdLote() + " no entra.");
                }
            }
            System.out.println("Estado del transporte: " + proximo.getEstado());
            System.out.println("Lleno: " + (proximo.estaLleno() ? "Si" : "No"));
        }

        if (lotes.length > 0) {
            System.out.println("");
            System.out.println(reporteLote(lotes[0]));
        }
    }

    public SuministroEmergencia[] getLotes() { return lotes; }
    public SuministroEmergencia[] getSectorAlimentos() { return sectorAlimentos; }
    public Transporte[] getFlota() { return flota; }
    public Personas[] getUsuarios() { return usuarios; }
}