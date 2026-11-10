package SEMESTER_1.LES.LatihanLogika;

import java.util.ArrayList;
import java.util.Scanner;

public class Subarray {
    public static void Calculate(ArrayList<Integer> Angka)
    {
        int Resize = 1,GetMax = 0,Batas = 1;
        int Index = 0,Panjang = 0;

        while (Batas != Angka.size() && Resize != Angka.size()) {
            for (int A = 0; A < Angka.size() - Resize; A++) {
                int Hitung = 0;
                for (int B = 0; B <= Batas; B++)
                {
                    Hitung += Angka.get(A+B);
                }

                if (GetMax < Hitung)
                {
                    GetMax = Hitung;
                    Index = A;
                    Panjang = Batas;
                }

            }
            Batas++;
            Resize++;
        }

        for(int A = Index; A < Index+Panjang; A++)
        {
            System.out.print(Angka.get(A) + " ");
        }

        System.out.println("Max : " + GetMax);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> Angka = new ArrayList<>();

        System.out.println("Jumlah elemen : ");
        int N = scan.nextInt();

        System.out.println("Masukan isi Array : ");
        for (int A = 0; A < N ; A++)
        {
            Angka.add(scan.nextInt());
        }
        Calculate(Angka);

    }
}
