package com.example.projectbd.PENGURUS;

import com.example.projectbd.CLASS.Club;
import com.example.projectbd.CLASS.ClubQuery;
import com.example.projectbd.CLASS.Kategori;
import com.example.projectbd.CLASS.Keanggotaan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.time.LocalDate;
import java.util.Optional;

public class menuCRUDclubController {

    //<editor-fold desc="FXML Declarations">
    // FXML Declarations for Klub Section
    @FXML private TableView<Club> tabelKlub;
    @FXML private TableColumn<Club, String> kolomIdKlub;
    @FXML private TableColumn<Club, String> kolomIdKlub1; // ID Kategori
    @FXML private TableColumn<Club, String> kolomNamaKlub;
    @FXML private TableColumn<Club, String> kolomDeskripsiKlub;
    @FXML private TableColumn<Club, String> kolomTahunBerdiri;
    @FXML private TextField fieldNama;
    @FXML private TextField fieldDeskripsi;
    @FXML private ComboBox<Kategori> fieldKategori;
    @FXML private TextField fieldTahun;
    @FXML private Button tombolTambah;
    @FXML private Button tombolUpdate;
    @FXML private Button tombolHapus;
    @FXML private Button tombolClear;

    // FXML Declarations for Anggota Section
    @FXML private TableView<Keanggotaan> tabelAnggota;
    @FXML private TableColumn<Keanggotaan, String> kolomIdAnggota;
    @FXML private TableColumn<Keanggotaan, String> kolomidClub;
    @FXML private TableColumn<Keanggotaan, String> kolomNrp;
    @FXML private TableColumn<Keanggotaan, String> kolomPeran;
    @FXML private TableColumn<Keanggotaan, LocalDate> kolomTanggalGabung;
    @FXML private TableColumn<Keanggotaan, String> kolomStatus;
    @FXML private TextField fieldNrp; // Renamed to fieldNrp for clarity
    @FXML private ComboBox<String> fieldStatusAnggota;
    @FXML private Button tombolUpdate1;
    @FXML private Button tombolClearAnggota;


    private final ClubQuery clubQuery = new ClubQuery();
    private final ObservableList<Club> clubList = FXCollections.observableArrayList();
    private final ObservableList<Keanggotaan> anggotaList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // 1. Setup UI components
        setupTabelKlub();
        setupTabelAnggota();
        setupComboBoxes();

        // 2. Setup listeners
        setupTableListeners();

        // 3. Load initial data
        loadClubData();
    }


    @FXML void onTambahClick() { handleTambahClub(); }
    @FXML void onUpdateClick() { handleUpdateClub(); }
    @FXML void onHapusClick() { handleHapusClub(); }
    @FXML void onBersihkanClick() { clearClubForm(); }
    @FXML void onUpdateAnggotaClick() { handleUpdateAnggota(); }
    @FXML void onBersihkanAnggotaClick() { clearAnggotaForm(); }

    private void setupTabelKlub() {
        kolomIdKlub.setCellValueFactory(new PropertyValueFactory<>("idClub"));
        kolomIdKlub1.setCellValueFactory(new PropertyValueFactory<>("id_Kategori"));
        kolomNamaKlub.setCellValueFactory(new PropertyValueFactory<>("namaClub"));
        kolomDeskripsiKlub.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        kolomTahunBerdiri.setCellValueFactory(new PropertyValueFactory<>("tahunBerdiri"));
        tabelKlub.setItems(clubList);
    }

    private void setupTabelAnggota() {
        kolomIdAnggota.setCellValueFactory(new PropertyValueFactory<>("idKeanggotaan"));
        kolomidClub.setCellValueFactory(new PropertyValueFactory<>("idClub"));
        kolomNrp.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        kolomPeran.setCellValueFactory(new PropertyValueFactory<>("peran"));
        kolomTanggalGabung.setCellValueFactory(new PropertyValueFactory<>("tanggalBergabung"));
        kolomStatus.setCellValueFactory(new PropertyValueFactory<>("statusKeanggotaan"));
        tabelAnggota.setItems(anggotaList);
    }

    private void setupComboBoxes() {
        fieldKategori.setItems(FXCollections.observableArrayList(clubQuery.getAllKategori()));
        fieldStatusAnggota.getItems().addAll("AKTIF", "NON AKTIF");
    }

    private void setupTableListeners() {
        tabelKlub.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    showClubDetails(newValue);
                    if (newValue != null) {
                        loadAnggotaData(newValue.getIdClub());
                    } else {
                        anggotaList.clear();
                    }
                });

        tabelAnggota.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAnggotaDetails(newValue));
    }

    private void loadClubData() {
        clubList.setAll(clubQuery.LihatClubPengurus());
        tabelKlub.refresh();
    }

    private void loadAnggotaData(String idClub) {
        anggotaList.setAll(clubQuery.getKeanggotaanByClub(idClub));
        tabelAnggota.refresh();
    }

    private void showClubDetails(Club club) {
        if (club != null) {
            fieldNama.setText(club.getNamaClub());
            fieldDeskripsi.setText(club.getDeskripsi());
            fieldTahun.setText(club.getTahunBerdiri());

            Kategori kategoriTerpilih = null;
            for (Kategori k : fieldKategori.getItems()) {
                if (k.getIdKategori().equals(club.getId_Kategori())) {
                    kategoriTerpilih = k;
                    break;
                }
            }
            fieldKategori.setValue(kategoriTerpilih);

        } else {
            clearClubForm();
        }
    }

    private void showAnggotaDetails(Keanggotaan anggota) {
        if (anggota != null) {
            fieldNrp.setText(anggota.getNrp());
            fieldStatusAnggota.setValue(anggota.getStatusKeanggotaan());
        } else {
            clearAnggotaForm();
        }
    }

    private void handleTambahClub() {
        Kategori selectedKategori = fieldKategori.getSelectionModel().getSelectedItem();
        String nama = fieldNama.getText();
        String deskripsi = fieldDeskripsi.getText();
        String tahun = fieldTahun.getText();

        if (selectedKategori == null || nama.isEmpty() || deskripsi.isEmpty() || tahun.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Tidak Lengkap", "Semua field harus diisi untuk menambah klub baru.");
            return;
        }

        String newClubId = clubQuery.getNextClubId();
        Club newClub = new Club(newClubId, selectedKategori.getIdKategori(), nama, deskripsi, tahun);

        if (clubQuery.tambahClub(newClub)) {
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Klub baru berhasil ditambahkan.");
            loadClubData();
            clearClubForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal menambahkan klub baru ke database.");
        }
    }

    private void handleUpdateClub() {
        Club selectedClub = tabelKlub.getSelectionModel().getSelectedItem();
        Kategori selectedKategori = fieldKategori.getSelectionModel().getSelectedItem();

        if (selectedClub == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih klub dari tabel yang ingin diupdate.");
            return;
        }

        String nama = fieldNama.getText();
        String deskripsi = fieldDeskripsi.getText();
        String tahun = fieldTahun.getText();

        if (selectedKategori == null || nama.isEmpty() || deskripsi.isEmpty() || tahun.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Tidak Lengkap", "Semua field harus diisi untuk mengupdate klub.");
            return;
        }

        // Update object Club yang sudah ada
        selectedClub.setId_Kategori(selectedKategori.getIdKategori());
        selectedClub.setNamaClub(nama);
        selectedClub.setDeskripsi(deskripsi);
        selectedClub.setTahunBerdiri(tahun);

        if (clubQuery.updateClub(selectedClub)) {
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data klub berhasil diperbarui.");
            loadClubData(); // Muat ulang data untuk merefresh tabel
            clearClubForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal memperbarui data klub.");
        }
    }

    private void handleHapusClub() {
        Club selectedClub = tabelKlub.getSelectionModel().getSelectedItem();
        if (selectedClub == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih klub yang ingin dihapus.");
            return;
        }

        Optional<ButtonType> result = showConfirmation("Konfirmasi Hapus", "Apakah Anda yakin ingin menghapus klub '" + selectedClub.getNamaClub() + "'? Menghapus klub juga akan menghapus semua data keanggotaan terkait.");

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (clubQuery.hapusClub(selectedClub.getIdClub())) {
                showAlert(Alert.AlertType.INFORMATION, "Sukses", "Klub '" + selectedClub.getNamaClub() + "' berhasil dihapus.");
                loadClubData();
                clearClubForm();
                anggotaList.clear(); // Bersihkan tabel anggota
            } else {
                showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal menghapus klub. Mungkin masih ada data terkait di tabel lain yang belum ditangani.");
            }
        }
    }

    private void handleUpdateAnggota() {
        Keanggotaan selectedAnggota = tabelAnggota.getSelectionModel().getSelectedItem();
        if (selectedAnggota == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih anggota yang ingin diperbarui.");
            return;
        }

        String nrpBaru = fieldNrp.getText(); // field ini untuk NRP
        String statusBaru = fieldStatusAnggota.getValue();

        if (nrpBaru.isEmpty() || statusBaru == null) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "NRP dan Status tidak boleh kosong.");
            return;
        }

        boolean success = clubQuery.updateStatusAnggota(selectedAnggota.getIdKeanggotaan(), nrpBaru, statusBaru);
        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data anggota berhasil diperbarui.");
            loadAnggotaData(selectedAnggota.getIdClub()); // Refresh tabel anggota
            clearAnggotaForm();
        } else {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal memperbarui data anggota.");
        }
    }
    //</editor-fold>

    //<editor-fold desc="UI Utility Methods">
    private void clearClubForm() {
        tabelKlub.getSelectionModel().clearSelection();
        fieldKategori.getSelectionModel().clearSelection();
        fieldNama.clear();
        fieldDeskripsi.clear();
        fieldTahun.clear();
    }

    private void clearAnggotaForm() {
        tabelAnggota.getSelectionModel().clearSelection();
        fieldNrp.clear();
        fieldStatusAnggota.getSelectionModel().clearSelection();
    }

    private Window getOwnerWindow() {
        return tabelKlub.getScene().getWindow();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(getOwnerWindow());
        alert.showAndWait();
    }

    private Optional<ButtonType> showConfirmation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(getOwnerWindow());
        return alert.showAndWait();
    }

}