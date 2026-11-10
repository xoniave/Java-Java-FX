package com.example.projectbd.CLASS;

import java.time.LocalDate;

public class Keanggotaan {
    private String idKeanggotaan;
    private String idClub;
    private String nrp;
    private String peran;
    private LocalDate tanggalBergabung;
    private String statusKeanggotaan;

    public Keanggotaan(String idKeanggotaan, String idClub, String nrp, String peran, LocalDate tanggalBergabung, String statusKeanggotaan) {
        this.idKeanggotaan = idKeanggotaan;
        this.idClub = idClub;
        this.nrp = nrp;
        this.peran = peran;
        this.tanggalBergabung = tanggalBergabung;
        this.statusKeanggotaan = statusKeanggotaan;
    }

    public String getIdKeanggotaan() {
        return idKeanggotaan;
    }

    public void setIdKeanggotaan(String idKeanggotaan) {
        this.idKeanggotaan = idKeanggotaan;
    }

    public String getIdClub() {
        return idClub;
    }

    public void setIdClub(String idClub) {
        this.idClub = idClub;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    public LocalDate getTanggalBergabung() {
        return tanggalBergabung;
    }

    public void setTanggalBergabung(LocalDate tanggalBergabung) {
        this.tanggalBergabung = tanggalBergabung;
    }

    public String getStatusKeanggotaan() {
        return statusKeanggotaan;
    }

    public void setStatusKeanggotaan(String statusKeanggotaan) {
        this.statusKeanggotaan = statusKeanggotaan;
    }
}
