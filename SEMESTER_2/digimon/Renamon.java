package SEMESTER_2.digimon;

class Renamon extends DIGIMON {
    public Renamon(String Nickname)
    {
        super(1,1,2,3,Nickname,false,"Renamon",false);
    }

    public Renamon()
    {
        super(1,1,2,3,"",false,"Renamon",false);
    }
    public void Evo(int Str, int anInt, int Agi)
    {
        if(Str >= 15)
        {
            setStr(getStr()+20);
            setInt(getInt()+10);
            setAgi(getAgi()+10);
            setHealth(getHealth()+4);
            setType("Anubismon");
            setEvolved(true);
        }
        else if(anInt >= 15)
        {
            setStr(getStr()+10);
            setInt(getInt()+10);
            setAgi(getAgi()+20);
            setHealth(getHealth()+6);
            setType("Youkomon");
            setEvolved(true);
        }
        else if(Agi >= 15)
        {
            setStr(getStr()+10);
            setInt(getInt()+20);
            setAgi(getAgi()+10);
            setHealth(getHealth()+2);
            setType("Kyuubimon");
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
            predict = "Anubismon";
        }
        else if(getInt() > getStr() && getInt() > getAgi() )
        {
            predict = "Youkomon";
        }
        else if(getAgi() > getStr() && getAgi() > getInt() )
        {
            predict = "Kyuubimon";
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
