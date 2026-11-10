module com.example.projectbd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.projectbd to javafx.fxml;
    exports com.example.projectbd.MAINMENU;
    opens com.example.projectbd.MAINMENU to javafx.fxml;
    exports com.example.projectbd.PENGURUS;
    opens com.example.projectbd.PENGURUS to javafx.fxml;
    exports com.example.projectbd.ANGGOTA;
    opens com.example.projectbd.ANGGOTA to javafx.fxml;
    exports com.example.projectbd.CLASS;
    opens com.example.projectbd.CLASS to javafx.fxml;
}