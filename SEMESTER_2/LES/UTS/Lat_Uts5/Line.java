package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.Random;

public class Line extends Enemy{

    public Line()
    {
        super(0,0,1);
    }

    public Line(int Baris, int Kolom,int size)
    {
        super(Baris, Kolom,size);
    }

    @Override
    public void randomize() {
        Random random = new Random();
        boolean Not_oke = true;
        while(Not_oke) {
            super.size = random.nextInt(6) + 1; // random 0 - 7
            super.Baris = random.nextInt(8); // random 0 - 7
            super.Kolom = random.nextInt(8);


            if(super.Kolom + super.size <= 7 && super.Baris + super.size <= 7)
            {
                Not_oke = false;
            }
        }

        int idx = 0;

        for(int A = super.Kolom; A < super.Kolom + super.size; A++)
        {
            super.enemyPos[super.Baris + idx][A] = '*';
            idx++;
        }
    }
}
