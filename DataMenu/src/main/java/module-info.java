module com.example.datamenu {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datamenu to javafx.fxml;
    exports com.example.datamenu;
}