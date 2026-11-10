package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.Random;

public class Dot extends Enemy{

    public Dot()
    {
        super(0,0,0);
    }

    public Dot(int Baris,int Kolom,int size)
    {
        super(Baris,Kolom,size);
    }

    @Override
    public void randomize() {
        Random random = new Random();
        super.Baris = random.nextInt(8); // random 0 - 7
        super.Kolom = random.nextInt(8);
        super.enemyPos[super.Baris][super.Kolom] = '*';
    }
}
