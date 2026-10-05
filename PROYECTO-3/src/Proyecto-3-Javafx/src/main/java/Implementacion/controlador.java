package Implementacion;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import Suministro.Alimentos;
import Suministro.Colaborador;
import Suministro.Herramientas;
import Suministro.Liquidos;
import Suministro.Medicamentos;
import Suministro.Personas;
import Suministro.SuministroEmergencia;
import Suministro.Transporte;
import Suministro.VerificadorDeCarga;

public class controlador {


    private static final String TXT = "#0F172A";
    private static final String TXT_SUAVE = "#64748B";
    private static final String TXT_APAGADO = "#A8B4C4";
    private static final String NAVY = "#002B49";
    private static final String NAVY_600 = "#1A365D";
    private static final String VERDE = "#2E7D32";
    private static final String ROJO = "#DC2626";


    private static final String CELDA =
            "-fx-padding: 0 10; -fx-font-size: 13px; -fx-text-fill: " + TXT + ";";
    private static final String CELDA_MONO =
            "-fx-padding: 0 10; -fx-font-family: Consolas; -fx-font-size: 12.5px; -fx-text-fill: " + NAVY_600 + ";";
    private static final String CELDA_VACIA =
            "-fx-padding: 0 10; -fx-font-size: 13px; -fx-text-fill: " + TXT_APAGADO + ";";
    private static final String CELDA_NUMERO =
            "-fx-padding: 0 10; -fx-font-family: Consolas; -fx-font-size: 12.5px; -fx-text-fill: " + NAVY_600 + "; -fx-alignment: center-right;";
    private static final String PASTILLA_BASE =
            "-fx-background-radius: 999; -fx-padding: 4 10; -fx-font-size: 11.5px; -fx-font-weight: 600;";

    private static final String NAV_NORMAL =
            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-border-radius: 8; "
                    + "-fx-padding: 11 12; -fx-alignment: center-left; -fx-font-size: 13px; "
                    + "-fx-font-family: 'Segoe UI'; -fx-text-fill: " + TXT + "; -fx-cursor: hand;";
    private static final String NAV_SELECCION =
            "-fx-background-color: " + NAVY + "; -fx-border-color: transparent; -fx-border-radius: 8; "
                    + "-fx-padding: 11 12; -fx-alignment: center-left; -fx-font-size: 13px; "
                    + "-fx-font-family: 'Segoe UI'; -fx-text-fill: #FFFFFF; -fx-cursor: hand; "
                    + "-fx-effect: dropshadow(gaussian, #0F172A26, 12, 0.12, 0, 4);";
    private static final String ICONO_NORMAL = "-fx-font-size: 15px; -fx-text-fill: " + NAVY_600 + ";";
    private static final String ICONO_SELECCION = "-fx-font-size: 15px; -fx-text-fill: #10B981;";

    private static final String NOTA_OK =
            "-fx-font-size: 11.5px; -fx-text-fill: " + VERDE + ";";
    private static final String NOTA_ALERTA =
            "-fx-font-size: 11.5px; -fx-text-fill: #B45309;";



    private static final String[] TIPOS = {"Alimentos", "Medicamentos", "Liquidos", "Herramientas"};
    private static final String[] PRIORIDADES = {"1 - baja", "2", "3 - media", "4", "5 - máxima"};
    private static final String[] ROLES = {"Colaborador", "Verificador de carga"};
    private static final String SIN_DATO = "—";


    @FXML private ImageView logoCorp;
    @FXML private Label usuarioActivo;


    @FXML private ToggleButton btnNavRecepcion;
    @FXML private ToggleButton btnNavInventario;
    @FXML private ToggleButton btnNavDonantes;
    @FXML private ToggleButton btnNavReportes;
    @FXML private StackPane pilaSecciones;
    @FXML private ScrollPane paginaRecepcion;
    @FXML private StackPane paginaInventario;
    @FXML private ScrollPane paginaDonantes;
    @FXML private VBox paginaReportes;

    @FXML private Label metricaPeso;
    @FXML private Label metricaPesoNota;
    @FXML private Label metricaLotes;
    @FXML private Label metricaLotesNota;
    @FXML private Label metricaCapacidad;
    @FXML private Label metricaCapacidadNota;


    @FXML private TextField txtIdLote;
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPeso;
    @FXML private TextField txtDescripcion;
    @FXML private Label lblDetalle;
    @FXML private TextField txtDetalle;
    @FXML private Label lblVencimiento;
    @FXML private TextField txtVencimiento;
    @FXML private Label lblCantidad;
    @FXML private TextField txtCantidad;
    @FXML private ComboBox<String> cmbPrioridad;
    @FXML private TextField txtResponsable;
    @FXML private TextField txtCedula;
    @FXML private CheckBox chkListo;


    @FXML private ComboBox<String> cmbTransporte;
    @FXML private Label loteEnFoco;
    @FXML private Label loteEnFocoNota;
    @FXML private Label siguientePlaca;
    @FXML private Label siguientePlacaNota;


    @FXML private TableView<SuministroEmergencia> tablaLotes;
    @FXML private TableColumn<SuministroEmergencia, String> colId;
    @FXML private TableColumn<SuministroEmergencia, String> colNombre;
    @FXML private TableColumn<SuministroEmergencia, String> colTipo;
    @FXML private TableColumn<SuministroEmergencia, Double> colPeso;
    @FXML private TableColumn<SuministroEmergencia, String> colEstado;
    @FXML private TableColumn<SuministroEmergencia, String> colPlaca;
    @FXML private TableColumn<SuministroEmergencia, String> colDestino;
    @FXML private VBox vacioLotes;

    @FXML private TextField txtNombreDonante;
    @FXML private TextField txtCedulaDonante;
    @FXML private ComboBox<String> cmbRol;
    @FXML private TextField txtArea;
    @FXML private CheckBox chkPuedeAprobar;
    @FXML private TableView<Personas> tablaPersonas;
    @FXML private TableColumn<Personas, String> colPersonaNombre;
    @FXML private TableColumn<Personas, String> colPersonaCedula;
    @FXML private TableColumn<Personas, String> colPersonaRol;
    @FXML private TableColumn<Personas, String> colPersonaDetalle;


    @FXML private TextArea txtReporte;
    @FXML private Label lineaEstado;

    private final ObservableList<SuministroEmergencia> filas = FXCollections.observableArrayList();
    private final ObservableList<Personas> personas = FXCollections.observableArrayList();

    private ToggleGroup grupoNav;
    private SuministroEmergencia loteSeleccionado;


    @FXML
    public void initialize() {
        if (Principal.gestor == null) {
            Principal.inicializar();
        }

        prepararNavegacion();
        prepararFormularios();
        prepararTablas();
        cargarLogoCorporativo();

        txtReporte.setText(generarReporteGeneral());
        refrescarTodo();

        irARecepcion();
    }

    private void prepararNavegacion() {
        grupoNav = new ToggleGroup();
        grupoNav.getToggles().addAll(btnNavRecepcion, btnNavInventario, btnNavDonantes, btnNavReportes);
        grupoNav.selectedToggleProperty().addListener((obs, previo, nuevo) -> pintarNav());

        conIcono(btnNavRecepcion, "\uD83D\uDCE6");
        conIcono(btnNavInventario, "\uD83D\uDCCA");
        conIcono(btnNavDonantes, "\uD83D\uDC65");
        conIcono(btnNavReportes, "\uD83D\uDCC8");
    }

    private void conIcono(ToggleButton boton, String simbolo) {
        Label icono = new Label(simbolo);
        icono.setStyle(ICONO_NORMAL);
        boton.setGraphic(icono);
    }

    private void pintarNav() {
        for (ToggleButton boton : new ToggleButton[]{btnNavRecepcion, btnNavInventario,
                btnNavDonantes, btnNavReportes}) {
            boolean activo = boton.isSelected();
            boton.setStyle(activo ? NAV_SELECCION : NAV_NORMAL);
            if (boton.getGraphic() instanceof Label) {
                ((Label) boton.getGraphic()).setStyle(activo ? ICONO_SELECCION : ICONO_NORMAL);
            }
        }
    }

    private void prepararFormularios() {
        cmbTipo.getItems().setAll(TIPOS);
        cmbTipo.getSelectionModel().selectFirst();
        cmbTipo.valueProperty().addListener((obs, previo, nuevo) -> ajustarCamposPorTipo(nuevo));

        cmbPrioridad.getItems().setAll(PRIORIDADES);
        cmbPrioridad.getSelectionModel().select(2);

        cmbRol.getItems().setAll(ROLES);
        cmbRol.getSelectionModel().selectFirst();
        cmbRol.valueProperty().addListener((obs, previo, nuevo) -> {
            boolean verificador = "Verificador de carga".equals(nuevo);
            chkPuedeAprobar.setVisible(verificador);
            txtArea.setDisable(verificador);
            if (verificador) {
                txtArea.clear();
            }
        });

        ajustarCamposPorTipo(cmbTipo.getValue());

        for (TextField campo : new TextField[]{txtIdLote, txtNombre, txtPeso, txtDescripcion,
                txtDetalle, txtVencimiento, txtCantidad, txtResponsable, txtCedula,
                txtNombreDonante, txtCedulaDonante, txtArea}) {
            aroDeFoco(campo);
        }
    }


    private void aroDeFoco(TextField campo) {
        String base = campo.getStyle();
        campo.focusedProperty().addListener((obs, previo, foco) ->
                campo.setStyle(foco ? base + " -fx-border-color: " + NAVY_600 + ";"
                        : base));
    }


    private void ajustarCamposPorTipo(String tipo) {
        if (tipo == null) {
            return;
        }
        switch (tipo) {
            case "Medicamentos":
                lblDetalle.setText("Principio activo");
                txtDetalle.setPromptText("Paracetamol");
                break;
            case "Liquidos":
                lblDetalle.setText("Tipo de líquido");
                txtDetalle.setPromptText("Agua");
                break;
            case "Herramientas":
                lblDetalle.setText("Tipo de herramienta");
                txtDetalle.setPromptText("Herramienta manual");
                break;
            default:
                lblDetalle.setText("Tipo de alimento");
                txtDetalle.setPromptText("Granos");
                break;
        }

        boolean tieneVencimiento = !"Herramientas".equals(tipo);
        lblVencimiento.setVisible(tieneVencimiento);
        txtVencimiento.setVisible(tieneVencimiento);

        boolean tieneCantidad = "Liquidos".equals(tipo) || "Herramientas".equals(tipo);
        lblCantidad.setVisible(tieneCantidad);
        txtCantidad.setVisible(tieneCantidad);
        if ("Herramientas".equals(tipo)) {
            lblCantidad.setText("Unidades");
            txtCantidad.setPromptText("15");
        } else {
            lblCantidad.setText("Volumen (L)");
            txtCantidad.setPromptText("20.0");
        }
    }

    private void prepararTablas() {
        colId.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getIdLote()));
        colNombre.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getNombreInsumo()));
        colTipo.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getTipoAyuda()));
        colPeso.setCellValueFactory(f -> new SimpleObjectProperty<>(f.getValue().getPesoKg()));
        colEstado.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getEstado()));
        colPlaca.setCellValueFactory(f -> new SimpleStringProperty(placaDe(f.getValue())));
        colDestino.setCellValueFactory(f -> new SimpleStringProperty(destinoDe(f.getValue())));

        colId.setCellFactory(c -> celdaTexto(false));
        colPlaca.setCellFactory(c -> celdaTexto(false));
        colNombre.setCellFactory(c -> celdaTexto(true));
        colTipo.setCellFactory(c -> celdaTexto(true));
        colDestino.setCellFactory(c -> celdaTexto(true));
        colPeso.setCellFactory(c -> celdaNumero());
        colEstado.setCellFactory(c -> celdaPastilla());

        tablaLotes.setItems(filas);
        tablaLotes.getSelectionModel().selectedItemProperty()
                .addListener((obs, previo, nuevo) -> seleccionarLote(nuevo));

        colPersonaNombre.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getNombre()));
        colPersonaCedula.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getCedula()));
        colPersonaRol.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getRol()));
        colPersonaDetalle.setCellValueFactory(f -> new SimpleStringProperty(detalleDe(f.getValue())));

        colPersonaNombre.setCellFactory(c -> celdaTextoPersona(true));
        colPersonaCedula.setCellFactory(c -> celdaTextoPersona(false));
        colPersonaRol.setCellFactory(c -> celdaTextoPersona(true));
        colPersonaDetalle.setCellFactory(c -> celdaTextoPersona(true));

        tablaPersonas.setItems(personas);
    }

    private TableCell<SuministroEmergencia, String> celdaTexto(boolean suave) {
        return new TableCell<>() {
            @Override
            protected void updateItem(String valor, boolean vacia) {
                super.updateItem(valor, vacia);
                if (vacia || valor == null || valor.isBlank()) {
                    setText(SIN_DATO);
                    setStyle(celdaVacia(suave));
                } else {
                    setText(valor);
                    setStyle(suave ? CELDA : CELDA_MONO);
                }
            }
        };
    }

    private TableCell<SuministroEmergencia, Double> celdaNumero() {
        return new TableCell<>() {
            @Override
            protected void updateItem(Double valor, boolean vacia) {
                super.updateItem(valor, vacia);
                if (vacia || valor == null) {
                    setText(SIN_DATO);
                    setStyle(celdaVacia(true));
                } else {
                    setText(String.format(Locale.US, "%.1f", valor));
                    setStyle(CELDA_NUMERO);
                }
            }
        };
    }

    private TableCell<SuministroEmergencia, String> celdaPastilla() {
        return new TableCell<>() {
            private final Label pastilla = new Label();

            @Override
            protected void updateItem(String valor, boolean vacia) {
                super.updateItem(valor, vacia);
                setStyle("-fx-padding: 0 8;");
                if (vacia || valor == null) {
                    setGraphic(null);
                    return;
                }
                pastilla.setText(valor);
                pastilla.setStyle(PASTILLA_BASE + colorDeEstado(valor));
                setGraphic(pastilla);
            }
        };
    }

    private TableCell<Personas, String> celdaTextoPersona(boolean suave) {
        return new TableCell<>() {
            @Override
            protected void updateItem(String valor, boolean vacia) {
                super.updateItem(valor, vacia);
                if (vacia || valor == null || valor.isBlank()) {
                    setText(SIN_DATO);
                    setStyle(celdaVacia(suave));
                } else {
                    setText(valor);
                    setStyle(suave ? CELDA : CELDA_MONO);
                }
            }
        };
    }

    private static String celdaVacia(boolean suave) {
        return suave ? CELDA_VACIA : "-fx-padding: 0 10; -fx-font-family: Consolas; "
                + "-fx-font-size: 12.5px; -fx-text-fill: " + TXT_APAGADO + ";";
    }

    private static String colorDeEstado(String estado) {
        switch (estado) {
            case "Cargando":
                return "-fx-background-color: #FFF7E6; -fx-text-fill: #B45309;";
            case "Listo":
                return "-fx-background-color: #E7F7F0; -fx-text-fill: " + VERDE + ";";
            case "EnTransito":
                return "-fx-background-color: #E8F0FE; -fx-text-fill: #1D4ED8;";
            case "Entregado":
                return "-fx-background-color: #F1F5F9; -fx-text-fill: #475569;";
            default:
                return "-fx-background-color: #E8EEF4; -fx-text-fill: " + NAVY_600 + ";";
        }
    }

    @FXML
    private void irARecepcion() {
        irA(btnNavRecepcion);
        escribirEstado("Escribe el lote que acaba de llegar y pulsa Registrar entradas.", false);
    }

    @FXML
    private void irAInventario() {
        irA(btnNavInventario);
        if (filas.isEmpty()) {
            escribirEstado("No hay lotes todavía. Registra el primero en Recepción.", true);
        }
    }

    @FXML
    private void irADonantes() {
        irA(btnNavDonantes);
        escribirEstado("Registra a quién entrega y quién verifica la carga.", false);
    }

    @FXML
    private void irAReportes() {
        irA(btnNavReportes);
        txtReporte.setText(generarReporteGeneral());
        escribirEstado("Reporte actualizado con el estado actual del acopio.", false);
    }

    private void irA(ToggleButton origen) {
        origen.setSelected(true);
        mostrar(paginaDe(origen));
    }

    private Node paginaDe(ToggleButton boton) {
        if (boton == btnNavRecepcion) {
            return paginaRecepcion;
        }
        if (boton == btnNavInventario) {
            return paginaInventario;
        }
        if (boton == btnNavDonantes) {
            return paginaDonantes;
        }
        return paginaReportes;
    }

    private void mostrar(Node pagina) {
        for (Node nodo : pilaSecciones.getChildren()) {
            nodo.setVisible(nodo == pagina);
        }
    }

    @FXML
    private void registrarEntrada() {
        irARecepcion();

        String id = limpio(txtIdLote);
        String nombre = limpio(txtNombre);
        String descripcion = limpio(txtDescripcion);
        String detalle = limpio(txtDetalle);
        String vencimiento = limpio(txtVencimiento);
        String cantidad = limpio(txtCantidad);
        String tipo = cmbTipo.getValue();

        if (id.isEmpty() || nombre.isEmpty()) {
            escribirEstado("Falta el id del lote o el nombre del material.", true);
            return;
        }
        for (SuministroEmergencia existente : Principal.gestor.getLotes()) {
            if (id.equalsIgnoreCase(existente.getIdLote())) {
                escribirEstado("El lote " + id + " ya está registrado.", true);
                return;
            }
        }

        double peso;
        try {
            peso = Double.parseDouble(limpio(txtPeso).replace(',', '.'));
            if (peso <= 0) {
                throw new NumberFormatException();
            }
        } catch (RuntimeException e) {
            escribirEstado("El peso debe ser un número mayor que cero. Ejemplo: 12.5", true);
            return;
        }

        SuministroEmergencia lote = construirLote(tipo, id, nombre, descripcion, peso,
                detalle, vencimiento, cantidad);

        Principal.gestor.registrarLote(lote);
        registrarResponsableSiHaceFalta();

        limpiarCampos();
        refrescarTodo();

        irAInventario();
        seleccionarEnTabla(lote);
        escribirEstado("Lote " + id + " registrado en acopio.", false);
    }

    private SuministroEmergencia construirLote(String tipo, String id, String nombre,
                                               String descripcion, double peso, String detalle,
                                               String vencimiento, String cantidad) {
        boolean listo = chkListo.isSelected();
        int prioridad = prioridadSeleccionada();
        String especifico = detalle.isEmpty() ? "Sin especificar" : detalle;

        if ("Medicamentos".equals(tipo)) {
            return new Medicamentos(id, nombre, descripcion, peso, listo, especifico,
                    "Dosis registrada", vencimiento, prioridad);
        }
        if ("Liquidos".equals(tipo)) {
            return new Liquidos(id, nombre, descripcion, peso, listo, especifico,
                    numeroSeguro(cantidad), vencimiento, prioridad);
        }
        if ("Herramientas".equals(tipo)) {
            return new Herramientas(id, nombre, descripcion, peso, listo, especifico,
                    (int) Math.round(numeroSeguro(cantidad)), prioridad);
        }
        return new Alimentos(id, nombre, descripcion, peso, listo, especifico, vencimiento, prioridad);
    }

    private double numeroSeguro(String texto) {
        try {
            return Double.parseDouble(texto.replace(',', '.'));
        } catch (RuntimeException e) {
            return 0;
        }
    }

    private int prioridadSeleccionada() {
        int indice = cmbPrioridad.getSelectionModel().getSelectedIndex();
        return indice < 0 ? 3 : indice + 1;
    }

    private void registrarResponsableSiHaceFalta() {
        String nombre = limpio(txtResponsable);
        String cedula = limpio(txtCedula);
        if (nombre.isEmpty() || cedula.isEmpty()) {
            return;
        }
        for (Personas persona : Principal.gestor.getUsuarios()) {
            if (cedula.equals(persona.getCedula())) {
                return;
            }
        }
        Principal.gestor.registrarUsuario(new Colaborador(nombre, cedula, "Acopio"));
    }

    @FXML
    private void limpiarCampos() {
        txtIdLote.clear();
        txtNombre.clear();
        txtDescripcion.clear();
        txtDetalle.clear();
        txtPeso.clear();
        txtCantidad.clear();
        txtVencimiento.clear();
        txtResponsable.clear();
        txtCedula.clear();
        chkListo.setSelected(false);
        cmbTipo.getSelectionModel().selectFirst();
        cmbPrioridad.getSelectionModel().select(2);
        escribirEstado("Formulario de recepción vacío.", false);
    }


    @FXML
    private void cargarEnTransporte() {
        SuministroEmergencia lote = loteSeleccionado;
        if (lote == null) {
            irAInventario();
            escribirEstado("Selecciona un lote en Inventario / stock.", true);
            return;
        }

        Transporte transporte = transporteSeleccionado();
        if (transporte == null) {
            escribirEstado("No hay unidades de transporte en la flota.", true);
            return;
        }

        if (!Principal.gestor.asignarLoteATransporte(lote, transporte)) {
            escribirEstado(transporte.getPlaca() + " no tiene capacidad para " + lote.getIdLote() + ".", true);
            return;
        }

        refrescarTodo();
        escribirEstado(lote.getIdLote() + " cargado en " + transporte.getPlaca() + ".", false);
    }

    @FXML
    private void avanzarEstado() {
        SuministroEmergencia lote = loteSeleccionado;
        if (lote == null) {
            irAInventario();
            escribirEstado("Selecciona un lote en Inventario / stock.", true);
            return;
        }
        if ("Entregado".equals(lote.getEstado())) {
            escribirEstado(lote.getIdLote() + " ya está entregado.", false);
            return;
        }

        lote.avanzarEstado();
        refrescarTodo();
        escribirEstado(lote.getIdLote() + " pasó a " + estadoLegible(lote.getEstado()) + ".", false);
    }

    private static String estadoLegible(String estado) {
        return "EnTransito".equals(estado) ? "En tránsito" : estado;
    }



    @FXML
    private void anadirPersona() {
        String nombre = limpio(txtNombreDonante);
        String cedula = limpio(txtCedulaDonante);
        if (nombre.isEmpty() || cedula.isEmpty()) {
            escribirEstado("Falta el nombre o la cédula de la persona.", true);
            return;
        }
        for (Personas persona : Principal.gestor.getUsuarios()) {
            if (cedula.equals(persona.getCedula())) {
                escribirEstado("La cédula " + cedula + " ya está registrada.", true);
                return;
            }
        }

        if ("Verificador de carga".equals(cmbRol.getValue())) {
            Principal.gestor.registrarUsuario(
                    new VerificadorDeCarga(nombre, cedula, chkPuedeAprobar.isSelected()));
        } else {
            Principal.gestor.registrarUsuario(
                    new Colaborador(nombre, cedula, limpio(txtArea)));
        }

        txtNombreDonante.clear();
        txtCedulaDonante.clear();
        txtArea.clear();
        chkPuedeAprobar.setSelected(false);

        refrescarTodo();
        escribirEstado(nombre + " se añadió al equipo del acopio.", false);
    }



    @FXML
    private void exportarReporte() {
        txtReporte.setText(generarReporteGeneral());

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Exportar reporte del acopio");
        chooser.setInitialFileName("reporte-acopio-unet.txt");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Texto", "*.txt"));

        Window ventana = tablaLotes.getScene() == null ? null : tablaLotes.getScene().getWindow();
        File destino = chooser.showSaveDialog(ventana);
        if (destino == null) {
            escribirEstado("Exportación cancelada.", false);
            return;
        }

        try (PrintWriter salida = new PrintWriter(destino, StandardCharsets.UTF_8)) {
            salida.print(txtReporte.getText());
        } catch (IOException e) {
            escribirEstado("No se pudo escribir el reporte: " + e.getMessage(), true);
            return;
        }

        escribirEstado("Reporte guardado en " + destino.getName() + ".", false);
    }

    private String generarReporteGeneral() {
        SuministroEmergencia[] lotes = Principal.gestor.getLotes();
        Transporte[] flota = Principal.gestor.getFlota();
        Personas[] usuarios = Principal.gestor.getUsuarios();

        StringBuilder sb = new StringBuilder();
        String regla = "=".repeat(70);

        sb.append("CENTRO DE ACOPIO UNET - REPORTE DE JORNADA\n");
        sb.append("Universidad Nacional Experimental del Táchira\n");
        sb.append(regla).append('\n');

        sb.append("LOTES REGISTRADOS (").append(lotes.length).append(")\n");
        sb.append(regla).append('\n');
        if (lotes.length == 0) {
            sb.append("  Sin lotes registrados.\n");
        }
        for (SuministroEmergencia lote : lotes) {
            sb.append('\n').append(lote.generarReporte()).append('\n');
        }

        sb.append('\n').append(regla).append('\n');
        sb.append("FLOTA DE TRANSPORTE\n");
        sb.append(regla).append('\n');
        if (flota.length == 0) {
            sb.append("  Sin unidades de transporte.\n");
        }
        for (Transporte t : flota) {
            sb.append(String.format("  %-8s %-8s %-22s %7.1f / %-7.1f kg  %s%n",
                    t.getPlaca(), t.getTipo(), t.getDestino(),
                    t.pesoActual(), t.getPesoMaximo(), t.getEstado()));
        }

        sb.append('\n').append(regla).append('\n');
        sb.append("EQUIPO DEL ACOPIO\n");
        sb.append(regla).append('\n');
        if (usuarios.length == 0) {
            sb.append("  Sin personas registradas.\n");
        }
        for (Personas p : usuarios) {
            sb.append(String.format("  %-22s %-12s %s%n", p.getNombre(), p.getCedula(), p.getRol()));
        }

        sb.append('\n').append(regla).append('\n');
        sb.append(String.format("Peso total en acopio: %.1f kg%n", Principal.gestor.getPesoTotal()));
        return sb.toString();
    }



    private void refrescarTodo() {
        refrescarMetricas();
        refrescarTablaLotes();
        refrescarPersonas();
        refrescarDespacho();
        refrescarUsuario();
        if (paginaReportes.isVisible()) {
            txtReporte.setText(generarReporteGeneral());
        }
    }

    private void refrescarMetricas() {
        SuministroEmergencia[] lotes = Principal.gestor.getLotes();
        double peso = Principal.gestor.getPesoTotal();

        metricaPeso.setText(String.format(Locale.US, "%.1f kg", peso));
        metricaPesoNota.setText(lotes.length == 1
                ? "peso registrado en 1 lote"
                : "peso registrado en " + lotes.length + " lotes");

        int listos = 0;
        for (SuministroEmergencia lote : lotes) {
            if (lote.isListoParaEnvio()) {
                listos++;
            }
        }
        metricaLotes.setText(String.valueOf(lotes.length));
        metricaLotesNota.setText(lotes.length == 0
                ? "materiales en el inventario"
                : listos + " listos para envío");

        double maxima = 0;
        double ocupada = 0;
        for (Transporte t : Principal.gestor.getFlota()) {
            maxima += t.getPesoMaximo();
            ocupada += t.pesoActual();
        }
        double libre = Math.max(0, maxima - ocupada);
        metricaCapacidad.setText(String.format(Locale.US, "%.1f kg", libre));
        metricaCapacidadNota.setText(libre <= 0
                ? "sin espacio en la flota"
                : "kg disponibles en la flota");
        metricaCapacidadNota.setStyle(libre <= 0 ? NOTA_ALERTA : NOTA_OK);
    }

    private void refrescarTablaLotes() {
        SuministroEmergencia seleccionada = loteSeleccionado;
        filas.setAll(Principal.gestor.getLotes());

        vacioLotes.setVisible(filas.isEmpty());
        tablaLotes.setVisible(!filas.isEmpty());

        if (seleccionada != null) {
            seleccionarEnTabla(seleccionada);
        } else if (!filas.isEmpty()) {
            seleccionarEnTabla(filas.get(0));
        }
    }

    private void refrescarPersonas() {
        personas.setAll(Principal.gestor.getUsuarios());
    }

    private void refrescarDespacho() {
        Transporte[] flota = Principal.gestor.getFlota();
        ObservableList<String> opciones = FXCollections.observableArrayList();
        for (Transporte t : flota) {
            opciones.add(t.getPlaca() + "   " + t.getTipo() + " a " + t.getDestino());
        }

        String previo = cmbTransporte.getValue();
        cmbTransporte.setItems(opciones);
        if (previo != null && opciones.contains(previo)) {
            cmbTransporte.setValue(previo);
        } else if (!opciones.isEmpty()) {
            cmbTransporte.getSelectionModel().selectFirst();
        }

        Transporte siguiente = Principal.gestor.transporteProximoASalir();
        siguientePlaca.setText(siguiente == null ? SIN_DATO : siguiente.getPlaca());
        siguientePlacaNota.setText(siguiente == null
                ? "flota sin unidades disponibles"
                : siguiente.getTipo() + " a " + siguiente.getDestino());
        siguientePlacaNota.setStyle(siguiente == null ? NOTA_ALERTA : NOTA_OK);
    }

    private void refrescarUsuario() {
        Personas[] usuarios = Principal.gestor.getUsuarios();
        usuarioActivo.setText(usuarios.length == 0
                ? "Sin responsable asignado"
                : usuarios[usuarios.length - 1].getNombre());
    }

    private void seleccionarEnTabla(SuministroEmergencia lote) {
        int indice = filas.indexOf(lote);
        if (indice >= 0) {
            tablaLotes.getSelectionModel().select(indice);
            tablaLotes.scrollTo(Math.max(0, indice - 1));
        }
    }

    private void seleccionarLote(SuministroEmergencia lote) {
        loteSeleccionado = lote;
        if (lote == null) {
            loteEnFoco.setText(SIN_DATO);
            loteEnFocoNota.setText("selecciona una fila del inventario");
            loteEnFocoNota.setStyle(NOTA_OK);
            return;
        }
        loteEnFoco.setText(lote.getIdLote());
        loteEnFocoNota.setText(lote.getNombreInsumo() + " · " + estadoLegible(lote.getEstado()));
        loteEnFocoNota.setStyle(NOTA_OK);
    }

    private Transporte transporteSeleccionado() {
        int indice = cmbTransporte.getSelectionModel().getSelectedIndex();
        Transporte[] flota = Principal.gestor.getFlota();
        return indice >= 0 && indice < flota.length ? flota[indice] : null;
    }

    private static String limpio(TextField campo) {
        return campo.getText() == null ? "" : campo.getText().trim();
    }

    private static String placaDe(SuministroEmergencia lote) {
        return lote.getTransporteAsignado() == null ? "" : lote.getTransporteAsignado().getPlaca();
    }

    private static String destinoDe(SuministroEmergencia lote) {
        return lote.getTransporteAsignado() == null ? "" : lote.getTransporteAsignado().getDestino();
    }

    private static String detalleDe(Personas persona) {
        if (persona instanceof Colaborador) {
            String area = ((Colaborador) persona).getArea();
            return area == null || area.isEmpty() ? SIN_DATO : area;
        }
        if (persona instanceof VerificadorDeCarga) {
            return ((VerificadorDeCarga) persona).isPuedeAprobar()
                    ? "Autorizado para aprobar carga"
                    : "Sin autorización de carga";
        }
        return persona.getRol();
    }

    private void escribirEstado(String mensaje, boolean error) {
        lineaEstado.setText(mensaje);
        lineaEstado.setStyle("-fx-font-family: Consolas; -fx-font-size: 12px; -fx-text-fill: "
                + (error ? ROJO : TXT_SUAVE) + ";");
    }

    private void cargarLogoCorporativo() {
        logoCorp.setVisible(false);
        logoCorp.setImage(null);

        String ruta = System.getProperty("unet.logo");
        if (ruta == null || ruta.isBlank()) {
            return;
        }

        try {
            File archivo = new File(ruta);
            URL url = archivo.exists() ? archivo.toURI().toURL() : null;
            Image imagen = url == null ? null : new Image(url.toExternalForm());
            if (imagen != null && !imagen.isError()) {
                logoCorp.setImage(imagen);
                logoCorp.setVisible(true);
            }
        } catch (IOException | RuntimeException e) {
            escribirEstado("No se pudo cargar el logo desde " + ruta + ".", true);
        }
    }
}