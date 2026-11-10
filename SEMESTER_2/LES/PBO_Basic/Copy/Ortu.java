package SEMESTER_2.LES.PBO_Basic.Copy;

public class Ortu {
    private String Nama;
    private int Umur;

    public Ortu()
    {
        setAll("",0);
    }

    public Ortu(String Nama, int Umur)
    {
        setAll(Nama,Umur);
    }

    public void setAll(String Nama, int Umur)
    {
        this.Nama = Nama;
        this.Umur = Umur;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public int getUmur() {
        return Umur;
    }

    public void setUmur(int umur) {
        Umur = umur;
    }

    public String toString()
    {
        return "Nama : " + getNama() + " Umur : " + getUmur();
    }
}
