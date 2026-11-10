package SEMESTER_2.LES.PBO_Basic.Point;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        POINT P1 = new POINT(10,5);
        POINT P2 = new POINT(7,2);
        System.out.println(P1.distance(P2));
    }
}

class POINT {
    private int x,y;

    public POINT()
    {
        this.x = 0;
        this.y = 0;
    }

    public POINT(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String toString()
    {
        return "(" + Arrays.toString(getXY()) + ")";
    }

    public int[] getXY()
    {
        return new int[]{getX(), getY()};
    }

    public void setXY(int x,int y)
    {
        setX(x);
        setY(y);
    }

    public double distance(int x, int y)
    {
        return Math.sqrt(Math.pow(this.x - x,2) + Math.pow(this.y - y,2));
    }

    public double distance()
    {
        return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
    }

    public double distance(POINT another)
    {
        return Math.sqrt(Math.pow(this.x - another.getX(),2) + Math.pow(this.y - another.getY(),2));
    }

}