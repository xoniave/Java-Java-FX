package SEMESTER_2.LES.UTS.Lat_Uts2;

public class Linear {

    protected int a,b;

    public Linear(int a,int b)
    {
        this.a = a;
        this.b = b;
    }

    public Linear()
    {
        this.a = 1;
        this.b = 1;
    }


    public float CalculateFunction(float x) {
        return ((this.a * x) + this.b);
    }

    public void cetak() {
        System.out.println("f(x) = ax + b");
    }
}
