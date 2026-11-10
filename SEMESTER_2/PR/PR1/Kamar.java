package SEMESTER_2.PR.PR1;

import java.util.ArrayList;

public class Kamar {
    int No_Kamar,Luas;
    ArrayList<Perabotan> Data_Perabotan = new ArrayList<>();

    public Kamar(int No_Kamar, int Luas)
    {
        this.No_Kamar = No_Kamar;
        this.Luas = Luas;
    }

    void Add_Perabotan(String Nama, String Bahan)
    {
        Data_Perabotan.add(new Perabotan(Nama,Bahan));
    }

    public void Tampilkan()
    {
        System.out.println( "Kamar no : " + this.No_Kamar + ",Luas : " + this.Luas);
        for(int A =0; A < Data_Perabotan.size(); A++)
        {
            Data_Perabotan.get(A).tampilkaninfo();
        }
    }
}
