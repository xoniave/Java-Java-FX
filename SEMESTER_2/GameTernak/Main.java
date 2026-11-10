package SEMESTER_2.GameTernak;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanStr = new Scanner(System.in);

        Board B = new Board();
        Player P = new Player();
        while (true)
        {
            B.initialized();
            System.out.println("Money : " + P.getGold());
            System.out.println("Move (WASD), B: Buy, Q: Quit > ");
            String gerak = scanStr.nextLine();

            if(gerak.equalsIgnoreCase("Q"))
            {
                break;
            }
            else if(gerak.equalsIgnoreCase("B"))
            {
                B.Shop(P);
            }
            else {
                B.PlayerGerak(gerak,P);
            }



            B.AnimalMove();
        }
    }
}
