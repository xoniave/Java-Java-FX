package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.Random;

public class Enemy {

    protected int Baris,Kolom,size;
    protected char[][] enemyPos = new char[][]     {{' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '},
                                                    {' ',' ',' ',' ',' ',' ',' ',' '}};

    public Enemy()
    {
        this.size = 0;
        this.Baris = 0;
        this.Kolom = 0;
    }

    public Enemy(int Baris,int Kolom, int size)
    {
        this.Baris = Baris;
        this.Kolom = Kolom;
        this.size = size;
    }

    public void randomize()
    {
        Random random = new Random();
        this.Baris = random.nextInt(8); // random 0 - 7
        this.Kolom = random.nextInt(8);
    }

    public boolean checkHit(int b,int k)
    {
        return enemyPos[b][k] == '*';
    }

    public int getBaris() {
        return Baris;
    }

    public void setBaris(int baris) {
        Baris = baris;
    }

    public int getKolom() {
        return Kolom;
    }

    public void setKolom(int kolom) {
        Kolom = kolom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getEnemyPos() {
        return enemyPos;
    }

    public void setEnemyPos(char[][] enemyPos) {
        this.enemyPos = enemyPos;
    }

    public void checkpos()
    {
        for(int A = 0; A < enemyPos.length; A++)
        {
            for(int B = 0; B < enemyPos.length; B++)
            {
                System.out.print(enemyPos[A][B]);
            }
            System.out.println();
        }
    }
}
