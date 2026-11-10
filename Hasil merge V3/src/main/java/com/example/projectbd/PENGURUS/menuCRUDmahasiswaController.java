package com.example.projectbd.PENGURUS;

import com.example.projectbd.CLASS.Club;
import com.example.projectbd.CLASS.DatabaseConnection;
import com.example.projectbd.CLASS.Mahasiswa;
import com.example.projectbd.CLASS.MahasiswaQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class menuCRUDmahasiswaController {

    // FXML Elements Declarations
    @FXML private TextField searchBar;
    @FXML private TextField nimField;
    @FXML private TextField namaField;
    @FXML private ComboBox<String> statusComboBox;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private TextField addressField;
    @FXML private ComboBox<String> programComboBox;
    @FXML private TextField passwordField;

    // Changed to ComboBox

    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button addButton;
    @FXML private Button clearButton;
    @FXML private Button searchButton; // Added as per FXML

    @FXML private TableView<Mahasiswa> mahasiswaTable;
    @FXML private TableColumn<Mahasiswa, String> namaProdi;
    @FXML private TableColumn<Mahasiswa, String> namaProgram;
    @FXML private TableColumn<Mahasiswa, String> nrp;
    @FXML private TableColumn<Mahasiswa, String> nama;
    @FXML private TableColumn<Mahasiswa, String> email;
    @FXML private TableColumn<Mahasiswa, String> phone;
    @FXML private TableColumn<Mahasiswa, String> address;
    @FXML private TableColumn<Mahasiswa, String> status;
    @FXML private TableColumn<Mahasiswa, String> password;



    private ObservableList<Mahasiswa> masterData;
    private MahasiswaQuery mahasiswaQuery = new MahasiswaQuery();

    public void initialize() {
        ArrayList<String> programList = mahasiswaQuery.getNamaProgramList();
        ObservableList<String> statuses = FXCollections.observableArrayList(
                "pengurus","anggota"
        );
        statusComboBox.setItems(statuses);
        ObservableList<String> jurusans = FXCollections.observableArrayList(programList);
        programComboBox.setItems(jurusans);


        masterData = FXCollections.observableArrayList();

        namaProdi.setCellValueFactory(new PropertyValueFactory<>("namaProdi"));
        namaProgram.setCellValueFactory(new PropertyValueFactory<>("namaProgram"));
        nrp.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));

        loadMahasiswaData();
        doubleClick();

        updateButton.setDisable(true);
        deleteButton.setDisable(true);

    }

    @FXML
    void onSearchButtonClick()
    {
        handleSearch();
    }

    @FXML
    private void handleAdd(){
        String nrp = nimField.getText().toUpperCase();

        String namaMhs = namaField.getText();
        String programMhs = programComboBox.getValue();
        String emailMhs = emailField.getText();
        String phoneMhs = phoneField.getText();
        String addressMhs = addressField.getText();
        String passwordMhs = passwordField.getText();
        String statusMhs = statusComboBox.getValue();

        // Validasi apakah semua kolom terisi
        if (nrp.isEmpty() || namaMhs.isEmpty() || programMhs == null || emailMhs.isEmpty() ||
                phoneMhs.isEmpty() || addressMhs.isEmpty() || statusMhs == null || passwordMhs == null) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Mohon isi semua kolom yang diperlukan.");
            return;
        }
        String namaProdiOtomatis = mahasiswaQuery.getNamaProdiByProgram(programMhs);

        // Validasi PENTING: Pastikan prodi ditemukan
        if (namaProdiOtomatis == null) {
            showAlert(Alert.AlertType.ERROR, "Data Error!", "Program studi yang dipilih tidak memiliki relasi prodi yang valid di database.");
            return;
        }

        // Buat objek Mahasiswa baru dengan nama prodi otomatis dan password default
        // Pastikan kelas Mahasiswa memiliki konstruktor yang sesuai
        Mahasiswa newMahasiswa = new Mahasiswa(namaProdiOtomatis, programMhs, nrp, namaMhs, emailMhs, phoneMhs, addressMhs,passwordMhs ,statusMhs);

        boolean success = mahasiswaQuery.addMahasiswa(newMahasiswa);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Add Mahasiswa", "Mahasiswa berhasil ditambahkan!");
            loadMahasiswaData();
            handleClear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Add Mahasiswa", "Gagal menambahkan mahasiswa. Pastikan NRP belum terdaftar atau data valid.");
        }
    }


    @FXML
    private void handleUpdate(){
        String nrpToUpdate = nimField.getText();

        if (nrpToUpdate.isEmpty() || mahasiswaTable.getSelectionModel().getSelectedItem() == null) {
            showAlert(Alert.AlertType.ERROR, "Update Error", "Pilih mahasiswa dari tabel terlebih dahulu.");
            return;
        }

        String programMhs = programComboBox.getValue();
        String namaMhs = namaField.getText();
        String emailMhs = emailField.getText();
        String phoneMhs = phoneField.getText();
        String addressMhs = addressField.getText();
        String statusMhs = statusComboBox.getValue();
        String passwordMhs = passwordField.getText();

        // Validasi input tidak boleh kosong
        if (namaMhs.isEmpty() || programMhs == null || emailMhs.isEmpty() || phoneMhs.isEmpty() || addressMhs.isEmpty() || statusMhs == null || passwordMhs.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Form Error!", "Semua kolom harus diisi.");
            return;
        }

        // Dapatkan prodi secara otomatis dari program yang dipilih
        String namaProdiOtomatis = mahasiswaQuery.getNamaProdiByProgram(programMhs);
        if (namaProdiOtomatis == null) {
            showAlert(Alert.AlertType.ERROR, "Data Error!", "Program studi yang dipilih tidak valid.");
            return;
        }

        Mahasiswa updatedMahasiswa = new Mahasiswa(namaProdiOtomatis, programMhs,nrpToUpdate,namaMhs,emailMhs,phoneMhs,addressMhs,passwordMhs,statusMhs);

        boolean success = mahasiswaQuery.updateMahasiswa(updatedMahasiswa);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Update Success", "Data mahasiswa berhasil diperbarui.");
            loadMahasiswaData(); // Muat ulang data tabel
            handleClear(); // Bersihkan form
        } else {
            showAlert(Alert.AlertType.ERROR, "Update Error", "Gagal memperbarui data mahasiswa.");
        }

    }

    @FXML
    private void handleDelete(){
        String nrpToDelete = nimField.getText();


        if (mahasiswaTable.getSelectionModel().getSelectedItem() == null) {
            showAlert(Alert.AlertType.ERROR, "Delete Error", "Pilih mahasiswa dari tabel terlebih dahulu.");
            return;
        }

        boolean success = mahasiswaQuery.deleteMahasiswa(nrpToDelete);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Delete Success", "Data mahasiswa berhasil didelete.");
            loadMahasiswaData(); // Muat ulang data tabel
            handleClear(); // Bersihkan form
        } else {
            showAlert(Alert.AlertType.ERROR, "Delete Error", "Gagal delete data mahasiswa.");
        }
    }

    @FXML
    private void handleSearch() {
        String keyword = searchBar.getText().toLowerCase().trim();
        if (keyword.isEmpty()) {
            mahasiswaTable.setItems(masterData);
            return;
        }

        ObservableList<Mahasiswa> filteredList = FXCollections.observableArrayList();
        for (Mahasiswa mahasiswa : masterData) {
            if ((mahasiswa.getNrp() != null && mahasiswa.getNrp().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getNama() != null && mahasiswa.getNama().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getEmail() != null && mahasiswa.getEmail().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getPhone() != null && mahasiswa.getPhone().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getAddress() != null && mahasiswa.getAddress().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getStatus() != null && mahasiswa.getStatus().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getNamaProgram() != null && mahasiswa.getNamaProgram().toLowerCase().contains(keyword)) ||
                    (mahasiswa.getNamaProdi() != null && mahasiswa.getNamaProdi().toLowerCase().contains(keyword))) {
                filteredList.add(mahasiswa);
            }
        }
        mahasiswaTable.setItems(filteredList);
    }

    @FXML
    private void handleClear() {
        nimField.clear();
        namaField.clear();
        programComboBox.getSelectionModel().clearSelection();
        emailField.clear();
        phoneField.clear();
        addressField.clear();
        statusComboBox.getSelectionModel().clearSelection();
        passwordField.clear();

        programComboBox.setPromptText("Pilih program studi");
        statusComboBox.setPromptText("Pilih Status");

        nimField.setEditable(true);      // Aktifkan kembali field NRP agar bisa diisi
        addButton.setDisable(false);     // Aktifkan kembali tombol Add
        updateButton.setDisable(true);   // Nonaktifkan tombol Update karena tidak ada data yang dipilih
        deleteButton.setDisable(true);
    }

    private void loadMahasiswaData() {
        masterData.clear(); // Hapus data lama
        ArrayList<Mahasiswa> Mahasiswa = mahasiswaQuery.lihatMahasiswa(); // Panggil method dari ClubQuery
        masterData.addAll(Mahasiswa); // Tambahkan semua data klub yang ditemukan
        mahasiswaTable.setItems(masterData);
    }

    private void doubleClick() {
        mahasiswaTable.setOnMouseClicked(event -> {
            System.out.println("-> Tabel diklik! Jumlah klik: " + event.getClickCount());

            if (event.getClickCount() == 2) {
                System.out.println("--> Ini adalah double-click!");
                Mahasiswa selectedMahasiswa = mahasiswaTable.getSelectionModel().getSelectedItem();

                if (selectedMahasiswa != null) {
                    System.out.println("---> Baris dipilih: " + selectedMahasiswa.getNama());
                    isiForm(selectedMahasiswa);
                    System.out.println("----> Form seharusnya sudah terisi.");
                } else {
                    System.out.println("---> Tidak ada baris yang dipilih saat double-click.");
                }
            }
        });
    }
    private void isiForm(Mahasiswa mahasiswa) {
        // Isi form dengan data dari baris yang dipilih
        nimField.setText(mahasiswa.getNrp());
        namaField.setText(mahasiswa.getNama());
        programComboBox.setValue(mahasiswa.getNamaProgram());
        statusComboBox.setValue(mahasiswa.getStatus());
        emailField.setText(mahasiswa.getEmail());
        phoneField.setText(mahasiswa.getPhone());
        addressField.setText(mahasiswa.getAddress());
        passwordField.setText(mahasiswa.getPassword());

        // Membuat NRP tidak bisa diedit karena merupakan Primary Key
        nimField.setEditable(false);

        // Atur status tombol ke mode "Update"
        updateButton.setDisable(false);
        deleteButton.setDisable(false);
        addButton.setDisable(true);
    }
    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}