package Implementacion;

public class Principal {

    public static GestorControlTransporte gestor;

    public static void main(String[] args) {
        // Interfaz.App.main(args);
    }

    public static void inicializar() {
        gestor = new GestorControlTransporte();
        gestor.cargarDatosSemilla();
    }
}

