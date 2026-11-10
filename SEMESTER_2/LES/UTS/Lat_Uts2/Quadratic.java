package SEMESTER_2.LES.UTS.Lat_Uts2;

public class Quadratic extends Linear{

    private int c;

    public Quadratic(int a,int b,int c)
    {
        super(a, b);
        this.c = c;
    }

    public Quadratic()
    {
        super(1, 1);
        this.c = 1;
    }

    @Override
    public float CalculateFunction(float x) {
        return (float) (this.a * Math.pow(x,2) + (this.b * x) + c);
    }

    @Override
    public void cetak() {
        System.out.println("f(x) = ax^2 + bx + c");
    }
}
