package SEMESTER_1.Studio;

import java.util.Scanner;

public class TahunBaru {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Jumlah = scan.nextInt();

        int[] DataTeman = new int[Jumlah];

        for(int A = 0; A < Jumlah; A++)
        {
            DataTeman[A] = scan.nextInt();
        }

        int[] Hasil = new int[Jumlah];
        for(int A = 1; A <= Jumlah; A++)
        {
            Hasil[DataTeman[A - 1] - 1] = A;
        }

        for(int A = 0; A < Jumlah; A++)
        {
            System.out.print(Hasil[A]+ " ");
        }
    }
}
