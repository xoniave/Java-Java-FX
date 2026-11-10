package com.example.projectbd.CLASS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MahasiswaQuery {

    public boolean checkNrp(String nrp, String password, String status) {
        String query = "SELECT * FROM mahasiswa WHERE nrp = ? AND password = ? AND status = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);
            pst.setString(2, password);
            pst.setString(3, status);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public String getNama (String nrp){
        String query = "SELECT nama FROM mahasiswa WHERE nrp = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    return rs.getString("nama");
                }else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage();
        }

    }

    public String getEmail(String nrp)
    {
        String query = "SELECT email FROM mahasiswa WHERE nrp = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    return rs.getString("email");
                }else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage();
        }
    }

    public String getPhone(String nrp){
        String query = "SELECT phone FROM mahasiswa WHERE nrp = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    return rs.getString("phone");
                }else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage();
        }
    }

    public String getAddress(String nrp)
    {
        String query = "SELECT address FROM mahasiswa WHERE nrp = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    return rs.getString("address");
                }else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage();
        }
    }

    public String getpass(String nrp)
    {
        String query = "SELECT password FROM mahasiswa WHERE nrp = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    return rs.getString("password");
                }else {
                    return null;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage();
        }
    }


    public ArrayList <Mahasiswa> lihatMahasiswa (){
        ArrayList <Mahasiswa> dataMahasiswa = new ArrayList<>();
        String query = "select r.nama_prodi, p.nama_program, m.nrp, m.nama, m.email, m.phone, m.address,m.password, m.status from mahasiswa m join program p on m.id_program = p.id_program join prodi r on p.id_prodi = r.id_prodi;";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            System.out.println(pst);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) // rs next untuk mengecek apakah ada data nya atau tidak
                {
                    Mahasiswa mhs = new Mahasiswa(rs.getString("nama_prodi"),rs.getString("nama_program"), rs.getString("nrp"),rs.getString("nama"),rs.getString("email"), rs.getString("phone"), rs.getString("address"),rs.
                            getString("password"),rs.getString("status") );
                    dataMahasiswa.add(mhs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan saat memeriksa data mahasiswa: " + e.getMessage());
            e.printStackTrace();
        }
        return dataMahasiswa;
    }
    public ArrayList<String> getNamaProgramList() {
        ArrayList<String> programList = new ArrayList<>();
        String query = "SELECT nama_program FROM program"; // Ganti 'program' dengan nama tabel program Anda
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                programList.add(rs.getString("nama_program"));
            }
        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengambil daftar program: " + e.getMessage());
            e.printStackTrace();
        }
        return programList;
    }


    public String getIdProgram(String namaProgram) {
        // Implementasi untuk mendapatkan id_program dari nama_program
        String query = "SELECT id_program FROM program WHERE nama_program = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, namaProgram);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("id_program");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "-1";
    }
    public boolean addMahasiswa(Mahasiswa mahasiswa) {

        String query = "INSERT INTO mahasiswa (id_program, nrp, nama, email, phone, address, password, status) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        String idProgram = getIdProgram(mahasiswa.getNamaProgram());


        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, idProgram);
            pst.setString(2, mahasiswa.getNrp());
            pst.setString(3, mahasiswa.getNama());
            pst.setString(4, mahasiswa.getEmail());
            pst.setString(5, mahasiswa.getPhone());
            pst.setString(6, mahasiswa.getAddress());
            pst.setString(7, mahasiswa.getPassword());
            pst.setString(8, mahasiswa.getStatus());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry") && e.getMessage().contains("for key 'nrp'")) {
                System.err.println("Error: NRP " + mahasiswa.getNrp() + " sudah ada.");
            } else {
                System.err.println("Terjadi kesalahan saat menambahkan data mahasiswa: " + e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    public String getNamaProdiByProgram(String namaProgram) {
        String query = "SELECT r.nama_prodi FROM prodi r " +
                "JOIN program p ON r.id_prodi = p.id_prodi " +
                "WHERE p.nama_program = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, namaProgram);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nama_prodi");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat mencari nama prodi berdasarkan program: " + e.getMessage());
            e.printStackTrace();
        }
        return null; // Kembalikan null jika tidak ada yang ditemukan atau terjadi error
    }
    public boolean updateMahasiswa(Mahasiswa mahasiswa) {
        // Query UPDATE: Mengubah data pada kolom-kolom yang ditentukan
        // di mana NRP cocok dengan yang diberikan.
        String query = "UPDATE mahasiswa SET id_program = ?, nama = ?, email = ?, phone = ?, address = ?, status = ?, password = ? WHERE nrp = ?";

        // Dapatkan id_program dari nama_program terlebih dahulu
        String idProgram = getIdProgram(mahasiswa.getNamaProgram());
        if ("-1".equals(idProgram)) {
            System.err.println("Error: Program tidak ditemukan untuk update.");
            return false;
        }

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            // Mengisi nilai untuk setiap placeholder (?) sesuai urutan di query
            pst.setString(1, idProgram);
            pst.setString(2, mahasiswa.getNama());
            pst.setString(3, mahasiswa.getEmail());
            pst.setString(4, mahasiswa.getPhone());
            pst.setString(5, mahasiswa.getAddress());
            pst.setString(6, mahasiswa.getStatus());
            pst.setString(7, mahasiswa.getPassword());
            pst.setString(8, mahasiswa.getNrp()); // NRP untuk klausa WHERE (parameter terakhir)

            // Menjalankan query update
            int rowsAffected = pst.executeUpdate();

            // Mengembalikan true jika ada baris yang terpengaruh (berhasil di-update)
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengupdate data mahasiswa: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMahasiswa(String nrp)
    {
        String query = "DELETE FROM mahasiswa WHERE nrp = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {

            pst.setString(1, nrp);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error saat mencari nama prodi berdasarkan program: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}