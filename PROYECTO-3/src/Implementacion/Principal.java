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

// agregar fecha de vencimiento
// agregar nivel de prioridad de cada Suministro
// clase Transporte
// calcular que en un envio esta listo para transporte si se llena el peso de un transporte
// cual es el transporte proximo que va a salir
// reporte detallado del lote, y saber a A DONDE SE ENVIO, en que medio de transporte
// PLACA DE TRANSPORTE
// usuarios, Colaborador, Tranporte, VerificadorDeCarga 
// ropa categorizada de util o no util
// PASAR REGISTROS DE CARGANDO LOTE A LOTE EN ENVIO