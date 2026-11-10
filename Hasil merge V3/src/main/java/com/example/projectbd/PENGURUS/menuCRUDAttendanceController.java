package com.example.projectbd.PENGURUS;

import com.example.projectbd.CLASS.KegiatanClubQuery;
import com.example.projectbd.CLASS.DaftarPartisipasi;
import com.example.projectbd.CLASS.ShowAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent; // For MouseEvent on double-click
import javafx.beans.property.SimpleStringProperty; // Required for SimpleStringProperty

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional; // For Confirmation Dialog

// Perubahan nama kelas controller sesuai FXML
public class menuCRUDAttendanceController {

    @FXML private TextField searchBar;
    @FXML private Button btnSearch;
    @FXML private TableView<DaftarPartisipasi> attendanceCrudTable;
    @FXML private TableColumn<DaftarPartisipasi, String> colIdPartisipasi;
    @FXML private TableColumn<DaftarPartisipasi, String> colNrpMahasiswa;
    @FXML private TableColumn<DaftarPartisipasi, String> colNamaMahasiswa;
    @FXML private TableColumn<DaftarPartisipasi, String> colNamaKegiatan;
    @FXML private TableColumn<DaftarPartisipasi, LocalDate> colTanggalKegiatan;
    @FXML private TableColumn<DaftarPartisipasi, String> colStatusKehadiran;
    @FXML private TableColumn<DaftarPartisipasi, String> colStatusSertifikat;
    @FXML private TableColumn<DaftarPartisipasi, String> colNomorSertifikat;

    @FXML private TextField fieldIdPartisipasi;
    @FXML private TextField fieldNamaMahasiswa;
    @FXML private TextField fieldNamaKegiatan;
    @FXML private TextField fieldTanggalKegiatan;
    @FXML private ComboBox<String> comboStatusKehadiran;
    @FXML private ComboBox<String> comboStatusSertifikat;
    @FXML private ComboBox<String> comboDapatSertifikatKegiatan;
    @FXML private TextField fieldNomorSertifikat;
    @FXML private Button btnUpdate;
    @FXML private Button btnClear;

    private ObservableList<DaftarPartisipasi> masterData = FXCollections.observableArrayList();
    private KegiatanClubQuery kegiatanClubQuery = new KegiatanClubQuery();
    private ShowAlert showAlert = new ShowAlert(); // Initialize ShowAlert

    @FXML
    public void initialize() {
        // Inisialisasi kolom tabel
        colIdPartisipasi.setCellValueFactory(new PropertyValueFactory<>("idPartisipasi"));
        colNrpMahasiswa.setCellValueFactory(new PropertyValueFactory<>("nrpMahasiswa"));
        colNamaMahasiswa.setCellValueFactory(new PropertyValueFactory<>("namaMahasiswa"));
        colNamaKegiatan.setCellValueFactory(new PropertyValueFactory<>("namaKegiatan"));
        colTanggalKegiatan.setCellValueFactory(new PropertyValueFactory<>("tanggalKegiatan"));
        colStatusKehadiran.setCellValueFactory(new PropertyValueFactory<>("statusKehadiran"));

        // Custom cell value factory for certificate status (boolean to String)
        colStatusSertifikat.setCellValueFactory(cellData -> {
            DaftarPartisipasi partisipasi = cellData.getValue();
            if (partisipasi.isDapatSertifikatKegiatan()) { // If this activity is eligible for a certificate
                if (partisipasi.isStatusSertifikat()) { // If certificate status for this participation is TRUE (available)
                    return new SimpleStringProperty("Tersedia"); // Available
                } else {
                    return new SimpleStringProperty("Belum Tersedia"); // Not Available yet
                }
            } else { // If the activity is not eligible for a certificate
                return new SimpleStringProperty("Tidak Berlaku"); // Not Applicable
            }
        });

        colNomorSertifikat.setCellValueFactory(new PropertyValueFactory<>("nomorSertifikat"));

        // Inisialisasi ComboBoxes
        comboStatusKehadiran.setItems(FXCollections.observableArrayList("Hadir", "Tidak Hadir", "Belum Tercatat"));
        comboStatusSertifikat.setItems(FXCollections.observableArrayList("Tersedia", "Belum Tersedia")); // Admins can set this
        comboDapatSertifikatKegiatan.setItems(FXCollections.observableArrayList("Ya", "Tidak")); // For display only in the form

        loadPartisipasiData();
        setupTableViewDoubleClick();
        btnUpdate.setDisable(true);
    }

    /**
     * Memuat data partisipasi dari database ke TableView.
     */
    private void loadPartisipasiData() {
        masterData.clear();
        ArrayList<DaftarPartisipasi> partisipasiList = kegiatanClubQuery.getAllPartisipasiForPengurus();
        masterData.addAll(partisipasiList);
        attendanceCrudTable.setItems(masterData);
    }

    /**
     * Mengatur aksi double-click pada baris tabel untuk mengisi form update.
     */
    private void setupTableViewDoubleClick() {
        attendanceCrudTable.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) { // Double-click
                DaftarPartisipasi selectedPartisipasi = attendanceCrudTable.getSelectionModel().getSelectedItem();
                if (selectedPartisipasi != null) {
                    fillFormWithSelectedData(selectedPartisipasi);
                    btnUpdate.setDisable(false); // Aktifkan tombol update
                }
            }
        });
    }

    /**
     * Mengisi form update dengan data dari partisipasi yang dipilih.
     * @param partisipasi The selected PartisipasiDisplay object.
     */
    private void fillFormWithSelectedData(DaftarPartisipasi partisipasi) {
        fieldIdPartisipasi.setText(partisipasi.getIdPartisipasi());
        fieldNamaMahasiswa.setText(partisipasi.getNamaMahasiswa() + " (NRP: " + partisipasi.getNrpMahasiswa() + ")");
        fieldNamaKegiatan.setText(partisipasi.getNamaKegiatan());
        fieldTanggalKegiatan.setText(partisipasi.getTanggalKegiatan() != null ? partisipasi.getTanggalKegiatan().toString() : "-");

        comboStatusKehadiran.setValue(partisipasi.getStatusKehadiran());

        // Set comboDapatSertifikatKegiatan (display only)
        comboDapatSertifikatKegiatan.setValue(partisipasi.isDapatSertifikatKegiatan() ? "Ya" : "Tidak");
        comboDapatSertifikatKegiatan.setDisable(true); // Cannot be changed from here, only from activity_club data

        // Set comboStatusSertifikat
        if (partisipasi.isDapatSertifikatKegiatan()) { // Only if the activity is eligible for a certificate
            comboStatusSertifikat.setDisable(false); // Can be changed
            comboStatusSertifikat.setValue(partisipasi.isStatusSertifikat() ? "Tersedia" : "Belum Tersedia");
            fieldNomorSertifikat.setEditable(partisipasi.isStatusSertifikat()); // Only editable if status is "Tersedia"
            fieldNomorSertifikat.setText(partisipasi.getNomorSertifikat());
        } else {
            comboStatusSertifikat.setValue("Tidak Berlaku");
            comboStatusSertifikat.setDisable(true); // Cannot be changed
            fieldNomorSertifikat.setText("");
            fieldNomorSertifikat.setEditable(false);
        }
    }

    /**
     * Menangani aksi update data partisipasi.
     */
    @FXML
    private void handleUpdate() {
        String idPartisipasi = fieldIdPartisipasi.getText();
        if (idPartisipasi.isEmpty()) {
            showAlert.showAlert(Alert.AlertType.ERROR, "Error Update", "Pilih data partisipasi dari tabel terlebih dahulu.");
            return;
        }

        // Konfirmasi update
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Konfirmasi Update");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Anda yakin ingin memperbarui data partisipasi ini?");
        Optional<ButtonType> result = confirmationAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            String newStatusKehadiran = comboStatusKehadiran.getValue();
            boolean newStatusSertifikat = "Tersedia".equals(comboStatusSertifikat.getValue()); // Convert "Available" string to boolean TRUE
            String newNomorSertifikat = fieldNomorSertifikat.getText();

            // Validasi: Jika status sertifikat "Tersedia" tapi nomor sertifikat kosong
            if (newStatusSertifikat && (newNomorSertifikat == null || newNomorSertifikat.trim().isEmpty())) {
                showAlert.showAlert(Alert.AlertType.WARNING, "Validasi Input", "Nomor Sertifikat tidak boleh kosong jika Status Sertifikat adalah 'Tersedia'.");
                return;
            }
            // Jika status sertifikat "Belum Tersedia" (yaitu newStatusSertifikat adalah FALSE), nomor sertifikat harus NULL
            if (!newStatusSertifikat && (newNomorSertifikat != null && !newNomorSertifikat.trim().isEmpty())) {
                showAlert.showAlert(Alert.AlertType.WARNING, "Validasi Input", "Nomor Sertifikat harus kosong jika Status Sertifikat adalah 'Belum Tersedia'.");
                return;
            }

            boolean successKehadiran = kegiatanClubQuery.updatePartisipasiKehadiran(idPartisipasi, newStatusKehadiran);
            boolean successSertifikat = kegiatanClubQuery.updatePartisipasiSertifikat(idPartisipasi, newStatusSertifikat, newNomorSertifikat);

            if (successKehadiran && successSertifikat) {
                showAlert.showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data partisipasi berhasil diperbarui.");
                loadPartisipasiData(); // Muat ulang data tabel
                handleClear(); // Bersihkan form
            } else {
                showAlert.showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal memperbarui data partisipasi.");
            }
        }
    }

    /**
     * Menangani aksi pencarian data.
     */
    @FXML
    private void handleSearch() {
        String keyword = searchBar.getText().toLowerCase().trim();
        if (keyword.isEmpty()) {
            attendanceCrudTable.setItems(masterData); // Tampilkan semua jika kosong
            return;
        }

        ObservableList<DaftarPartisipasi> filteredList = FXCollections.observableArrayList();
        for (DaftarPartisipasi partisipasi : masterData) {
            // Konversi boolean statusSertifikat ke String untuk pencarian
            String statusSertifikatString = partisipasi.isDapatSertifikatKegiatan() ? (partisipasi.isStatusSertifikat() ? "tersedia" : "belum tersedia") : "tidak berlaku";

            if ((partisipasi.getNamaMahasiswa() != null && partisipasi.getNamaMahasiswa().toLowerCase().contains(keyword)) ||
                    (partisipasi.getNrpMahasiswa() != null && partisipasi.getNrpMahasiswa().toLowerCase().contains(keyword)) ||
                    (partisipasi.getNamaKegiatan() != null && partisipasi.getNamaKegiatan().toLowerCase().contains(keyword)) ||
                    (partisipasi.getStatusKehadiran() != null && partisipasi.getStatusKehadiran().toLowerCase().contains(keyword)) ||
                    (statusSertifikatString.contains(keyword)) || // Menggunakan string hasil konversi
                    (partisipasi.getNomorSertifikat() != null && partisipasi.getNomorSertifikat().toLowerCase().contains(keyword))) {
                filteredList.add(partisipasi);
            }
        }
        attendanceCrudTable.setItems(filteredList);
    }

    /**
     * Membersihkan form input.
     */
    @FXML
    private void handleClear() {
        fieldIdPartisipasi.clear();
        fieldNamaMahasiswa.clear();
        fieldNamaKegiatan.clear();
        fieldTanggalKegiatan.clear();
        comboStatusKehadiran.getSelectionModel().clearSelection();
        comboStatusSertifikat.getSelectionModel().clearSelection();
        comboDapatSertifikatKegiatan.getSelectionModel().clearSelection();
        fieldNomorSertifikat.clear();

        comboStatusKehadiran.setPromptText("Pilih Status");
        comboStatusSertifikat.setPromptText("Pilih Status");
        comboDapatSertifikatKegiatan.setPromptText("Ya/Tidak"); // Reset prompt

        comboDapatSertifikatKegiatan.setDisable(false); // Enable kembali jika sebelumnya didisable
        comboStatusSertifikat.setDisable(false);
        fieldNomorSertifikat.setEditable(true);

        btnUpdate.setDisable(true); // Disable tombol update setelah clear
        attendanceCrudTable.getSelectionModel().clearSelection(); // Hapus seleksi di tabel
    }
}
