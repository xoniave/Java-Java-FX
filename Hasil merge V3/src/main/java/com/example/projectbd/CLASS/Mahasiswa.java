package com.example.projectbd.CLASS;

public class Mahasiswa {
    private String namaProdi;
    private String namaProgram;
    private String nrp;
    private String nama;
    private String email;
    private String address;
    private String status;
    private String password;
    private String phone;

    public Mahasiswa(){

    }
    public Mahasiswa(String namaProdi, String namaProgram, String nrp, String nama, String email, String phone, String address,String password ,String status) {
        this.namaProdi = namaProdi;
        this.namaProgram = namaProgram;
        this.nrp = nrp;
        this.nama = nama;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.status = status;
    }

    public String getNamaProdi() {
        return namaProdi;
    }
    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public String getNamaProgram() {
        return namaProgram;
    }

    public void setNamaProgram(String namaProgram) {
        this.namaProgram = namaProgram;
    }

    public String getNrp() {
        return nrp;
    }

    public void setNrp(String nrp) {
        this.nrp = nrp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}