package com.example.projectbd.CLASS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class KegiatanClubQuery {

    private String getNextPartisipasiId() {
        String nextId = "PT01";
        String sql = "SELECT MAX(CAST(SUBSTRING(id_partisipasi, 3) AS INTEGER)) AS max_num FROM partisipasi_kegiatan";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                if (rs.wasNull()) {
                    maxNum = 0;
                }
                nextId = String.format("PT%02d", maxNum + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error getting next participation ID: " + e.getMessage());
        }
        return nextId;
    }

    // Method to retrieve all club activities for display
    public ArrayList<KegiatanClub> getAllKegiatanClub() {
        ArrayList<KegiatanClub> activities = new ArrayList<>();
        String sql = "SELECT kc.id_kegiatan_club, kc.nama_kegiatan, kc.tanggal_kegiatan, " +
                "jk.nama_jenis_kegiatan, c.nama_club, l.keterangan AS lokasi_keterangan, " +
                "kc.dapat_sertifikat " +
                "FROM kegiatan_club kc " +
                "JOIN jenis_kegiatan jk ON kc.id_jenis_kegiatan = jk.id_jenis_kegiatan " +
                "JOIN club c ON kc.id_club = c.id_club " +
                "JOIN lokasi l ON kc.id_lokasi = l.id_lokasi";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                KegiatanClub activity = new KegiatanClub(
                        rs.getString("id_kegiatan_club"),
                        rs.getString("nama_jenis_kegiatan"),
                        rs.getString("nama_club"),
                        rs.getString("lokasi_keterangan"),
                        rs.getString("nama_kegiatan"),
                        rs.getDate("tanggal_kegiatan").toLocalDate(),
                        rs.getBoolean("dapat_sertifikat")
                );
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error retrieving all club activities: " + e.getMessage());
        }
        return activities;
    }

    // Method to register a student for an activity
    public boolean daftarKegiatan(String nrpMahasiswa, String idKegiatanClub) {
        String idPartisipasiBaru = getNextPartisipasiId();

        String sql = "INSERT INTO partisipasi_kegiatan (id_partisipasi, id_kegiatan_club, nrp, tanggal_daftar, peran_partisipasi, status_kehadiran, status_sertifikat, nomor_sertifikat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, idPartisipasiBaru);
            ps.setString(2, idKegiatanClub);
            ps.setString(3, nrpMahasiswa);
            ps.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ps.setString(5, "Peserta");
            ps.setString(6, "Belum Tercatat");
            ps.setBoolean(7, false); // Mengisi nilai FALSE untuk status_sertifikat (boolean)
            ps.setString(8, null); // Nomor sertifikat awal
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error registering student for activity: " + e.getMessage());
            return false;
        }
    }

    // Method to check if a student is already registered for a specific activity
    public boolean isMahasiswaRegistered(String nrpMahasiswa, String idKegiatanClub) {
        String sql = "SELECT COUNT(*) FROM partisipasi_kegiatan WHERE nrp = ? AND id_kegiatan_club = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nrpMahasiswa);
            ps.setString(2, idKegiatanClub);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error checking student registration: " + e.getMessage());
        }
        return false;
    }

    // Method to retrieve activities a student is registered for, including participation details for Anggota view
    public ArrayList<KegiatanClub> getKegiatanRegisteredByStudent(String nrpMahasiswa) {
        ArrayList<KegiatanClub> registeredActivities = new ArrayList<>();
        String sql = "SELECT kc.id_kegiatan_club, kc.nama_kegiatan, kc.tanggal_kegiatan, " +
                "jk.nama_jenis_kegiatan, c.nama_club, l.keterangan AS lokasi_keterangan, " +
                "pk.tanggal_daftar, pk.peran_partisipasi, pk.status_kehadiran, " +
                "kc.dapat_sertifikat, pk.status_sertifikat, pk.nomor_sertifikat " +
                "FROM kegiatan_club kc " +
                "JOIN jenis_kegiatan jk ON kc.id_jenis_kegiatan = jk.id_jenis_kegiatan " +
                "JOIN club c ON kc.id_club = c.id_club " +
                "JOIN lokasi l ON kc.id_lokasi = l.id_lokasi " +
                "JOIN partisipasi_kegiatan pk ON kc.id_kegiatan_club = pk.id_kegiatan_club " +
                "WHERE pk.nrp = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nrpMahasiswa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    KegiatanClub activity = new KegiatanClub(
                            rs.getString("id_kegiatan_club"),
                            rs.getString("nama_jenis_kegiatan"),
                            rs.getString("nama_club"),
                            rs.getString("lokasi_keterangan"),
                            rs.getString("nama_kegiatan"),
                            rs.getDate("tanggal_kegiatan").toLocalDate(),
                            rs.getDate("tanggal_daftar").toLocalDate(),
                            rs.getString("peran_partisipasi"),
                            rs.getString("status_kehadiran"),
                            rs.getBoolean("status_sertifikat"), // Mengambil nilai boolean
                            rs.getString("nomor_sertifikat")
                    );
                    activity.setDapatSertifikat(rs.getBoolean("dapat_sertifikat"));
                    registeredActivities.add(activity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error retrieving registered activities for student: " + e.getMessage());
        }
        return registeredActivities;
    }

    public ArrayList<DaftarPartisipasi> getAllPartisipasiForPengurus() {
        ArrayList<DaftarPartisipasi> partisipasiList = new ArrayList<>();
        String sql = "SELECT pk.id_partisipasi, m.nrp, m.nama AS nama_mahasiswa, " +
                "kc.id_kegiatan_club, kc.nama_kegiatan, kc.tanggal_kegiatan, " +
                "pk.status_kehadiran, pk.status_sertifikat, pk.nomor_sertifikat, " +
                "kc.dapat_sertifikat " +
                "FROM partisipasi_kegiatan pk " +
                "JOIN mahasiswa m ON pk.nrp = m.nrp " +
                "JOIN kegiatan_club kc ON pk.id_kegiatan_club = kc.id_kegiatan_club " +
                "ORDER BY kc.tanggal_kegiatan DESC, m.nama ASC"; // Urutkan data
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DaftarPartisipasi partisipasi = new DaftarPartisipasi(
                        rs.getString("id_partisipasi"),
                        rs.getString("nrp"),
                        rs.getString("nama_mahasiswa"),
                        rs.getString("id_kegiatan_club"),
                        rs.getString("nama_kegiatan"),
                        rs.getDate("tanggal_kegiatan").toLocalDate(),
                        rs.getString("status_kehadiran"),
                        rs.getBoolean("status_sertifikat"), // Mengambil nilai boolean
                        rs.getString("nomor_sertifikat"),
                        rs.getBoolean("dapat_sertifikat")
                );
                partisipasiList.add(partisipasi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error retrieving all participation data for pengurus: " + e.getMessage());
        }
        return partisipasiList;
    }

    public boolean updatePartisipasiKehadiran(String idPartisipasi, String newStatusKehadiran) {
        String sql = "UPDATE partisipasi_kegiatan SET status_kehadiran = ? WHERE id_partisipasi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newStatusKehadiran);
            ps.setString(2, idPartisipasi);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating attendance status for participation ID " + idPartisipasi + ": " + e.getMessage());
            return false;
        }
    }

    public boolean updatePartisipasiSertifikat(String idPartisipasi, boolean newStatusSertifikat, String newNomorSertifikat) {
        String sql = "UPDATE partisipasi_kegiatan SET status_sertifikat = ?, nomor_sertifikat = ? WHERE id_partisipasi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, newStatusSertifikat);
            // Jika status sertifikat FALSE, nomor sertifikat harus NULL
            ps.setString(2, newStatusSertifikat ? newNomorSertifikat : null);
            ps.setString(3, idPartisipasi);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error updating certificate data for participation ID " + idPartisipasi + ": " + e.getMessage());
            return false;
        }
    }

    private String getNextKegiatanClubId() {
        String nextId = "KC01";
        String sql = "SELECT MAX(CAST(SUBSTRING(id_kegiatan_club, 3) AS INTEGER)) AS max_num FROM kegiatan_club";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxNum = rs.getInt("max_num");
                if (!rs.wasNull()) {
                    nextId = String.format("KC%02d", maxNum + 1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }

    /**
     * Mendapatkan ID dari nama yang dipilih di ComboBox.
     */
    private String getIdByName(String tableName, String columnName, String name) {
        String sql = "SELECT id_" + tableName + " FROM " + tableName + " WHERE " + columnName + " = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Menambah kegiatan baru ke database.
     */
    public boolean addKegiatan(KegiatanClub kegiatan) {
        String sql = "INSERT INTO kegiatan_club (id_kegiatan_club, id_jenis_kegiatan, id_club, id_lokasi, nama_kegiatan, tanggal_kegiatan, dapat_sertifikat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String idJenisKegiatan = getIdByName("jenis_kegiatan", "nama_jenis_kegiatan", kegiatan.getNamaJenisKegiatan());
            String idClub = getIdByName("club", "nama_club", kegiatan.getNamaClub());
            String idLokasi = getIdByName("lokasi", "keterangan", kegiatan.getKeteranganLokasi());

            ps.setString(1, getNextKegiatanClubId());
            ps.setString(2, idJenisKegiatan);
            ps.setString(3, idClub);
            ps.setString(4, idLokasi);
            ps.setString(5, kegiatan.getNamaKegiatan());
            ps.setDate(6, java.sql.Date.valueOf(kegiatan.getTanggalKegiatan()));
            ps.setBoolean(7, kegiatan.isDapatSertifikat());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Memperbarui data kegiatan di database.
     */
    public boolean updateKegiatan(KegiatanClub kegiatan) {
        String sql = "UPDATE kegiatan_club SET id_jenis_kegiatan = ?, id_club = ?, id_lokasi = ?, nama_kegiatan = ?, tanggal_kegiatan = ?, dapat_sertifikat = ? WHERE id_kegiatan_club = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String idJenisKegiatan = getIdByName("jenis_kegiatan", "nama_jenis_kegiatan", kegiatan.getNamaJenisKegiatan());
            String idClub = getIdByName("club", "nama_club", kegiatan.getNamaClub());
            String idLokasi = getIdByName("lokasi", "keterangan", kegiatan.getKeteranganLokasi());

            ps.setString(1, idJenisKegiatan);
            ps.setString(2, idClub);
            ps.setString(3, idLokasi);
            ps.setString(4, kegiatan.getNamaKegiatan());
            ps.setDate(5, java.sql.Date.valueOf(kegiatan.getTanggalKegiatan()));
            ps.setBoolean(6, kegiatan.isDapatSertifikat());
            ps.setString(7, kegiatan.getIdKegiatanClub());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Menghapus kegiatan dari database berdasarkan ID.
     */
    public boolean deleteKegiatan(String idKegiatanClub) {
        String sql = "DELETE FROM kegiatan_club WHERE id_kegiatan_club = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idKegiatanClub);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Error ini biasanya terjadi jika ada foreign key constraint (misal: sudah ada peserta)
            System.err.println("Gagal menghapus kegiatan: " + e.getMessage());
            return false;
        }
    }

    /**
     * Mengambil daftar nama untuk ComboBox dari tabel tertentu.
     */
    private ArrayList<String> getListFromTable(String tableName, String columnName) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT " + columnName + " FROM " + tableName;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(rs.getString(columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Method spesifik untuk mengisi setiap ComboBox
    public ArrayList<String> getnamaClubList() {
        return getListFromTable("club", "nama_club");
    }

    public ArrayList<String> getJenisKegiatanList() {
        return getListFromTable("jenis_kegiatan", "nama_jenis_kegiatan");
    }

    public ArrayList<String> getlokasiList() {
        return getListFromTable("lokasi", "keterangan");
    }
}