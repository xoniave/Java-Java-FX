package SEMESTER_2.digimon;

import java.util.ArrayList;

public class PLAYER {
    private int Uang;
    private String Nama;
    private ArrayList<DIGIMON> INVENTORY = new ArrayList<>();

    public PLAYER()
    {
        this.Uang = 2000;
        this.Nama = "";
    }

    public PLAYER(int Uang,String Nama)
    {
        this.Uang = Uang;
        this.Nama = Nama;
    }

    public int getUang() {
        return Uang;
    }

    public void setUang(int uang) {
        Uang = uang;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public ArrayList<DIGIMON> getINVENTORY() {
        return INVENTORY;
    }

    public void setINVENTORY(DIGIMON DIGI) {
        INVENTORY.add(DIGI);
    }
}
