package SEMESTER_1.LES.UAS;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String Kalimat = scan.nextLine();

        String[] Split = Kalimat.split(" ");

        for(int A = Split.length - 1; A >= 0; A--)
        {
            System.out.print(Split[A] + " ");
        }

    }
}
