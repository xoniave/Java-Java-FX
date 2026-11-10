package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        Scanner scan  = new Scanner(System.in);
        int Baris = 0,Kolom = 0;
        int[][] Mtx;

        System.out.println("baris : ");
        Baris = scan.nextInt();
        System.out.println("kolom : ");
        Kolom = scan.nextInt();

        Mtx = new int[Baris][Kolom];
        while(true)
        {
            System.out.println("1.Input Matriks");
            System.out.println("2.Total isi Array");
            System.out.println("3.Total isi per baris");
            System.out.println("4.Total isi per Kolom");
            System.out.println("0.Exit");
            System.out.print(">> ");
            int Pilihan = scan.nextInt();

            if(Pilihan == 0)break;

            switch (Pilihan)
            {
                case 1:

                    for(int A = 0; A < Baris; A++)
                    {
                        for (int B = 0; B < Kolom; B++)
                        {
                            Mtx[A][B] = scan.nextInt();
                        }
                    }
                    break;
                case 2:
                    int Hasil = 0;

                    for(int A = 0; A < Baris; A++)
                    {
                        for (int B = 0; B < Kolom; B++)
                        {
                            Hasil += Mtx[A][B];
                        }
                    }
                    System.out.println(Hasil);

                    break;
                case 3:
                    int Hasil1 = 0;

                    for(int A = 0; A < Baris; A++)
                    {
                        Hasil = 0;
                        for (int B = 0; B < Kolom; B++)
                        {
                            Hasil += Mtx[A][B];
                        }
                        System.out.println(Hasil);
                    }
                    break;
                case 4:
                    int Hasil2 = 0;

                    for(int A = 0; A < Kolom; A++)
                    {
                        Hasil2 = 0;
                        for (int B = 0; B < Baris; B++)
                        {
                            Hasil2 += Mtx[B][A];
                        }
                        System.out.println(Hasil2);
                    }
                    break;
            }
        }
    }
}
