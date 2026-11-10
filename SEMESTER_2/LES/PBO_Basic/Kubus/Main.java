package SEMESTER_2.LES.PBO_Basic.Kubus;

public class Main {
    public static void main(String[] args) {
        TKubus Kubus = new TKubus(5,5,5);
        System.out.println(Kubus);

    }
}

class TKubus
{
    private int Panjang,Lebar,Tinggi;

    public TKubus()
    {
        this.Panjang = 0;
        this.Lebar = 0;
        this.Tinggi = 0;
    }

    public TKubus(int Panjang,int Lebar,int Tinggi)
    {
        this.Panjang = Panjang;
        this.Lebar = Lebar;
        this.Tinggi = Tinggi;
    }

    public float Luas()
    {
        return (float) (6 * Math.pow(this.Lebar,2));
    }

    public float Volume()
    {
        return (float) Math.pow(this.Lebar,3);
    }

    public int getPanjang() {
        return Panjang;
    }

    public void setPanjang(int panjang) {
        Panjang = panjang;
    }

    public int getLebar() {
        return Lebar;
    }

    public void setLebar(int lebar) {
        Lebar = lebar;
    }

    public int getTinggi() {
        return Tinggi;
    }

    public void setTinggi(int tinggi) {
        Tinggi = tinggi;
    }

    public String toString()
    {
        return getPanjang() + " - " + getLebar() + " - " + getTinggi() + " - " + Luas() + " - " + Volume();
    }
}
