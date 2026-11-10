package com.example.projectbd.ANGGOTA;

import com.example.projectbd.CLASS.KegiatanClub;
import com.example.projectbd.CLASS.KegiatanClubQuery;
import com.example.projectbd.CLASS.ShowAlert;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.util.ArrayList;

public class activityAttendanceController {

    @FXML
    private TableView<KegiatanClub> attendanceTableView;
    @FXML
    private TableColumn<KegiatanClub, String> namaKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, LocalDate> tanggalKegiatanColumn;
    @FXML
    private TableColumn<KegiatanClub, String> statusAttendanceColumn;
    @FXML
    private TableColumn<KegiatanClub, String> certificateNumberColumn;

    private ObservableList<KegiatanClub> attendanceData = FXCollections.observableArrayList();
    private KegiatanClubQuery kegiatanClubQuery = new KegiatanClubQuery();
    private ShowAlert showAlertUtil;

    private String nrpLoggedIn;

    @FXML
    public void initialize() {
        namaKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("namaKegiatan"));
        tanggalKegiatanColumn.setCellValueFactory(new PropertyValueFactory<>("tanggalKegiatan"));

        // Custom cell value factory untuk kolom status kehadiran
        statusAttendanceColumn.setCellValueFactory(cellData -> {
            KegiatanClub kegiatan = cellData.getValue();
            return new SimpleStringProperty("Data in Progress");
        });


        // Custom cell value factory untuk kolom Nomor Sertifikat
        certificateNumberColumn.setCellValueFactory(cellData -> {
            KegiatanClub kegiatan = cellData.getValue();
            LocalDate today = LocalDate.now();

            // Tampilkan nomor sertifikat hanya jika kegiatan sudah lewat/hari ini, eligible,
            // statusSertifikat TRUE, DAN nomornya ada
            if ((kegiatan.getTanggalKegiatan().isBefore(today) || kegiatan.getTanggalKegiatan().isEqual(today)) &&
                    kegiatan.isDapatSertifikat() &&
                    kegiatan.isStatusSertifikat() && // Periksa jika statusSertifikat adalah TRUE (boolean)
                    kegiatan.getNomorSertifikat() != null && !kegiatan.getNomorSertifikat().isEmpty()) {
                return new SimpleStringProperty(kegiatan.getNomorSertifikat());
            } else {
                return new SimpleStringProperty("-");
            }
        });

        showAlertUtil = new ShowAlert();
    }

    public void setNRPLoggedIn(String nrp) {
        this.nrpLoggedIn = nrp;
        if (nrpLoggedIn != null && !nrpLoggedIn.isEmpty()) {
            loadAttendanceData();
        } else {
            showAlertUtil.showAlert(getOwnerWindow(), Alert.AlertType.ERROR, "Error", "NRP mahasiswa yang login tidak ditemukan. Harap login ulang.");
        }
    }

    private void loadAttendanceData() {
        attendanceData.clear();
        ArrayList<KegiatanClub> activities = kegiatanClubQuery.getKegiatanRegisteredByStudent(nrpLoggedIn);
        attendanceData.addAll(activities);
        attendanceTableView.setItems(attendanceData);
    }

    private Window getOwnerWindow() {
        if (attendanceTableView != null && attendanceTableView.getScene() != null) {
            return attendanceTableView.getScene().getWindow();
        }
        return null;
    }
}