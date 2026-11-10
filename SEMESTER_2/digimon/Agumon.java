package SEMESTER_2.digimon;

class Agumon extends DIGIMON{

    public Agumon(String Nickname)
    {
        super(2,1,1,5,Nickname,false,"Agumon",false);
    }

    public Agumon()
    {
        super(2,1,1,5,"",false,"Agumon",false);
    }


    public void Evo(int Str, int anInt, int Agi)
    {
        if(Str >= 15)
        {
            setStr(getStr()+10);
            setInt(getInt()+5);
            setAgi(getAgi()+5);
            setHealth(getHealth()+5);
            setType("Greymon");
            setEvolved(true);
        }
        else if(anInt >= 15)
        {
            setStr(getStr()+5);
            setInt(getInt()+10);
            setAgi(getAgi()+5);
            setHealth(getHealth()+6);
            setType("Meramon");
            setEvolved(true);
        }
        else if(Agi >= 15)
        {
            setStr(getStr()+5);
            setInt(getInt()+5);
            setAgi(getAgi()+10);
            setHealth(getHealth()+10);
            setType("Centarumon");
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
            predict = "Greymon";
        }
        else if(getInt() > getStr() && getInt() > getAgi() )
        {
            predict = "Meramon";
        }
        else if(getAgi() > getStr() && getAgi() > getInt() )
        {
            predict = "Centaurmon";
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
