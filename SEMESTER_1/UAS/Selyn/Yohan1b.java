package SEMESTER_1.UAS.Selyn;

import java.util.Arrays;
import java.util.Scanner;

public class Yohan1b {

    public static void Kombinasi(int N,int Stok1,int Stok2,int Stok3, int[] Biner)
    {
        int Jumlah = 0;
        if(Biner[0] <= Stok1 && Biner[1] <= Stok2 && Biner[2] <= Stok3)
        {
            for(int A = 0; A < Biner[0]; A++)
            {
                Jumlah += 1;
            }
            for(int A = 0; A < Biner[1]; A++)
            {
                Jumlah += 2;
            }
            for(int A = 0; A < Biner[2]; A++)
            {
                Jumlah += 3;
            }
        }
        if(Jumlah == N)
        {
            System.out.println(Arrays.toString(Biner));
        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Deklarasi Variabel
        int n = scan.nextInt();
        int Stok1 = scan.nextInt();
        int Stok2 = scan.nextInt();
        int Stok3 = scan.nextInt();

        int[] Biner = {0,0,0};

        //Search Terbesar untuk basis Biner
        int Basis = Math.max(Stok1, Math.max(Stok2, Stok3));

        int Min = 0;
        while (Min < Biner.length)
        {
            if(Biner[2 - Min] < Basis)
            {
                Biner[2 - Min] = Biner[2 - Min] + 1;
                Min = 0;
                Kombinasi(n,Stok1,Stok2,Stok3,Biner);
            }
            else if(Biner[2 - Min] == Basis){
                Biner[2 - Min] = 0;
                Min++;
            }
        }
    }
}
