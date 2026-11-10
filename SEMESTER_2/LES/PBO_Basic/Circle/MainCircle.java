package SEMESTER_2.LES.PBO_Basic.Circle;

public class MainCircle {
    public static void main(String[] args) {
        CIRCLE C1 = new CIRCLE(2.0,"blue");
        CIRCLE C2 = new CIRCLE(2.0,"red");
        CIRCLE C3 = new CIRCLE(1.0,"red");

        //C1
        System.out.println(C1.getRadius());
        System.out.println(C1.getColor());
        System.out.println(C1.getArea());
        System.out.println();

        //C2
        System.out.println(C2.getRadius());
        System.out.println(C2.getColor());
        System.out.println(C2.getArea());
        System.out.println();

        //C3
        System.out.println(C3.getRadius());
        System.out.println(C3.getColor());
        System.out.println(C3.getArea());
        System.out.println();
    }
}

class CIRCLE
{
    private double radius;
    private String color;

    public CIRCLE()
    {
        this.radius = 0.0;
        this.color = "";
    }

    public CIRCLE(double r)
    {
        this.radius = r;
    }

    public CIRCLE(double r,String c)
    {
        this.radius = r;
        this.color = c;
    }

    public double getRadius()
    {
        return this.radius;
    }

    public String getColor()
    {
        return this.color;
    }

    public double getArea()
    {
        return 3.14 * Math.pow(radius,2);
    }
}
