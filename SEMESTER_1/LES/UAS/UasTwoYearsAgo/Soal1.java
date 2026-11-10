package SEMESTER_1.LES.UAS.UasTwoYearsAgo;

import java.util.Scanner;

public class Soal1 {


    public static int Faktorial(int N)
    {
        if(N <= 0)
        {
            return 1;
        }

        return N * Faktorial(N - 1);
    }

    public static float hitungjarak(int Baris1, int Baris2, int[][] DataTitik)
    {
        //calculate
        int x1 = DataTitik[Baris1][1];
        int x2 = DataTitik[Baris2][1];
        int y1 = DataTitik[Baris1][2];
        int y2 = DataTitik[Baris2][2];

        //rumus
        return (float) Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
    }

    public static float[][] HitungSemua(int[][] DataTitik,int N)
    {
        float[][] output = new float[Faktorial(N) / (Faktorial(2) * Faktorial(N - 2))][3];  //BIKIN ARRAY BARU 2D PANJANG DARI PERHITUNGAN SEMBUA KOMBINASI YG BISA DI DAPAT

        //index tracking KARENA FOR SESUAI PANJANG N
        int Idx = 0;

        //kombinasi
        for(int A = 0; A < N; A++)
        {
            for(int B = A + 1; B < 3; B++)
            {
                output[Idx][0] = DataTitik[A][0];
                output[Idx][1] = DataTitik[B][0];
                output[Idx][2] = hitungjarak(DataTitik[A][0] - 1,DataTitik[B][0] - 1,DataTitik); //SETIAP KALI KOMBINASI BARIS (1 2, 1 3 , 2 3)
                Idx++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[][] DataTitik = new int[N][3];

        //Syarat 2 < N < 10
        if(N > 2 && N < 10) {

            //Mengisi titik di Array
            for (int A = 0; A < N; A++) {
                DataTitik[A][0] = A + 1;
                System.out.print("Masukan titik X & Y : ");
                for (int B = 0; B < 3; B++) {
                    if (B != 0) {
                        DataTitik[A][B] = scan.nextInt();
                    }
                }
            }

            //Cetak Semua Titik
            for(int A = 0; A < N; A++)
            {
                for (int B = 0; B < 3; B++)
                {
                    System.out.print(DataTitik[A][B] + " ");
                }
                System.out.println();
            }

            float[][] DataTitik1 = HitungSemua(DataTitik,N); //perhitungan

            System.out.println("--------------------------------------------------------------");
            //Cetak Semua Titik
            for(int A = 0; A < N; A++)
            {
                for (int B = 0; B < 3; B++)
                {
                    if(B == 2)
                    {
                        System.out.print(DataTitik1[A][B] + " ");
                    }
                    else {
                        System.out.print((int)DataTitik1[A][B] + " ");
                    }
                }
                System.out.println();
            }


        }
        else {
            System.out.println("Tidak Sesuai requirements");
        }
    }
}
