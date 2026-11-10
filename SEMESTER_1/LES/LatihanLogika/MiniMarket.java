package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class MiniMarket {

    public static void Calculate(int Seratus, int Duaplh,int lima,int satu,int Kembalian)
    {

        int[] Pengeluaran = new int[]{0, 0, 0, 0};

        int Temp = 0;
        boolean Cukup = true;
        while (Kembalian > 0)
        {
            if (Kembalian >= 100 && Seratus > 0) {
                Temp = Kembalian / 100;
                if (Temp <= Seratus) {
                    Kembalian -= 100 * Temp;
                    Seratus -= Temp;
                    Pengeluaran[0] += Temp;
                } else {
                    Kembalian -= 100 * Seratus;
                    Pengeluaran[0] = Seratus;
                    Seratus = 0;
                }
            }
            else if(Kembalian >= 20 && Duaplh > 0)
            {
                Temp = Kembalian / 20;
                if(Temp <= Duaplh)
                {
                    Kembalian -= 20 * Temp;
                    Duaplh -= Temp;
                    Pengeluaran[1] += Temp;
                }
                else
                {
                    Kembalian -= 20 * Duaplh;
                    Pengeluaran[1] = Duaplh;
                    Duaplh = 0;
                }
            }
            else if(Kembalian >= 5 && lima > 0)
            {
                Temp = Kembalian / 5;
                if(Temp <= lima)
                {
                    Kembalian -= 5 * Temp;
                    lima -= Temp;
                    Pengeluaran[2] += Temp;
                }
                else
                {
                    Kembalian -= 5 * lima;
                    Pengeluaran[2] = lima;
                    lima = 0;
                }
            }
            else if (satu > 0)
            {
                Temp = Kembalian;
                if(Temp <= satu)
                {
                    Kembalian -= Temp;
                    satu -= Temp;
                    Pengeluaran[3] += Temp;
                }
                else
                {
                    Kembalian -= satu;
                    Pengeluaran[3] = satu;
                    satu = 0;
                }
            }
            else
            {
                Cukup = false;
                break;
            }
        }

        if(Cukup)
        {
            if(Pengeluaran[0] != 0)
            {
                System.out.println(Pengeluaran[0] + " lembar $100");
            }
            if(Pengeluaran[1] != 0)
            {
                System.out.println(Pengeluaran[1] + " lembar $20");
            }
            if(Pengeluaran[2] != 0)
            {
                System.out.println(Pengeluaran[2] + " lembar $5");
            }
            if(Pengeluaran[3] != 0)
            {
                System.out.println(Pengeluaran[3] + " lembar $1");
            }
        }
        else
        {
            System.out.println("Uang Dalam Mesin Tidak Cukup");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Seratus = 0,Duaplh = 0,lima = 0,satu = 0;

        System.out.println("Masukan Stok Pecahan mata uang");
        System.out.print("$100 : "); Seratus = scan.nextInt();
        System.out.print("$20 : "); Duaplh = scan.nextInt();
        System.out.print("$5 : "); lima = scan.nextInt();
        System.out.print("$1 : "); satu = scan.nextInt();

        int Kembalian = 0;
        System.out.println("Masukan uang kembalian : ");
        Kembalian = scan.nextInt();

        Calculate(Seratus,Duaplh,lima,satu,Kembalian);

    }
}
