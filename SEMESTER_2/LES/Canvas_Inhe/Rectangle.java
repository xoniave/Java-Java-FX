package SEMESTER_2.LES.Canvas_Inhe;

public class Rectangle extends canvas{
    private int Tinggi,Lebar;


    public Rectangle(int x, int y, char Character, int Tinggi,int Lebar)
    {
        super(x,y,Character);
        this.Tinggi = Tinggi;
        this.Lebar = Lebar;
    }

    public void draw(Screen screen)
    {
        for(int A = 0; A < Tinggi; A++)
        {
            //SISI BERDIRI
            screen.printCharAtPosition(getX() + Lebar,getY() + A,getCharacter());
            screen.printCharAtPosition(getX(),getY() + A,getCharacter());
        }

        for (int A = 0; A <= Lebar; A++)
        {
            screen.printCharAtPosition(getX() + A,getY(),getCharacter());
            screen.printCharAtPosition(getX() + A,getY() + Tinggi,getCharacter());
        }
    }
}
