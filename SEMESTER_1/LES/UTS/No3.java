package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String Angka = scan.nextLine();

        int Terkecil = 0;
        int Terbesar = 0;

        for (int A = 0; A < Angka.length(); A++) {
            int digit = Angka.charAt(A) - '0';

            if(A == 0)
            {
                Terkecil = Angka.charAt(A) - '0';
                Terbesar = Angka.charAt(A) - '0';
            }

            if (digit < Terkecil) {
                Terkecil = digit;
            }

            if (digit > Terbesar) {
                Terbesar = digit;
            }
        }

        System.out.println("Terbesar : " + Terbesar);
        System.out.println("Terkecil : " + Terkecil);
    }
}
