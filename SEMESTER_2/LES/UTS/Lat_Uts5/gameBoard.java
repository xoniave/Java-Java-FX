package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.ArrayList;
import java.util.Random;

public class gameBoard {

    private char[][] papan;
    private ArrayList<Enemy> Data_Enemy = new ArrayList<>();
    private int score = 0;

    public gameBoard()
    {
        this.papan = new char[][]   {{'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},
                                    {'.','.','.','.','.','.','.','.'},};
    }

    public void Initialize() //membuat 5 objek ,musuh
    {
        for(int A = 0; A < 5; A++)
        {
            Random rand = new Random();
            int acak = rand.nextInt(3);

            switch (acak)
            {
                case 0:
                    Enemy D = new Dot();
                    D.randomize();
                    Data_Enemy.add(D);
                    break;
                case 1:
                    Enemy L = new Line();
                    L.randomize();
                    Data_Enemy.add(L);
                    break;
                case 2:
                    Enemy S = new Square();
                    S.randomize();
                    Data_Enemy.add(S);
                    break;
            }
        }
    }

    public void printBoard()
    {
        System.out.println("Curent Score (" + score + "/64)");
        for(int A = 0; A < papan.length; A++)
        {
            for(int B = 0; B < papan.length; B++)
            {
                System.out.print(papan[A][B]);
            }
            System.out.println();
        }
    }

    public void kunciJawaban()
    {
        for(int A = 0; A < Data_Enemy.size(); A++)
        {
            Data_Enemy.get(A).checkpos();
            System.out.println("--------------------");
        }

        System.out.println("Your score is " + score + " / 64");
    }

    public boolean isGameOver()
    {
        for(int A = 0; A < papan.length; A++)
        {
            for (int B = 0; B < papan.length; B++)
            {
                for(int C = 0; C < Data_Enemy.size(); C++)
                {
                    if(papan[A][B] == '.' && Data_Enemy.get(C).enemyPos[A][B] == '*')
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int shootAt(int r,int c)
    {

        int ctr = 0;

        if(papan[r][c] == '.') {
            score++;
            for (int A = 0; A < Data_Enemy.size(); A++) {
                if (Data_Enemy.get(A).checkHit(r, c)) {
                    ctr++;
                }
            }

            if (ctr == 0) {
                this.papan[r][c] = '0';
            } else {
                this.papan[r][c] = (char) ((char) ctr + 48);
            }

            return ctr;
        }
        else {
            System.out.println("Sudah di tebak");
            return -1;
        }
    }
}
