package SEMESTER_1.LES.Recursive;

import java.util.Scanner;

public class Soal1 {

    public static Scanner scan = new Scanner(System.in);

    public static int[] Recursive(int Batas, int[] Arr,int ctr)
    {
        if(Batas != 0)
        {
            System.out.print("Masukan Nilai : ");
            Arr[ctr] = scan.nextInt();
            Recursive(Batas-1,Arr,ctr+1);

        }
        return Arr;
    }

    public static int HitungRecursive(int Batas, int[] Arr,int ctr,int Hasil)
    {
        if(Batas > 0)
        {
            Hasil += Arr[ctr];
            return HitungRecursive(Batas - 1, Arr, ctr + 1,Hasil);
        }
        return Hasil;
    }

    public static void CheckPrima(int ctr,int Batas, int[] arr)
    {
        int Check = 0;
        if(ctr < Batas)
        {
            Check = 0;
            for(int A = 1; A <= arr[ctr]; A++)
            {
                if(arr[ctr] % A == 0)
                {
                    Check++;
                }
            }
            if(Check == 2)
            {
                System.out.println(arr[ctr] + " adalah prima");
            }
            else {
                System.out.println(arr[ctr] + " Bukan prima");
            }
            CheckPrima(ctr+1,Batas,arr);
        }
    }

    public static int CheckHasil(int[] Arr,int ctr,int ada,int Pembagi)
    {

        if(Arr[ctr] % Pembagi != 0)
        {
            ada++;
        }

        return ada;
    }

    public static void FPBRecursive(int Terkecil,int[] Arr,int ctr,int Batas)
    {
        int ada = 0;
        for(int A = 2; A <= Terkecil; A++)
        {
            ada = 0;
            for(int B = 0; B < Batas; B++)
            {
                ada = CheckHasil(Arr,ctr,ada,A);
            }

            if (ada == 0)
            {
                System.out.println("FPB : " + A);
            }
            else {
                FPBRecursive(Terkecil,Arr,ctr+1,Batas);
            }
        }
    }

    public static int CariKecil(int ctr,int Batas,int[] Arr)
    {
        int kecil = 0;
        if(ctr < Batas)
        {
            if(ctr == 0)
            {
                kecil = Arr[ctr];
                return CariKecil(ctr+1,Batas,Arr);
            }else
            {
                if(kecil > Arr[ctr])
                {
                    kecil = Arr[ctr];
                }
                return CariKecil(ctr+1,Batas,Arr);
            }
        }
        return kecil;
    }

    public static void main(String[] args) {
        System.out.print("Masukan Jumlah Data : ");
        int Batas = scan.nextInt();
        int[] Arr = new int[Batas];

        int ctr = 0;
        Arr = Recursive(Batas,Arr,ctr);

        for(int A = 0; A < Batas; A++)
        {
            System.out.println("no ke " + (A+1) + " : " + Arr[A]);
        }

        int Hasil = 0;
        System.out.println("Total Hasil : " + HitungRecursive(Batas,Arr,ctr,Hasil));

        CheckPrima(ctr,Batas,Arr);
        FPBRecursive(CariKecil(ctr,Batas,Arr),Arr,ctr,Batas);

    }
}
