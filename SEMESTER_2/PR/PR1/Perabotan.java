package SEMESTER_2.PR.PR1;

public class Perabotan {
    String Nama_Perabotan,Bahan;

    public Perabotan(String Nama_Perabotan,String Bahan)
    {
        this.Nama_Perabotan = Nama_Perabotan;
        this.Bahan = Bahan;
    }

    public void tampilkaninfo()
    {
        System.out.println("Perabotan : \n" + this.Nama_Perabotan + "\n" + "Bahan : " + this.Bahan + "\n");
    }

}
