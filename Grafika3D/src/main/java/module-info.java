module com.example.grafika3d {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grafika3d to javafx.fxml;
    exports com.example.grafika3d;
}