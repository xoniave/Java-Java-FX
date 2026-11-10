package com.example.projectbd.CLASS;

public class Club {
    private String idClub;
    private String id_Kategori;
    private String namaClub;
    private String deskripsi;
    private String tahunBerdiri;

    public Club(String idClub, String id_Kategori, String namaClub, String deskripsi, String tahunBerdiri) {
        this.idClub = idClub;
        this.id_Kategori = id_Kategori;
        this.namaClub = namaClub;
        this.deskripsi = deskripsi;
        this.tahunBerdiri = tahunBerdiri;
    }

    public String getIdClub() {
        return idClub;
    }

    public void setIdClub(String idClub) {
        this.idClub = idClub;
    }

    public String getId_Kategori() {
        return id_Kategori;
    }

    public void setId_Kategori(String id_Kategori) {
        this.id_Kategori = id_Kategori;
    }

    public String getNamaClub() {
        return namaClub;
    }

    public void setNamaClub(String namaClub) {
        this.namaClub = namaClub;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTahunBerdiri() {
        return tahunBerdiri;
    }

    public void setTahunBerdiri(String tahunBerdiri) {
        this.tahunBerdiri = tahunBerdiri;
    }
}
