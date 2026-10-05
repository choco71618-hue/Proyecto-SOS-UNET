package Implementacion;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Suministro.SuministroEmergencia;
public class Main extends Application {

    public static void main(String[] args) {
        if (args.length > 0 && "--consola".equals(args[0])) {
            consola();
            return;
        }
        Application.launch(Main.class, args);
    }

    @Override
    public void start(Stage escenario) throws Exception {
        FXMLLoader cargador = new FXMLLoader(Main.class.getResource("interfaz.fxml"));
        Scene escena = new Scene(cargador.load());

        escenario.setTitle("Centro de Acopio UNET");
        escenario.setScene(escena);
        escenario.setMinWidth(1080);
        escenario.setMinHeight(680);
        escenario.show();
    }

    static int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Entrada no valida, intente de nuevo: ");
            }
        }
    }


    static void consola() {
        Principal.inicializar();

        System.out.println("=============================================");
        System.out.println("  CENTRO DE ACOPIO CENTRAL - UNET");
        System.out.println("  Simulacion de envios de suministros");
        System.out.println("=============================================");

        suministrosCriticos();
        gestionDelCicloDeVida();
        sectorAlimentos();
        inventarioGeneral();

        System.out.println("");
        System.out.println("========== FIN DE LA JORNADA ==========");
    }

    static void suministrosCriticos() {
        System.out.println("");
        System.out.println("--- A) SUMINISTROS CRITICOS ---");

        SuministroEmergencia reservaInicial = new SuministroEmergencia();
        SuministroEmergencia lotePrioritario = new SuministroEmergencia("MED003", "Kits Primeros Auxilios", "Vendas y alcohol", 5.2, true, "Medicina");

        SuministroEmergencia donacionReciente = new SuministroEmergencia();
        donacionReciente.registrarLote();
        donacionReciente.mostrarFichaLogistica();

        System.out.println("Ficha de la reserva inicial sin datos cargados:");
        reservaInicial.mostrarFichaLogistica();

        System.out.println("Cambiando el estado de envio de lotePrioritario...");
        lotePrioritario.alternarEstadoEnvio();
        lotePrioritario.mostrarFichaLogistica();
    }

    static void gestionDelCicloDeVida() {
        System.out.println("");
        System.out.println("--- B) GESTION DEL CICLO DE VIDA ---");

        SuministroEmergencia envioInmediato = new SuministroEmergencia();
        SuministroEmergencia pedidoEspecial = new SuministroEmergencia("ALI003", "Raciones de Emergencia", "Raciones listas para consumir", 10.5, false, "Alimentos");

        envioInmediato.registrarLote();
        envioInmediato.mostrarFichaLogistica();
        pedidoEspecial.mostrarFichaLogistica();

        System.out.println("Rompiendo las referencias del Stack para que el GC libere el Heap...");
        envioInmediato = null;
        pedidoEspecial = null;

        System.out.println("envioInmediato ahora es: " + envioInmediato);
        System.out.println("pedidoEspecial ahora es: " + pedidoEspecial);
    }

    static void sectorAlimentos() {
        System.out.println("");
        System.out.println("--- C) SECTOR DE ALIMENTOS (ARREGLO FIJO) ---");

        SuministroEmergencia[] sectorAlimentos = new SuministroEmergencia[3];

        for (int i = 0; i < sectorAlimentos.length; i++) {
            System.out.println("Registro del lote " + (i + 1) + " del sector:");
            sectorAlimentos[i] = new SuministroEmergencia();
            sectorAlimentos[i].registrarLote();
        }

        for (int i = 0; i < sectorAlimentos.length; i++) {
            System.out.println("Lote #" + (i + 1) + " del sector de alimentos:");
            sectorAlimentos[i].mostrarFichaLogistica();
        }
    }

    static void inventarioGeneral() {
        System.out.println("");
        System.out.println("--- D) INVENTARIO GENERAL (ARREGLO DINAMICO) ---");

        Scanner sc = SuministroEmergencia.ENTRADA;
        System.out.print("Ingrese el numero total de lotes que ingresan en la jornada: ");
        int cantidadLotes = leerEntero(sc);

        SuministroEmergencia[] inventarioGeneral = new SuministroEmergencia[cantidadLotes];

        for (int i = 0; i < inventarioGeneral.length; i++) {
            System.out.println("Registro del lote " + (i + 1) + " del inventario general:");
            inventarioGeneral[i] = new SuministroEmergencia();
            inventarioGeneral[i].registrarLote();
        }

        for (int i = 0; i < inventarioGeneral.length; i++) {
            System.out.println("Lote #" + (i + 1) + " del inventario general:");
            inventarioGeneral[i].mostrarFichaLogistica();
        }

        System.out.print("Ingrese el numero de lote que desea alternar (1 a " + cantidadLotes + "): ");
        int indice = leerEntero(sc);

        if (indice >= 1 && indice <= cantidadLotes) {
            System.out.println("Alternando el estado de envio del lote #" + indice + "...");
            inventarioGeneral[indice - 1].alternarEstadoEnvio();
            System.out.println("Ficha actualizada:");
            inventarioGeneral[indice - 1].mostrarFichaLogistica();
        } else {
            System.out.println("El indice ingresado no existe en el inventario.");
        }
    }
}
