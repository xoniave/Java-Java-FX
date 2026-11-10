package SEMESTER_2.LES.UTS.Lat_Uts4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        tictactoe TT = new tictactoe();

        Scanner scanint = new Scanner(System.in);
        int Row = 0,Col = 0;
        boolean start = true;

        while (start)
        {
            if(TT.getTurn() == 1)
            {
                while (!TT.isOke()) {
                    System.out.println("Row : ");
                    Row = scanint.nextInt();
                    System.out.println("Col : ");
                    Col = scanint.nextInt();

                    TT.playTurn(Row, Col);
                }

                TT.printpapan();

               if(TT.getvictor() == 0)
               {
                   System.out.println("player 1 win");
                   start = false;
               }
               else if(TT.getvictor() == 1)
               {

                   System.out.println("player 2 win");
                   start = false;
               }
               else if(TT.getvictor() == 2){

                   System.out.println("draw");
                   start = false;
               }

                TT.setTurn(2);
                TT.setOke(false);
            }
            else {

                while (!TT.isOke()) {
                    TT.randomMove();
                }

                TT.printpapan();

                if(TT.getvictor() == 0)
                {
                    System.out.println("player 1 win");
                    start = false;
                }
                else if(TT.getvictor() == 1)
                {

                    System.out.println("player 2 win");
                    start = false;
                }
                else if(TT.getvictor() == 2){

                    System.out.println("draw");
                    start = false;
                }
                TT.setTurn(1);
                TT.setOke(false);
            }
        }
    }
}
