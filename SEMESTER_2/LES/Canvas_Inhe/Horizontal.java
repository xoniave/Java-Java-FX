package SEMESTER_2.LES.Canvas_Inhe;

public class Horizontal extends canvas{
    private int Length;

    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        Length = length;
    }

    public Horizontal(int x, int y, char Character, int Length)
    {
        super(x,y,Character);
        this.Length = Length;
    }

    public void draw(Screen screen)
    {
        for(int A = 0; A < Length; A++)
        {
            screen.printCharAtPosition(getX() + A,getY(),getCharacter());
        }
    }
}
