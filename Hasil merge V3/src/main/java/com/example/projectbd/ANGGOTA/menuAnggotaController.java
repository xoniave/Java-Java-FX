package com.example.projectbd.ANGGOTA;

import com.example.projectbd.CLASS.MahasiswaQuery;
import com.example.projectbd.CLASS.ShowAlert;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;

public class menuAnggotaController {
    @FXML
    private Label memberNameLabel;
    @FXML
    private StackPane contentArea;

    private MahasiswaQuery mhs = new MahasiswaQuery();
    private String nrp = "";

    @FXML
    public void initialize(String nrp) {
        setNamaPengurus(mhs.getNama(nrp));
        this.nrp = nrp;
        // Animasi awal bisa dihapus jika tidak diperlukan lagi
    }

    public void setNamaPengurus(String nama) {
        memberNameLabel.setText(nama);
    }

    @FXML
    private void onListClubClick() {
        // Mengirim NRP yang benar ke listClubController
        loadPage("/com/example/projectbd/listClub.fxml", this.nrp);
    }

    @FXML
    private void onProfileClick() {
        loadPage("/com/example/projectbd/profile.fxml", this.nrp);
    }

    @FXML
    private void onActivityRegistrationClick() {
        loadPage("/com/example/projectbd/activityRegistration.fxml", this.nrp);
    }

    @FXML
    private void onActivityAttendanceClick() {
        loadPage("/com/example/projectbd/activityAttendance.fxml", this.nrp);
    }

    @FXML
    private void onLogoutClick(ActionEvent event) { // Gunakan 'handleLogout' jika itu namanya di menuPengurusController
        System.out.println("Pengguna logout..."); // Untuk debugging
        try {
            // 1. Dapatkan Stage (jendela) aplikasi yang sedang aktif dari tombol yang diklik
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close(); // Tutup jendela saat ini

            // 2. Muat halaman login.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectbd/login.fxml")); // SESUAIKAN PATH INI!
            Parent root = loader.load();

            // 3. Buat Stage baru untuk halaman login
            Stage loginStage = new Stage();
            loginStage.setTitle("Login Aplikasi Club Mahasiswa"); // Atur judul jendela login
            loginStage.setScene(new Scene(root));
            loginStage.show(); // Tampilkan jendela login yang baru

        } catch (IOException e) {
            e.printStackTrace();
            // Tampilkan alert jika gagal memuat halaman login
            ShowAlert SA = new ShowAlert(); // Pastikan Anda sudah menginisialisasi ShowAlert di controller ini jika belum
            SA.showAlert(Alert.AlertType.ERROR, "Error Logout", "Gagal kembali ke halaman login.");
        }
    }

    // Method generik yang sudah diperbaiki
    private void loadPage(String fxmlFile, String nrp) {
        try {
            ShowAlert SA = new ShowAlert();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node page = loader.load();

            // Cek tipe controller dengan cerdas menggunakan instanceof
            Object controller = loader.getController();

            if (nrp == null || nrp.isEmpty()) {
                SA.showAlert(getOwnerWindow(), Alert.AlertType.ERROR, "Error Pemuatan", "NRP mahasiswa tidak ditemukan. Harap login ulang.");
                return;
            }

            if (controller instanceof profileController && nrp != null) {
                ((profileController) controller).initialize(nrp);
            } else if (controller instanceof listClubController && nrp != null) {
                ((listClubController) controller).initialize(nrp);
            } else if (controller instanceof activityRegistrationController && nrp != null) {
                ((activityRegistrationController) controller).setNRPLoggedIn(nrp);
            }else if (controller instanceof  activityAttendanceController && nrp != null) {
                ((activityAttendanceController) controller).setNRPLoggedIn(nrp);
            }
            // Anda bisa menambahkan 'else if' untuk controller lain di sini

            // Animasi transisi halaman
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), contentArea);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setOnFinished(event -> {
                contentArea.getChildren().setAll(page);
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), contentArea);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.play();
            });
            fadeOut.play();

        } catch (IOException e) {
            e.printStackTrace();
            Label errorLabel = new Label("Gagal memuat halaman: " + fxmlFile);
            contentArea.getChildren().setAll(errorLabel);
        }
    }

    private Window getOwnerWindow() {
        if (contentArea != null && contentArea.getScene() != null) {
            return contentArea.getScene().getWindow();
        }
        return null;
    }
}