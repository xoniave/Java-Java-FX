package com.example.projectbd.PENGURUS;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class menuPengurusController {

    // 1. Variabel disesuaikan dengan fx:id="contentArea" di FXML
    @FXML
    private StackPane contentArea;

    @FXML
    private Label namaPengurusLabel;

    @FXML
    private Button crudClubButton;
    @FXML
    private Button crudKegiatanButton;
    @FXML
    private Button crudMahasiswaButton;
    @FXML
    private Button crudattendance;

    @FXML
    private Button logoutButton;

    MahasiswaQuery mhs = new MahasiswaQuery();


    @FXML
    public void initialize(String email) {
        setNamaPengurus(mhs.getNama(email));

        if (contentArea != null) {
            contentArea.setOpacity(0);
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(1.5), contentArea);
            fadeIn.setToValue(1);
            fadeIn.play();
        }
    }

    // Method untuk mengatur teks pada label nama pengurus
    public void setNamaPengurus(String nama) {
        if (namaPengurusLabel != null) {
            namaPengurusLabel.setText(nama);
        }
    }


    @FXML
    void handleCrudClub(ActionEvent event) {

        loadPage("/com/example/projectbd/menuCRUDclub.fxml", null);
    }

    @FXML
    void handleCrudKegiatan(ActionEvent event) {
        loadPage("/com/example/projectbd/menuKegiatanClub.fxml", null);
    }

    @FXML
    void handleCrudMahasiswa(ActionEvent event) {
        System.out.println("Navigasi ke menu CRUD Mahasiswa...");
        loadPage("/com/example/projectbd/menuCRUDmahasiswa.fxml", null);
    }

    @FXML
    void handleCrudattendance()
    {
        loadPage("/com/example/projectbd/menuCRUDAttendance.fxml", null);
    }

    @FXML
    void handleLogout(ActionEvent event) {
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

    private void loadPage(String fxmlFile, Object data) {
        if (contentArea == null) {
            System.err.println("Error: contentArea is null. Cannot load page.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node page = loader.load();

            // Terapkan animasi fade-out pada konten lama
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), contentArea);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setOnFinished(e -> {
                // Ganti konten setelah fade-out selesai
                contentArea.getChildren().setAll(page);

                // Terapkan animasi fade-in pada konten baru
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
}