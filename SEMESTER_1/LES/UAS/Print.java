package SEMESTER_1.LES.UAS;

import java.util.Scanner;

public class Print {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();


        int Spasi = (N*2) - 2;
        int KananAngka = 1;
        for(int A = 0; A < N; A++)
        {
            for(int B = 0; B <= A; B++)
            {
                System.out.print(B+1);
            }

            for (int B = 0; B < Spasi; B++)
            {
                System.out.print(" ");
            }

            for(int B = 0; B <= A; B++)
            {
                System.out.print(KananAngka - B);
            }

            KananAngka++;
            Spasi-=2;
            System.out.println();
        }

        KananAngka = N - 1;
        Spasi = 2;
        for(int A = N - 1; A > 0; A--)
        {
            for(int B = 0; B < A; B++)
            {
                System.out.print(B+1);
            }

            for (int B = 0; B < Spasi; B++)
            {
                System.out.print(" ");
            }

            for(int B = 0; B < A; B++)
            {
                System.out.print(KananAngka - B);
            }

            Spasi += 2;
            KananAngka--;
            System.out.println();
        }
    }
}
