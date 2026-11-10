package com.example.datamenu;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data_Menu {
    private SimpleStringProperty nama,jenis;
    private SimpleIntegerProperty harga,stock;

    public Data_Menu(String nama, int harga, int stock, String jenis) {
        this.nama = new SimpleStringProperty(nama);
        this.harga = new SimpleIntegerProperty(harga);
        this.stock = new SimpleIntegerProperty(stock);
        this.jenis = new SimpleStringProperty(jenis);
    }


    public String getNama() {
        return nama.get();
    }

    public SimpleStringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getJenis() {
        return jenis.get();
    }

    public SimpleStringProperty jenisProperty() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis.set(jenis);
    }

    public int getHarga() {
        return harga.get();
    }

    public SimpleIntegerProperty hargaProperty() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga.set(harga);
    }

    public int getStock() {
        return stock.get();
    }

    public SimpleIntegerProperty stockProperty() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }
}
