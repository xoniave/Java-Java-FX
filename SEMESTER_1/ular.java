package SEMESTER_1;

import java.util.Scanner;

public class ular {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N,M,O;

        System.out.print("N : ");
        N = scan.nextInt();
        System.out.print("M : ");
        M = scan.nextInt();
        System.out.print("O : ");
        O = scan.nextInt();

        int ctr = 0,Angka = 1,pangkat = 1;
        while (Math.floor((double) N /M) - ctr != 0) {
            for(int B = 1; B <= ctr;B++)
            {
                pangkat *= O;
            }
            for (int A = 0; A < 7; A++) {
                System.out.print(Angka * pangkat + " ");
                Angka++;
            }
            System.out.println();
            ctr++;
        }
        pangkat *= O;
        for(int A = Angka; A <= N; A++)
        {
            System.out.print(Angka * pangkat + " ");
            Angka++;
        }
    }

}
