package com.example.projectbd.ANGGOTA;

import com.example.projectbd.CLASS.Club;
import com.example.projectbd.CLASS.KegiatanClub;
import com.example.projectbd.CLASS.KegiatanClubQuery;
import com.example.projectbd.CLASS.ShowAlert; // Pastikan import ini benar, sesuai lokasi kelas ShowAlert Anda

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert; // Diperlukan untuk Alert.AlertType
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window; // Diperlukan untuk tipe Window owner

import java.time.LocalDate;
import java.util.ArrayList;

public class activityRegistrationController {

    @FXML
    private TextField activityKeywordSearchField;
    @FXML
    private Button btnSearchActivity;
    @FXML
    private Button btnRegisterActivity;

    @FXML
    private TableView<KegiatanClub> activityTableView; // Tabel untuk semua kegiatan
    @FXML
    private TableColumn<KegiatanClub, String> idKegiatanClubColumn;
    @FXML
    private TableColumn<KegiatanClub, String> namaKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, LocalDate> tanggalKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, String> jenisKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, String> clubKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, String> lokasiKegiatanColumn;

    // FXML elements untuk tabel kegiatan yang sudah didaftar oleh mahasiswa
    @FXML
    private TableView<KegiatanClub> registeredParticipantsTableView;
    @FXML
    private TableColumn<KegiatanClub, String> registeredIdKegiatanClubColumn;
    @FXML
    private TableColumn<KegiatanClub, String> registeredNamaKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, LocalDate> registeredTanggalKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, LocalDate> registeredTanggalDaftarColumn; // Tanggal daftar dari tabel partisipasi
    @FXML
    private TableColumn<KegiatanClub, String> registeredPeranColumn; // Peran partisipasi dari tabel partisipasi
    @FXML
    private TableColumn<KegiatanClub, String> registeredClubKegiatanColumn; // Nama club dari kegiatan yang didaftar

    private ObservableList<KegiatanClub> masterActivityData = FXCollections.observableArrayList(); // Data semua kegiatan
    private ObservableList<KegiatanClub> registeredActivitiesData = FXCollections.observableArrayList(); // Data kegiatan yang sudah didaftar
    private KegiatanClubQuery kegiatanClubQuery = new KegiatanClubQuery(); // Objek untuk interaksi database

    private ShowAlert showAlertUtil;
    private String nrpLoggedIn;

    @FXML
    public void initialize() {
        // Inisialisasi kolom untuk tabel 'Semua Kegiatan' (activityTableView)
        idKegiatanClubColumn.setCellValueFactory(new PropertyValueFactory<>("idKegiatanClub"));
        namaKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaKegiatan"));
        tanggalKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("tanggalKegiatan"));
        jenisKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaJenisKegiatan")); // Menampilkan nama jenis
        clubKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaClub")); // Menampilkan nama club
        lokasiKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("keteranganLokasi")); // Menampilkan keterangan lokasi

        // Inisialisasi kolom untuk tabel 'Kegiatan yang Sudah Didaftar' (registeredParticipantsTableView)
        registeredIdKegiatanClubColumn.setCellValueFactory(new PropertyValueFactory<>("idKegiatanClub"));
        registeredNamaKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaKegiatan"));
        registeredTanggalKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("tanggalKegiatan"));
        registeredTanggalDaftarColumn.setCellValueFactory(new PropertyValueFactory<>("tanggalDaftar")); // Mengambil dari properti baru di KegiatanClub
        registeredPeranColumn.setCellValueFactory(new PropertyValueFactory<>("peranPartisipasi")); // Mengambil dari properti baru di KegiatanClub
        registeredClubKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaClub")); // Mengambil nama club dari KegiatanClub


        showAlertUtil = new ShowAlert();

        loadAllActivities();
    }

    @FXML
    void onSearchButtonClick()
    {
        handleSearchActivity();
    }

    @FXML
    void onDaftarButtonClick()
    {
        handleRegisterActivity();
    }

    private Window getOwnerWindow() {
        if (activityTableView != null && activityTableView.getScene() != null) {
            return activityTableView.getScene().getWindow();
        }
        return null; // Menangani kasus di mana UI belum sepenuhnya diinisialisasi
    }


    private void loadAllActivities() {
        masterActivityData.clear();
        ArrayList<KegiatanClub> activities = kegiatanClubQuery.getAllKegiatanClub();
        masterActivityData.addAll(activities);
        activityTableView.setItems(masterActivityData);
    }


    @FXML
    private void handleSearchActivity() {
        String keyword = activityKeywordSearchField.getText().toLowerCase().trim();
        if (keyword.isEmpty()) {
            activityTableView.setItems(masterActivityData); // Tampilkan semua jika kata kunci kosong
            return;
        }

        ObservableList<KegiatanClub> filteredList = FXCollections.observableArrayList();
        for (KegiatanClub kc : masterActivityData) {
            // Cek apakah kata kunci cocok dengan salah satu atribut yang relevan
            // Tambahkan pengecekan null untuk menghindari NullPointerException
            if ((kc.getNamaKegiatan() != null && kc.getNamaKegiatan().toLowerCase().contains(keyword)) ||
                    (kc.getNamaClub() != null && kc.getNamaClub().toLowerCase().contains(keyword)) ||
                    (kc.getNamaJenisKegiatan() != null && kc.getNamaJenisKegiatan().toLowerCase().contains(keyword)) ||
                    (kc.getKeteranganLokasi() != null && kc.getKeteranganLokasi().toLowerCase().contains(keyword))) {
                filteredList.add(kc);
            }
        }
        activityTableView.setItems(filteredList);
    }

    private void loadRegisteredActivitiesForStudent() {
        if (nrpLoggedIn == null || nrpLoggedIn.isEmpty()) {
            // NRP belum diset, tidak bisa memuat kegiatan yang didaftar
            registeredActivitiesData.clear();
            registeredParticipantsTableView.setItems(registeredActivitiesData);
            return;
        }
        registeredActivitiesData.clear();
        ArrayList<KegiatanClub> registeredActivities = kegiatanClubQuery.getKegiatanRegisteredByStudent(nrpLoggedIn);
        registeredActivitiesData.addAll(registeredActivities);
        registeredParticipantsTableView.setItems(registeredActivitiesData);
    }


    @FXML
    private void handleRegisterActivity() {
        KegiatanClub selectedActivity = activityTableView.getSelectionModel().getSelectedItem();
        Window ownerWindow = getOwnerWindow();

        if (selectedActivity != null) {
            if (nrpLoggedIn == null || nrpLoggedIn.isEmpty()) {
                showAlertUtil.showAlert(ownerWindow, Alert.AlertType.ERROR, "Error", "NRP mahasiswa yang login tidak ditemukan. Harap login ulang.");
                return;
            }

            LocalDate today = LocalDate.now();
            if (selectedActivity.getTanggalKegiatan().isBefore(today)) { //
                showAlertUtil.showAlert(ownerWindow, Alert.AlertType.WARNING, "Pendaftaran Gagal", "Anda tidak dapat mendaftar kegiatan yang sudah terlewat: " + selectedActivity.getNamaKegiatan()); //
                return; //
            }

            if (kegiatanClubQuery.isMahasiswaRegistered(nrpLoggedIn, selectedActivity.getIdKegiatanClub())) {
                showAlertUtil.showAlert(ownerWindow, Alert.AlertType.WARNING, "Peringatan", "Anda sudah terdaftar di kegiatan ini.");
                return;
            }

            boolean success = kegiatanClubQuery.daftarKegiatan(nrpLoggedIn, selectedActivity.getIdKegiatanClub());

            if (success) {
                showAlertUtil.showAlert(ownerWindow, Alert.AlertType.INFORMATION, "Sukses", "Berhasil mendaftar ke kegiatan: " + selectedActivity.getNamaKegiatan());
                loadRegisteredActivitiesForStudent(); // Muat ulang daftar kegiatan yang sudah didaftar setelah sukses
            } else {
                showAlertUtil.showAlert(ownerWindow, Alert.AlertType.ERROR, "Gagal", "Gagal mendaftar ke kegiatan: " + selectedActivity.getNamaKegiatan());
            }
        } else {
            showAlertUtil.showAlert(ownerWindow, Alert.AlertType.WARNING, "Peringatan", "Pilih kegiatan yang ingin didaftar terlebih dahulu.");
        }
    }

    public void setNRPLoggedIn(String nrp) {
        this.nrpLoggedIn = nrp;
        if (kegiatanClubQuery != null) {
            loadRegisteredActivitiesForStudent();
        }
    }
}