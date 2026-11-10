package SEMESTER_2.LES.UTS.Lat_Uts4;

import java.util.Random;

public class tictactoe {
    private char[][] papan;
    private int turn;
    private boolean oke = false;

    public boolean isOke() {
        return oke;
    }

    public void setOke(boolean oke) {
        this.oke = oke;
    }

    public tictactoe()
    {
        this.papan = new char[][]{  {' ', ' ', ' '},
                                    {' ', ' ', ' '},
                                    {' ', ' ', ' '}};
        this.turn = 1;
    }

    public int getTurn() {
        return turn;
    }

    public void printpapan()
    {
        for(int A = 0; A < papan.length; A++)
        {
            for (int B = 0; B < papan.length; B++)
            {
                System.out.print(papan[A][B]);
            }
            System.out.println();
        }
    }

    public void playTurn(int row,int col)
    {
        if(getTurn() == 1)
        {
            if(papan[row][col] == ' ')
            {
                this.papan[row][col] = 'X';
                this.oke = true;
                System.out.println("berhasil");
            }
            else
            {
                System.out.println("ada isinya");
            }
        }
        else {

            if(papan[row][col] == ' ')
            {
                this.papan[row][col] = 'O';
                this.oke = true;
            }
            else
            {
                System.out.println("ada isinya");
            }
        }
    }

    public int getvictor()
    {
        int ctrX =0;
        int ctrO = 0;
        char check = ' ';
        if(getTurn() == 1)
        {
            check = 'X';
        }
        else {
            check = 'O';
        }

        //Chek datar

        for(int A = 0; A < papan.length; A++)
        {
            ctrX = 0;
            ctrO = 0;
            for(int B = 0; B < papan.length; B++)
            {
                if(papan[A][B] == 'X')
                {
                    ctrX++;
                }

                if(papan[A][B] == 'O')
                {
                    ctrO++;
                }
            }

            if(ctrX == 3)
            {
                return 0;
            }

            if(ctrO == 3)
            {
                return 0;
            }

        }


        //check lurus
        for(int A = 0; A < papan.length; A++)
        {
            ctrX = 0;
            ctrO = 0;
            for(int B = 0; B < papan.length; B++)
            {
                if(papan[B][A] == 'X')
                {
                    ctrX++;
                }

                if(papan[B][A] == 'O')
                {
                    ctrO++;
                }
            }

            if(ctrX == 3)
            {
                return 0;
            }

            if(ctrO == 3)
            {
                return 0;
            }

        }


        //silang kanan
        ctrX = 0;
        ctrO = 0;
        for(int A = 0; A < papan.length; A++)
        {
            if(papan[A][A] == 'X')
            {
                ctrX++;
            }

            if(papan[A][A] == 'O')
            {
                ctrO++;
            }
        }

        if(ctrX == 3)
        {
            return 0;
        }

        if(ctrO == 3)
        {
            return 0;
        }


        //silang kiri
        ctrX = 0;
        ctrO = 0;
        for(int A = 0; A < papan.length; A++)
        {
            if(papan[A][papan.length - 1 - A] == 'X')
            {
                ctrX++;
            }

            if(papan[A][papan.length - 1 - A] == 'O')
            {
                ctrO++;
            }
        }
        if(ctrX == 3)
        {
            return 0;
        }

        if(ctrO == 3)
        {
            return 0;
        }



        return -1;
    }


    public void randomMove()
    {
        Random rand = new Random();
        int r = rand.nextInt(3),c = rand.nextInt(3);
        playTurn(r,c);
        System.out.println("Move (" + r + "," + c + ")");

    }

    public char[][] getPapan() {
        return papan;
    }

    public void setPapan(char[][] papan) {
        this.papan = papan;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
