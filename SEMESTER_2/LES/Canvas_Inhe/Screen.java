package SEMESTER_2.LES.Canvas_Inhe;

public class Screen {
    private char[][] Layar;
    private static final int Baris = 10,Kolom = 20;

    public Screen()
    {
        this.Layar = new char[Baris][Kolom];

        //Isi ' '
        for(int A = 0; A < Baris; A++)
        {
            for (int B = 0; B < Kolom; B++)
            {

//                if(A == 0 || A == Baris - 1 || B == 0 || B == Kolom - 1)
//                {
//                    this.Layar[A][B] = '#';
//                }
//                else {
//
//                }
                this.Layar[A][B] = ' ';

            }
        }
    }


    public void printCharAtPosition(int x,int y,char character)
    {
        if(x < 0 || x >= Kolom || y < 0 || y >= Baris)
        {
            System.out.println("Coordinate out of bond");
            return;
        }
        this.Layar[y][x] = character;
    }


    void display()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();


        for (int A = 0; A < Baris; A++)
        {
            for (int B = 0; B < Kolom; B++)
            {
                System.out.print(this.Layar[A][B]);
            }
            System.out.println();
        }
    }
}
