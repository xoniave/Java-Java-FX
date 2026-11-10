package SEMESTER_2.PR.PR1;

import java.util.ArrayList;

public class Rumah {
    String Alamat;
    ArrayList<Kamar> Data_Kamar = new ArrayList<>();

    public Rumah(String Alamat)
    {
        this.Alamat = Alamat;
    }

    void Add_Kamar(int No_Kamar, int Luas)
    {
        Data_Kamar.add(new Kamar(No_Kamar,Luas));
    }

    public Kamar getData_Kamar(int idx) {
        return Data_Kamar.get(idx);
    }

    public String toString()
    {
        return "Rumah dengan alamat : " + Alamat + "\n";
    }
}
