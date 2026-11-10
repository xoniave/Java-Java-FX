package SEMESTER_2.digimon;

public class DIGIMON {
    private int Str,Agi,Int,Health;
    private String Nickname,Type;
    private boolean Makan,Evolved;

    public DIGIMON(int str, int agi, int anInt, int health, String Nickname, boolean Makan, String Type, boolean Evolved) {
        this.Str = str;
        this.Agi = agi;
        this.Int = anInt;
        this.Health = health;
        this.Nickname = Nickname;
        this.Makan = false;
        this.Type = Type;
        this.Evolved = Evolved;
    }

    public DIGIMON() {
        this.Str = 0;
        this.Agi = 0;
        this.Int = 0;
        this.Health = 0;
        this.Nickname = "";
        this.Makan = false;
        this.Type = "";
        this.Evolved = false;
    }

    public int getStr() {
        return Str;
    }

    public void setStr(int str) {
        Str = str;
    }

    public int getAgi() {
        return Agi;
    }

    public void setAgi(int agi) {
        Agi = agi;
    }

    public int getInt() {
        return Int;
    }

    public void setInt(int anInt) {
        Int = anInt;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public boolean isMakan() {
        return Makan;
    }

    public void setMakan(boolean makan) {
        Makan = makan;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public boolean isEvolved() {
        return Evolved;
    }

    public void setEvolved(boolean evolved) {
        Evolved = evolved;
    }
}
