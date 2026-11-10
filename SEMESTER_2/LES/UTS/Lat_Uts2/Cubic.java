package SEMESTER_2.LES.UTS.Lat_Uts2;

public class Cubic extends Linear{

    private int c,d;

    public Cubic (int a,int b,int c,int d)
    {
        super(a, b);
        this.c = c;
        this.d = d;
    }

    public Cubic()
    {
        super(1, 1);
        this.c = 1;
        this.d = 1;
    }

    @Override
    public float CalculateFunction(float x) {
        return (float) (this.a * Math.pow(x,3) + this.b * Math.pow(x,2) + (this.c * x) + d);
    }

    @Override
    public void cetak() {
        System.out.println("f(x) = ax^3 + bx^2 + cx + d");
    }
}
