package com.example.projectbd.CLASS;

import java.time.LocalDate;

public class KegiatanClub {
    private String idKegiatanClub;
    private String idJenisKegiatan; // ID jenis kegiatan
    private String namaJenisKegiatan; // Nama jenis kegiatan (dari join)
    private String idClub; // ID Club
    private String namaClub; // Nama Club (dari join)
    private String idLokasi; // ID Lokasi
    private String keteranganLokasi; // Keterangan Lokasi (dari join)
    private String namaKegiatan;
    private LocalDate tanggalKegiatan;

    // Tambahan untuk menampung data partisipasi jika kegiatan sudah didaftar
    private LocalDate tanggalDaftar;
    private String peranPartisipasi;
    private String statusKehadiran; // Properti untuk status kehadiran
    private boolean dapatSertifikat; // Properti: apakah kegiatan ini dapat sertifikat
    private boolean statusSertifikat; // Properti baru: status sertifikat bagi peserta (sekarang boolean)
    private String nomorSertifikat; // Properti baru: nomor sertifikat

    // Constructor untuk data yang akan ditampilkan di UI (semua kegiatan)
    public KegiatanClub(String idKegiatanClub, String namaJenisKegiatan, String namaClub, String keteranganLokasi, String namaKegiatan, LocalDate tanggalKegiatan, boolean dapatSertifikat) {
        this.idKegiatanClub = idKegiatanClub;
        this.namaJenisKegiatan = namaJenisKegiatan;
        this.namaClub = namaClub;
        this.keteranganLokasi = keteranganLokasi;
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.dapatSertifikat = dapatSertifikat;
    }

    // Constructor khusus untuk kegiatan yang sudah didaftar (termasuk tanggal daftar, peran, kehadiran, status sertifikat, dan nomor sertifikat)
    public KegiatanClub(String idKegiatanClub, String namaJenisKegiatan, String namaClub, String keteranganLokasi, String namaKegiatan, LocalDate tanggalKegiatan, LocalDate tanggalDaftar, String peranPartisipasi, String statusKehadiran, boolean statusSertifikat, String nomorSertifikat) {
        this(idKegiatanClub, namaJenisKegiatan, namaClub, keteranganLokasi, namaKegiatan, tanggalKegiatan, false); // dapatSertifikat akan di-overwrite jika diperlukan
        this.tanggalDaftar = tanggalDaftar;
        this.peranPartisipasi = peranPartisipasi;
        this.statusKehadiran = statusKehadiran;
        this.statusSertifikat = statusSertifikat; // Inisialisasi properti baru (boolean)
        this.nomorSertifikat = nomorSertifikat;
    }

    // Konstruktor lengkap, jika Anda ingin menyertakan ID mentah dari tabel join
    public KegiatanClub(String idKegiatanClub, String idJenisKegiatan, String namaJenisKegiatan, String idClub, String namaClub, String idLokasi, String keteranganLokasi, String namaKegiatan, LocalDate tanggalKegiatan, boolean dapatSertifikat) {
        this.idKegiatanClub = idKegiatanClub;
        this.idJenisKegiatan = idJenisKegiatan;
        this.namaJenisKegiatan = namaJenisKegiatan;
        this.idClub = idClub;
        this.namaClub = namaClub;
        this.idLokasi = idLokasi;
        this.keteranganLokasi = keteranganLokasi;
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.dapatSertifikat = dapatSertifikat;
    }

    // --- Getters for all properties ---
    public String getIdKegiatanClub() { return idKegiatanClub; }
    public String getIdJenisKegiatan() { return idJenisKegiatan; }
    public String getNamaJenisKegiatan() { return namaJenisKegiatan; }
    public String getIdClub() { return idClub; }
    public String getNamaClub() { return namaClub; }
    public String getIdLokasi() { return idLokasi; }
    public String getKeteranganLokasi() { return keteranganLokasi; }
    public String getNamaKegiatan() { return namaKegiatan; }
    public LocalDate getTanggalKegiatan() { return tanggalKegiatan; }

    // Getters for participation-specific properties
    public LocalDate getTanggalDaftar() { return tanggalDaftar; }
    public String getPeranPartisipasi() { return peranPartisipasi; }
    public String getStatusKehadiran() { return statusKehadiran; }
    public boolean isDapatSertifikat() { return dapatSertifikat; }
    public boolean isStatusSertifikat() { return statusSertifikat; } // Getter untuk properti baru (boolean)
    public String getNomorSertifikat() { return nomorSertifikat; }

    // --- Setters for all properties ---
    public void setIdKegiatanClub(String idKegiatanClub) { this.idKegiatanClub = idKegiatanClub; }
    public void setIdJenisKegiatan(String idJenisKegiatan) { this.idJenisKegiatan = idJenisKegiatan; }
    public void setNamaJenisKegiatan(String namaJenisKegiatan) { this.namaJenisKegiatan = namaJenisKegiatan; }
    public void setIdClub(String idClub) { this.idClub = idClub; }
    public void setNamaClub(String namaClub) { this.namaClub = namaClub; }
    public void setIdLokasi(String idLokasi) { this.idLokasi = idLokasi; }
    public void setKeteranganLokasi(String keteranganLokasi) { this.keteranganLokasi = keteranganLokasi; }
    public void setNamaKegiatan(String namaKegiatan) { this.namaKegiatan = namaKegiatan; }
    public void setTanggalKegiatan(LocalDate tanggalKegiatan) { this.tanggalKegiatan = tanggalKegiatan; }

    // Setters for participation-specific properties
    public void setTanggalDaftar(LocalDate tanggalDaftar) { this.tanggalDaftar = tanggalDaftar; }
    public void setPeranPartisipasi(String peranPartisipasi) { this.peranPartisipasi = peranPartisipasi; }
    public void setStatusKehadiran(String statusKehadiran) { this.statusKehadiran = statusKehadiran; }
    public void setDapatSertifikat(boolean dapatSertifikat) { this.dapatSertifikat = dapatSertifikat; }
    public void setStatusSertifikat(boolean statusSertifikat) { this.statusSertifikat = statusSertifikat; } // Setter untuk properti baru (boolean)
    public void setNomorSertifikat(String nomorSertifikat) { this.nomorSertifikat = nomorSertifikat; }
}