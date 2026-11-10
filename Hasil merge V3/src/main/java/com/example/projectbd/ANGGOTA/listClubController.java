package com.example.projectbd.ANGGOTA;

import com.example.projectbd.CLASS.Club;
import com.example.projectbd.CLASS.ClubQuery;
import com.example.projectbd.CLASS.MahasiswaQuery;
import com.example.projectbd.CLASS.ShowAlert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.util.ArrayList;

public class listClubController {

    @FXML
    private Label listClubLabel;

    @FXML
    private TextField keywordSearchField;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnDaftarClub;

    @FXML
    private TableView<Club> clubTableView; // Untuk menampilkan semua club

    @FXML
    private TableColumn<Club, String> idKategoriColumn;
    @FXML
    private TableColumn<Club, String> namaClubColumn;
    @FXML
    private TableColumn<Club, String> deskripsiColumn;
    @FXML
    private TableColumn<Club, String> tahunBerdiriColumn;

    @FXML
    private TableView<Club> clubDiikutiTableView; // Untuk menampilkan club yang diikuti anggota
    @FXML
    private TableColumn<Club, String> idKategoriDiikutiColumn;
    @FXML
    private TableColumn<Club, String> namaClubDiikutiColumn;
    @FXML
    private TableColumn<Club, String> deskripsiDiikutiColumn;
    @FXML
    private TableColumn<Club, String> tahunBerdiriDiikutiColumn;

    private ObservableList<Club> masterClubData = FXCollections.observableArrayList();
    private ObservableList<Club> clubDiikutiData = FXCollections.observableArrayList(); // Data club yang diikuti
    private ClubQuery clubQuery = new ClubQuery();

    private MahasiswaQuery m = new MahasiswaQuery();
    private ShowAlert SA = new ShowAlert();
    private String nrp = "";
    @FXML
    public void initialize(String nrp) {

        this.nrp = nrp;

        // Inisialisasi kolom untuk tabel semua club
        idKategoriColumn.setCellValueFactory(new PropertyValueFactory<>("id_Kategori"));
        namaClubColumn.setCellValueFactory(new PropertyValueFactory<>("namaClub"));
        deskripsiColumn.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        tahunBerdiriColumn.setCellValueFactory(new PropertyValueFactory<>("tahunBerdiri"));
        loadClubData(); // Memuat semua data klub

        // Inisialisasi kolom untuk tabel club yang diikuti
        idKategoriDiikutiColumn.setCellValueFactory(new PropertyValueFactory<>("id_Kategori"));
        namaClubDiikutiColumn.setCellValueFactory(new PropertyValueFactory<>("namaClub"));
        deskripsiDiikutiColumn.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        tahunBerdiriDiikutiColumn.setCellValueFactory(new PropertyValueFactory<>("tahunBerdiri"));
        loadClubDiikutiData(); // Memuat data klub yang diikuti oleh anggota
    }

    @FXML
    void onSearchButtonClick()
    {
        handleSearchClub();
    }

    @FXML
    void onDaftarButtonClick()
    {
        handleDaftarClub();
    }


    private void loadClubData() {
        masterClubData.clear();
        ArrayList<Club> clubs = clubQuery.LihatClubAnggota();
        masterClubData.addAll(clubs);
        clubTableView.setItems(masterClubData);
    }

    private void loadClubDiikutiData() {
        clubDiikutiData.clear();
        ArrayList<Club> clubsDiikuti = clubQuery.lihatClubDiikutiAnggota(nrp);
        clubDiikutiData.addAll(clubsDiikuti);
        clubDiikutiTableView.setItems(clubDiikutiData);
    }

    @FXML
    private void handleDaftarClub() {
        Club selectedClub = clubTableView.getSelectionModel().getSelectedItem();
        if (selectedClub != null) {

            boolean alreadyJoined = clubDiikutiData.stream().anyMatch(club -> club.getIdClub().equals(selectedClub.getIdClub()));

            if (alreadyJoined) {
                SA.showAlert(Alert.AlertType.WARNING,"Peringatan", "Anda sudah terdaftar di klub ini.");
                return;
            }

            boolean success = clubQuery.daftarClub(nrp, selectedClub.getIdClub());

            if (success) {
                SA.showAlert(Alert.AlertType.INFORMATION, "Sukses", "Berhasil mendaftar ke klub: " + selectedClub.getNamaClub());
                loadClubDiikutiData(); // Muat ulang daftar klub yang diikuti
            } else {
                SA.showAlert(Alert.AlertType.ERROR, "Gagal", "Gagal mendaftar ke klub: " + selectedClub.getNamaClub());
            }
        } else {
            SA.showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih klub yang ingin didaftar terlebih dahulu.");
        }
    }

    @FXML
    private void handleSearchClub() {
        String keyword = keywordSearchField.getText().toLowerCase().trim();
        if (keyword.isEmpty()) {
            clubTableView.setItems(masterClubData); // Tampilkan semua jika kosong
            return;
        }

        ObservableList<Club> filteredList = FXCollections.observableArrayList();
        for (Club club : masterClubData) {
            if (club.getNamaClub().toLowerCase().contains(keyword) ||
                    club.getDeskripsi().toLowerCase().contains(keyword) ||
                    String.valueOf(club.getTahunBerdiri()).contains(keyword) ||
                    club.getId_Kategori().toLowerCase().contains(keyword)) {
                filteredList.add(club);
            }
        }
        clubTableView.setItems(filteredList);
    }
}
