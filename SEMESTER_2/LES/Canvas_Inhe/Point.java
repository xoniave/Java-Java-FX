package SEMESTER_2.LES.Canvas_Inhe;

class Point extends canvas{
    public Point(int x,int y,char Character)
    {
        super(x, y, Character);
    }

    public void draw(Screen screen)
    {
        screen.printCharAtPosition(getX(),getY(),getCharacter());
    }
}
