package SEMESTER_2.LES.UTS.Lat_Uts5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        gameBoard board = new gameBoard();
        board.Initialize();
        board.printBoard();
        do{
            System.out.println("Input Koordinat Tembakan:");
            System.out.print("Row: ");
            int r = input.nextInt();
            System.out.print("Column: ");
            int c = input.nextInt();
            int hit = board.shootAt(r, c);
            System.out.println(hit + " enemies hit...");
            board.printBoard();
        }while(!board.isGameOver());

        System.out.println("Kunci Jawban");
        board.kunciJawaban();
    }
}
