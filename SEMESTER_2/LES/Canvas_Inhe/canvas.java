package SEMESTER_2.LES.Canvas_Inhe;

public class canvas {
    private int X,Y;
    private char Character;

    public canvas(int x, int y,char Character)
    {
        this.X = x;
        this.Y = y;
        this.Character = Character;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public char getCharacter() {
        return Character;
    }

    public void setCharacter(char character) {
        Character = character;
    }

    public void draw(Screen screen)
    {
        screen.display();
    }
}
