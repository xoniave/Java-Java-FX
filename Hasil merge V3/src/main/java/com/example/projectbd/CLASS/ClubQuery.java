package com.example.projectbd.CLASS;

import java.sql.Connection; // Menggunakan java.sql.Connection sesuai yang Anda berikan
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

// Asumsi ada kelas DatabaseConnection di package com.example.projectbd.CONNECTION
// import com.example.projectbd.CONNECTION.DatabaseConnection; // Pastikan ini diimpor atau sesuaikan

public class ClubQuery {

    public String getNextClubId() {
        String nextId = "C01"; // Default first ID if the table is empty
        String sql = "SELECT MAX(CAST(SUBSTRING(id_club, 2) AS INTEGER)) AS max_num FROM club";

        try (Connection conn = com.example.projectbd.CLASS.DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                if (rs.wasNull()) { // If no data exists, start from 0
                    maxNum = 0;
                }
                nextId = String.format("C%02d", maxNum + 1); // Format to CL01, CL02, etc.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error getting next club ID: " + e.getMessage());
        }
        return nextId;
    }

    // Method untuk melihat semua club (untuk Pengurus)
    public ArrayList<Club> LihatClubPengurus() {
        String query = "SELECT * FROM club";
        ArrayList<Club> CLUB_DATA = new ArrayList<>();

        try (Connection connection = com.example.projectbd.CLASS.DatabaseConnection.getConnection(); // Menggunakan DatabaseConnection
             PreparedStatement pst = connection.prepareStatement(query)) {

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()){
                    // Perhatikan: Tahun berdiri dari database adalah INT, sesuaikan constructor Club jika diperlukan
                    Club C = new Club(rs.getString("id_club"), rs.getString("id_kategori"), rs.getString("nama_club"), rs.getString("deskripsi"), rs.getString("tahun_berdiri"));
                    CLUB_DATA.add(C);
                }
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat memeriksa data club (Pengurus): " + e.getMessage());
            e.printStackTrace();
        }
        return CLUB_DATA;
    }

    // Method untuk melihat club (untuk Anggota)
    public ArrayList<Club> LihatClubAnggota() {
        String query = "SELECT c.id_club, c.nama_club, k.nama_kategori AS id_kategori, c.deskripsi, c.tahun_berdiri FROM club c JOIN kategori k ON k.id_kategori = c.id_kategori;";
        ArrayList<Club> CLUB_DATA = new ArrayList<>();

        try (Connection connection = com.example.projectbd.CLASS.DatabaseConnection.getConnection(); // Menggunakan DatabaseConnection
             PreparedStatement pst = connection.prepareStatement(query)) {

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()){
                    // Perhatikan: nama_kategori diambil sebagai id_kategori
                    Club C = new Club(rs.getString("id_club"), rs.getString("id_kategori"), rs.getString("nama_club"), rs.getString("deskripsi"), rs.getString("tahun_berdiri"));
                    CLUB_DATA.add(C);
                }
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat memeriksa data club (Anggota): " + e.getMessage());
            e.printStackTrace();
        }
        return CLUB_DATA;
    }

    private String getNextKeanggotaanId() {
        String nextId = "KG01"; // Default pertama jika tabel kosong

        String sql = "SELECT MAX(CAST(SUBSTRING(id_keanggotaan, 3) AS INTEGER)) AS max_num FROM keanggotaan";
        try (Connection conn = com.example.projectbd.CLASS.DatabaseConnection.getConnection(); // Menggunakan DatabaseConnection
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                if (rs.wasNull()) { // Jika tidak ada data sama sekali, mulai dari 0
                    maxNum = 0;
                }
                nextId = String.format("KG%02d", maxNum + 1); // Format ke KG01, KG02, dst.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error saat mendapatkan ID keanggotaan berikutnya: " + e.getMessage());
        }
        return nextId;
    }

    public boolean daftarClub(String nrpAnggota, String idClub) {
        String idKeanggotaanBaru = getNextKeanggotaanId();
        String sql = "INSERT INTO keanggotaan (id_keanggotaan, id_club, nrp, peran, tanggal_bergabung, status_keanggotaan) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = com.example.projectbd.CLASS.DatabaseConnection.getConnection(); // Menggunakan DatabaseConnection
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idKeanggotaanBaru);
            ps.setString(2, idClub);
            ps.setString(3, nrpAnggota);
            ps.setString(4, "ANGGOTA"); // Peran default saat mendaftar
            ps.setDate(5, java.sql.Date.valueOf(LocalDate.now())); // Tanggal daftar hari ini
            ps.setString(6, "AKTIF"); // Status default
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error saat mendaftarkan anggota ke klub: " + e.getMessage());
            return false;
        }
    }

    // Method untuk melihat klub yang diikuti oleh anggota tertentu (berdasarkan NRP)
    public ArrayList<Club> lihatClubDiikutiAnggota(String nrpAnggota) {
        ArrayList<Club> clubDiikuti = new ArrayList<>();

        String sql = "SELECT C.id_club, K.nama_kategori, C.nama_club, C.deskripsi, C.tahun_berdiri " +
                "FROM club C JOIN keanggotaan KC ON C.id_club = KC.id_club " +
                "JOIN kategori K ON C.id_kategori = K.id_kategori " +
                "WHERE KC.nrp = ?";
        try (Connection conn = com.example.projectbd.CLASS.DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nrpAnggota);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Club club = new Club(
                        rs.getString("id_club"),
                        rs.getString("nama_kategori"),
                        rs.getString("nama_club"),
                        rs.getString("deskripsi"),
                        rs.getString("tahun_berdiri")
                );
                clubDiikuti.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error saat melihat klub yang diikuti anggota: " + e.getMessage());
        }
        return clubDiikuti;
    }

    public ArrayList<Keanggotaan> getKeanggotaanByClub(String idClub) {
        ArrayList<Keanggotaan> anggotaList = new ArrayList<>();
        String sql = "SELECT * FROM keanggotaan WHERE id_club = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idClub);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Keanggotaan anggota = new Keanggotaan(
                            rs.getString("id_keanggotaan"),
                            rs.getString("id_club"),
                            rs.getString("nrp"),
                            rs.getString("peran"),
                            rs.getDate("tanggal_bergabung").toLocalDate(),
                            rs.getString("status_keanggotaan")
                    );
                    anggotaList.add(anggota);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return anggotaList;
    }


    public boolean tambahClub(Club club) {
        String sql = "INSERT INTO club (id_club, id_kategori, nama_club, deskripsi, tahun_berdiri) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, club.getIdClub());
            System.out.println(ps);
            ps.setString(2, club.getId_Kategori());
            System.out.println(ps);
            ps.setString(3, club.getNamaClub());
            System.out.println(ps);
            ps.setString(4, club.getDeskripsi());
            System.out.println(ps);
            ps.setString(5, club.getTahunBerdiri());
            System.out.println(ps);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateClub(Club club) {
        String sql = "UPDATE club SET id_kategori = ?, nama_club = ?, deskripsi = ?, tahun_berdiri = ? WHERE id_club = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, club.getId_Kategori());
            ps.setString(2, club.getNamaClub());
            ps.setString(3, club.getDeskripsi());
            ps.setString(4, club.getTahunBerdiri());
            ps.setString(5, club.getIdClub());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean hapusClub(String idClub) {
        String sql = "DELETE FROM club WHERE id_club = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idClub);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatusAnggota(String idKeanggotaan, String nrp, String status) {
        String sql = "UPDATE keanggotaan SET nrp = ?, status_keanggotaan = ? WHERE id_keanggotaan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nrp);
            ps.setString(2, status);
            ps.setString(3, idKeanggotaan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Kategori> getAllKategori() {
        ArrayList<Kategori> daftarKategori = new ArrayList<>();
        String sql = "SELECT id_kategori, nama_kategori FROM kategori ORDER BY nama_kategori";

        try (Connection conn = DatabaseConnection.getConnection(); // Pastikan DatabaseConnection ada
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id_kategori");
                String nama = rs.getString("nama_kategori");
                daftarKategori.add(new Kategori(id, nama));
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil data kategori: " + e.getMessage());
            e.printStackTrace();
        }
        return daftarKategori;
    }
}
