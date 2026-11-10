package com.example.projectbd.MAINMENU;

import com.example.projectbd.ANGGOTA.menuAnggotaController;
import com.example.projectbd.CLASS.MahasiswaQuery;
import com.example.projectbd.CLASS.ShowAlert;
import com.example.projectbd.PENGURUS.menuPengurusController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.IOException;


public class LoginController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private ToggleButton anggotaToggle;

    @FXML
    private ToggleButton pengurusToggle;

    @FXML
    private TextField nrpField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    ShowAlert SA = new ShowAlert();
    MahasiswaQuery mhs = new MahasiswaQuery();

    @FXML
    void login() {
        Window window = mainPane.getScene().getWindow();

        String nrp = nrpField.getText().toUpperCase();
        String password = passwordField.getText();
        String role = pengurusToggle.isSelected() ? "pengurus" : "anggota";

        if (nrp.isEmpty() || password.isEmpty()) {
            SA.showAlert(window, Alert.AlertType.WARNING,"Eror", "Nrp dan Password tidak boleh kosong.");
            return;
        }

        if(mhs.checkNrp(nrp,password,role))
        {
            SA.showAlert(window, Alert.AlertType.INFORMATION ,"Sukses", "Login berhasil sebagai " + role + "!");
            if (role.equals("pengurus")){
                try {
                    //JADI BEDA NYA INI SAMA PARENT BIASA, KALO NDE SINI ITU FXML DI BIKIN TERPISAH
                    FXMLLoader fxmlpengurus = new FXMLLoader(getClass().getResource("/com/example/projectbd/menuPengurus.fxml"));
                    // LALU DI SINI DI LOAD KE PARENT
                    Parent pengurusMenu = fxmlpengurus.load();
                    mainPane.getScene().setRoot(pengurusMenu);
                    // MESKI SUDAH LOAD KITA GK AKAN KEHILANGAN AKSES KE MENU PENGURUS KARENA SUDAH DI PISAH VARIABLE LAIN
                    menuPengurusController menuPengurusController = fxmlpengurus.getController();

                    if (menuPengurusController != null) {
                        menuPengurusController.initialize(nrp);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                try {
                    //JADI BEDA NYA INI SAMA PARENT BIASA, KALO NDE SINI ITU FXML DI BIKIN TERPISAH
                    FXMLLoader fxmlanggota = new FXMLLoader(getClass().getResource("/com/example/projectbd/menuAnggota.fxml"));
                    // LALU DI SINI DI LOAD KE PARENT
                    Parent anggotaMenu = fxmlanggota.load();
                    mainPane.getScene().setRoot(anggotaMenu);
                    // MESKI SUDAH LOAD KITA GK AKAN KEHILANGAN AKSES KE MENU PENGURUS KARENA SUDAH DI PISAH VARIABLE LAIN
                    menuAnggotaController anggotaController = fxmlanggota.getController();

                    if (anggotaController != null) {
                        anggotaController.initialize(nrp);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("Login gagal. Nrp, password, atau role salah.");
            SA.showAlert(window, Alert.AlertType.ERROR, "Gagal", "Nrp, password, atau role tidak sesuai.");
        }

        nrpField.setText("");
        passwordField.setText("");
    }

    @FXML
    void switchToAnggota() {
        mainPane.getStyleClass().remove("pengurus-theme");
        mainPane.getStyleClass().add("anggota-theme");
    }

    @FXML
    void switchToPengurus() {
        mainPane.getStyleClass().remove("anggota-theme");
    }
}