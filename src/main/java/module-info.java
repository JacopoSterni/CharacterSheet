module com.example.charactersheet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires commons.io;

    opens com.example.charactersheet to javafx.fxml;
    exports com.example.charactersheet;
}