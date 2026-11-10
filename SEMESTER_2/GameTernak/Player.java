package SEMESTER_2.GameTernak;

public class Player {
    private int Px,Py,Gold;

    public Player()
    {
        this.Px = 0;
        this.Py = 0;
        this.Gold = 100;
    }

    public int getPx() {
        return Px;
    }

    public int getPy() {
        return Py;
    }

    public void setPx(int px) {
        Px = px;
    }

    public void setPy(int py) {
        Py = py;
    }

    public int getGold() {
        return Gold;
    }

    public void setGold(int gold) {
        Gold = gold;
    }
}
