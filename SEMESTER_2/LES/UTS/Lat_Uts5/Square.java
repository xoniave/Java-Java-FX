package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.Random;

public class Square extends Enemy{

    public Square()
    {
        super(0,0,1);
    }

    public Square(int Baris, int Kolom,int size)
    {
        super(Baris,Kolom,size);
    }

    @Override
    public void randomize() {
        Random random = new Random();
        boolean Not_oke = true;
        while(Not_oke) {
            super.size = random.nextInt(6) + 1; // random 0 - 7
            super.Baris = random.nextInt(8); // random 0 - 7
            super.Kolom = random.nextInt(8);

            if(super.Kolom + super.size <= 7 && super.Baris + super.size <= 7 && super.Kolom - super.size >= 0 && super.Baris - super.size >= 0)
            {
                Not_oke = false;
            }
        }


        for(int A = super.Baris - super.size; A < super.Baris + super.size; A++)
        {
            for(int B = super.Kolom - super.size; B < super.Kolom + super.size; B++)
            {
                super.enemyPos[A][B] = '*';
            }
        }
    }
}
