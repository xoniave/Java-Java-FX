package com.example.projectbd.CLASS;

import java.time.LocalDate;

public class DaftarPartisipasi {
    private String idPartisipasi;
    private String nrpMahasiswa;
    private String namaMahasiswa;
    private String idKegiatanClub;
    private String namaKegiatan;
    private LocalDate tanggalKegiatan;
    private String statusKehadiran;
    private boolean statusSertifikat; // Sekarang boolean
    private String nomorSertifikat;
    private boolean dapatSertifikatKegiatan; // Menandakan apakah kegiatan ini secara umum memberikan sertifikat

    public DaftarPartisipasi(String idPartisipasi, String nrpMahasiswa, String namaMahasiswa,
                              String idKegiatanClub, String namaKegiatan, LocalDate tanggalKegiatan,
                              String statusKehadiran, boolean statusSertifikat, String nomorSertifikat,
                              boolean dapatSertifikatKegiatan) {
        this.idPartisipasi = idPartisipasi;
        this.nrpMahasiswa = nrpMahasiswa;
        this.namaMahasiswa = namaMahasiswa;
        this.idKegiatanClub = idKegiatanClub;
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.statusKehadiran = statusKehadiran;
        this.statusSertifikat = statusSertifikat;
        this.nomorSertifikat = nomorSertifikat;
        this.dapatSertifikatKegiatan = dapatSertifikatKegiatan;
    }

    // --- Getters ---
    public String getIdPartisipasi() { return idPartisipasi; }
    public String getNrpMahasiswa() { return nrpMahasiswa; }
    public String getNamaMahasiswa() { return namaMahasiswa; }
    public String getIdKegiatanClub() { return idKegiatanClub; }
    public String getNamaKegiatan() { return namaKegiatan; }
    public LocalDate getTanggalKegiatan() { return tanggalKegiatan; }
    public String getStatusKehadiran() { return statusKehadiran; }
    public boolean isStatusSertifikat() { return statusSertifikat; } // Getter untuk boolean
    public String getNomorSertifikat() { return nomorSertifikat; }
    public boolean isDapatSertifikatKegiatan() { return dapatSertifikatKegiatan; }


    // --- Setters ---
    public void setIdPartisipasi(String idPartisipasi) { this.idPartisipasi = idPartisipasi; }
    public void setNrpMahasiswa(String nrpMahasiswa) { this.nrpMahasiswa = nrpMahasiswa; }
    public void setNamaMahasiswa(String namaMahasiswa) { this.namaMahasiswa = namaMahasiswa; }
    public void setIdKegiatanClub(String idKegiatanClub) { this.idKegiatanClub = idKegiatanClub; }
    public void setNamaKegiatan(String namaKegiatan) { this.namaKegiatan = namaKegiatan; }
    public void setTanggalKegiatan(LocalDate tanggalKegiatan) { this.tanggalKegiatan = tanggalKegiatan; }
    public void setStatusKehadiran(String statusKehadiran) { this.statusKehadiran = statusKehadiran; }
    public void setStatusSertifikat(boolean statusSertifikat) { this.statusSertifikat = statusSertifikat; } // Setter untuk boolean
    public void setNomorSertifikat(String nomorSertifikat) { this.nomorSertifikat = nomorSertifikat; }
    public void setDapatSertifikatKegiatan(boolean dapatSertifikatKegiatan) { this.dapatSertifikatKegiatan = dapatSertifikatKegiatan; }
}
