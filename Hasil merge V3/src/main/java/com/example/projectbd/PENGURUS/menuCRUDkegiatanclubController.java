package com.example.projectbd.PENGURUS;

import com.example.projectbd.CLASS.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class menuCRUDkegiatanclubController {
    @FXML
    private TextField searchBar;
    @FXML private Button searchButton;

    @FXML private TableView<KegiatanClub> kegiatanClubTable;
    @FXML private TableColumn<KegiatanClub, String> colIdKegiatanClub;
    @FXML private TableColumn<KegiatanClub, String> colJenisKegiatan;
    @FXML private TableColumn<KegiatanClub, String> colNamaClub;
    @FXML private TableColumn<KegiatanClub, String> colNamaLokasi;
    @FXML private TableColumn<KegiatanClub, String> colNamaKegiatan;
    @FXML private TableColumn<KegiatanClub, LocalDate> colTanggalKegiatan;
    @FXML private TableColumn<KegiatanClub, Boolean> colDapatSerti;

    @FXML private ComboBox<String> idJenisKegiatanComboBox;
    @FXML private ComboBox<String> idClubComboBox;
    @FXML private ComboBox<String> idLokasiComboBox;
    @FXML private TextField namaKegiatanField;
    @FXML private DatePicker tanggalKegiatanPicker;
    @FXML private RadioButton sertiYesRadio;
    @FXML private RadioButton sertiNoRadio;
    @FXML private ToggleGroup sertiToggleGroup;

    @FXML private Button addButton;
    @FXML private Button updateButton;
    @FXML private Button deleteButton;
    @FXML private Button clearButton;

    private final ShowAlert sa = new ShowAlert(); // Menggunakan ShowAlert yang Anda berikan
    private ObservableList<KegiatanClub> masterData;
    private final KegiatanClubQuery kegiatanClubQuery = new KegiatanClubQuery();

    public void initialize() {
        colIdKegiatanClub.setCellValueFactory(new PropertyValueFactory<>("idKegiatanClub"));
        colJenisKegiatan.setCellValueFactory(new PropertyValueFactory<>("namaJenisKegiatan"));
        colNamaClub.setCellValueFactory(new PropertyValueFactory<>("namaClub"));
        colNamaLokasi.setCellValueFactory(new PropertyValueFactory<>("keteranganLokasi"));
        colNamaKegiatan.setCellValueFactory(new PropertyValueFactory<>("namaKegiatan"));
        colTanggalKegiatan.setCellValueFactory(new PropertyValueFactory<>("tanggalKegiatan"));
        colDapatSerti.setCellValueFactory(new PropertyValueFactory<>("dapatSertifikat"));

        masterData = FXCollections.observableArrayList();
        kegiatanClubTable.setItems(masterData);

        ArrayList<String> namaclub = kegiatanClubQuery.getnamaClubList();
        ArrayList<String> jeniskegiatan = kegiatanClubQuery.getJenisKegiatanList();
        ArrayList <String> Lokasi = kegiatanClubQuery.getlokasiList();
        idClubComboBox.setItems(FXCollections.observableArrayList(namaclub));
        idJenisKegiatanComboBox.setItems(FXCollections.observableArrayList(jeniskegiatan));
        idLokasiComboBox.setItems(FXCollections.observableArrayList(Lokasi));

        loadKegiatanClubData();
        doubleClick();
        handleClear();
    }

    @FXML
    private void handleAdd() {
        if (!isInputValid()) {
            return;
        }
        boolean dapatSertifikat = sertiYesRadio.isSelected();
        KegiatanClub newKegiatan = new KegiatanClub(
                null,
                idJenisKegiatanComboBox.getValue(),
                idClubComboBox.getValue(),
                idLokasiComboBox.getValue(),
                namaKegiatanField.getText(),
                tanggalKegiatanPicker.getValue(),
                dapatSertifikat
        );

        if (kegiatanClubQuery.addKegiatan(newKegiatan)) {
            sa.showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data kegiatan berhasil ditambahkan."); // Perubahan di sini
            loadKegiatanClubData();
            handleClear();
        } else {
            sa.showAlert(Alert.AlertType.ERROR, "Gagal", "Data kegiatan gagal ditambahkan."); // Perubahan di sini
        }
    }

    @FXML
    private void handleUpdate() {
        KegiatanClub selectedKegiatan = kegiatanClubTable.getSelectionModel().getSelectedItem();
        if (selectedKegiatan == null) {
            sa.showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data yang ingin diperbarui."); // Perubahan di sini
            return;
        }
        if (!isInputValid()) {
            return;
        }

        boolean dapatSertifikat = sertiYesRadio.isSelected();
        KegiatanClub updatedKegiatan = new KegiatanClub(
                selectedKegiatan.getIdKegiatanClub(),
                idJenisKegiatanComboBox.getValue(),
                idClubComboBox.getValue(),
                idLokasiComboBox.getValue(),
                namaKegiatanField.getText(),
                tanggalKegiatanPicker.getValue(),
                dapatSertifikat
        );

        if (kegiatanClubQuery.updateKegiatan(updatedKegiatan)) {
            sa.showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data kegiatan berhasil diperbarui."); // Perubahan di sini
            loadKegiatanClubData();
            handleClear();
        } else {
            sa.showAlert(Alert.AlertType.ERROR, "Gagal", "Data kegiatan gagal diperbarui."); // Perubahan di sini
        }
    }

    @FXML
    private void handleDelete() {
        KegiatanClub selectedKegiatan = kegiatanClubTable.getSelectionModel().getSelectedItem();
        if (selectedKegiatan == null) {
            sa.showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data yang ingin dihapus."); // Perubahan di sini
            return;
        }

        // Perubahan di sini: Membuat dialog konfirmasi secara manual
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi Hapus");
        alert.setHeaderText(null);
        alert.setContentText("Apakah Anda yakin ingin menghapus kegiatan '" + selectedKegiatan.getNamaKegiatan() + "'?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (kegiatanClubQuery.deleteKegiatan(selectedKegiatan.getIdKegiatanClub())) {
                sa.showAlert(Alert.AlertType.INFORMATION, "Sukses", "Data kegiatan berhasil dihapus."); // Perubahan di sini
                loadKegiatanClubData();
                handleClear();
            } else {
                sa.showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal menghapus kegiatan. Mungkin kegiatan ini sudah memiliki peserta terdaftar."); // Perubahan di sini
            }
        }
    }

    @FXML
    private void handleClear() {
        kegiatanClubTable.getSelectionModel().clearSelection();
        idJenisKegiatanComboBox.getSelectionModel().clearSelection();
        idClubComboBox.getSelectionModel().clearSelection();
        idLokasiComboBox.getSelectionModel().clearSelection();
        namaKegiatanField.clear();
        tanggalKegiatanPicker.setValue(null);

        if (sertiToggleGroup.getSelectedToggle() != null) {
            sertiToggleGroup.getSelectedToggle().setSelected(false);
        }

        idJenisKegiatanComboBox.setPromptText("Pilih jenis kegiatan");
        idClubComboBox.setPromptText("Pilih club");
        idLokasiComboBox.setPromptText("Pilih lokasi");
        namaKegiatanField.setPromptText("Masukan nama kegiatan");
        tanggalKegiatanPicker.setPromptText("Pilih tanggal");


        addButton.setDisable(false);
        updateButton.setDisable(true);
        deleteButton.setDisable(true);
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (idJenisKegiatanComboBox.getValue() == null) errorMessage += "Jenis kegiatan tidak boleh kosong!\n";
        if (idClubComboBox.getValue() == null) errorMessage += "Nama club tidak boleh kosong!\n";
        if (idLokasiComboBox.getValue() == null) errorMessage += "Lokasi tidak boleh kosong!\n";
        if (namaKegiatanField.getText() == null || namaKegiatanField.getText().trim().isEmpty()) errorMessage += "Nama kegiatan tidak boleh kosong!\n";
        if (tanggalKegiatanPicker.getValue() == null) errorMessage += "Tanggal kegiatan tidak boleh kosong!\n";
        if (sertiToggleGroup.getSelectedToggle() == null) errorMessage += "Opsi sertifikat harus dipilih!\n";

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            // Perubahan di sini
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Tidak Valid");
            alert.setHeaderText("Harap perbaiki isian berikut:");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }
    }


    private void loadKegiatanClubData() {
        masterData.clear();
        ArrayList<KegiatanClub> kegiatanList = kegiatanClubQuery.getAllKegiatanClub();
        masterData.addAll(kegiatanList);
    }

    private void doubleClick() {
        kegiatanClubTable.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                KegiatanClub selectedClub = kegiatanClubTable.getSelectionModel().getSelectedItem();
                if (selectedClub != null) {
                    isiForm(selectedClub);
                }
            }
        });
    }

    private void isiForm(KegiatanClub kegiatan) {
        idJenisKegiatanComboBox.setValue(kegiatan.getNamaJenisKegiatan());
        idClubComboBox.setValue(kegiatan.getNamaClub());
        idLokasiComboBox.setValue(kegiatan.getKeteranganLokasi());
        namaKegiatanField.setText(kegiatan.getNamaKegiatan());
        tanggalKegiatanPicker.setValue(kegiatan.getTanggalKegiatan());

        if (kegiatan.isDapatSertifikat()) {
            sertiYesRadio.setSelected(true);
        } else {
            sertiNoRadio.setSelected(true);
        }

        addButton.setDisable(true);
        updateButton.setDisable(false);
        deleteButton.setDisable(false);
    }

    @FXML
    private void handleSearch() {
        String keyword = searchBar.getText().toLowerCase().trim();
        ObservableList<KegiatanClub> listToSearch = FXCollections.observableArrayList(kegiatanClubQuery.getAllKegiatanClub());
        if (keyword.isEmpty()) {
            kegiatanClubTable.setItems(listToSearch);
            return;
        }
        ObservableList<KegiatanClub> filteredList = FXCollections.observableArrayList();
        for (KegiatanClub kegiatanClub : listToSearch) {
            if ((kegiatanClub.getIdKegiatanClub() != null && kegiatanClub.getIdKegiatanClub().toLowerCase().contains(keyword)) ||
                    (kegiatanClub.getNamaJenisKegiatan() != null && kegiatanClub.getNamaJenisKegiatan().toLowerCase().contains(keyword)) ||
                    (kegiatanClub.getNamaClub() != null && kegiatanClub.getNamaClub().toLowerCase().contains(keyword)) ||
                    (kegiatanClub.getKeteranganLokasi() != null && kegiatanClub.getKeteranganLokasi().toLowerCase().contains(keyword)) ||
                    (kegiatanClub.getNamaKegiatan() != null && kegiatanClub.getNamaKegiatan().toLowerCase().contains(keyword)) ||
                    (kegiatanClub.getTanggalKegiatan() != null && kegiatanClub.getTanggalKegiatan().toString().toLowerCase().contains(keyword)) ||
                    (String.valueOf(kegiatanClub.isDapatSertifikat()).toLowerCase().contains(keyword))) {
                filteredList.add(kegiatanClub);
            }
        }
        kegiatanClubTable.setItems(filteredList);
    }
}