module com.example.proyecto3javafx {
    requires javafx.controls;
    requires javafx.fxml;

    exports Implementacion;
    opens Implementacion to javafx.fxml;
}