package SEMESTER_2.digimon;

class Gabumon extends DIGIMON {
    public Gabumon(String Nickname)
    {
        super(1,2,1,4,Nickname,false,"Gabumon",false);
    }

    public Gabumon()
    {
        super(1,2,1,4,"",false,"Gabumon",false);
    }
    public void Evo(int Str, int anInt, int Agi)
    {
        if(Str >= 15)
        {
            setStr(getStr()+14);
            setInt(getInt()+7);
            setAgi(getAgi()+7);
            setHealth(getHealth()+7);
            setType("Leomon");
            setEvolved(true);
        }
        else if(anInt >= 15)
        {
            setStr(getStr()+7);
            setInt(getInt()+7);
            setAgi(getAgi()+14);
            setHealth(getHealth()+12);
            setType("Icemon");
            setEvolved(true);
        }
        else if(Agi >= 15)
        {
            setStr(getStr()+7);
            setInt(getInt()+14);
            setAgi(getAgi()+7);
            setHealth(getHealth()+8);
            setType("Garurumon");
            setEvolved(true);
        }

    }
    public String toString()
    {
        String Makan_text = "Belum di beri makan";
        if (isMakan())
        {
            Makan_text = "Sudah di beri makan";
        }

        String predict = "";

        if(isEvolved())
        {
        predict = "Max Evolved";
        }
        else if(getStr() > getInt() && getStr() > getAgi())
        {
            predict = "Leomon";
        }
        else if(getInt() > getStr() && getInt() > getAgi() )
        {
            predict = "Icemon";
        }
        else if(getAgi() > getStr() && getAgi() > getInt() )
        {
            predict = "Garurumon";
        }

        return "Nickname : " + getNickname() + "\n" +
                "Class : " + getType() + "\n" +
                "Status : " + Makan_text + "\n" +
                "Str : " + getStr() + "\n" +
                "Agi : " + getAgi() + "\n" +
                "Int : " + getInt() + "\n" +
                "Health : " + getHealth() + "\n" +
                "Predict : " + predict;
    }
}
