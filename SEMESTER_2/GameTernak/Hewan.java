package SEMESTER_2.GameTernak;

public class Hewan {
    protected int Move;
    protected int HargaBeli;
    protected int HargaJual;
    protected String Status;

    public Hewan()
    {
        this.Move = 0;
        this.HargaBeli = 0;
        this.HargaJual = 0;
        this.Status = "";
    }

    public Hewan(int Move,int HargaBeli,int HargaJual,String Status)
    {
        this.Move = Move;
        this.HargaBeli = HargaBeli;
        this.HargaJual = HargaJual;
        this.Status = Status;
    }



}
