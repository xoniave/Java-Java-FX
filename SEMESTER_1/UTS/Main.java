package SEMESTER_1.UTS;

import java.util.Scanner;

public class Main {

    public static Scanner scanint = new Scanner(System.in);
    public static Scanner scanstr = new Scanner(System.in);

    public static void main(String[] args) {
        int Pilihan;
        while (true) {
            System.out.println("--SEMESTER_1.SEMESTER_2.LES.UTS--");
            System.out.println("1.Check Inputan");
            System.out.println("2.Cetak Deret");
            System.out.println("3.Pembagian Buah");
            System.out.println("4.Cetak Max 10 dan kali barisnya");
            System.out.println("0.Exit");
            System.out.print(">> ");
            Pilihan = scanint.nextInt();
            if(Pilihan == 0) break;

            switch (Pilihan)
            {
                case 1:
                    CheckInputan CI = new CheckInputan();
                    CI.Check();
                    break;
                case 2:
                    CetakDeret CD = new CetakDeret();
                    CD.cetakMulai();
                    break;
                case 3:
                    PembagianBuah PB = new PembagianBuah();
                    PB.Start();
                    break;
                case 4:
                    CetakMax10 CM10 = new CetakMax10();
                    CM10.Cetak();
                    break;
            }
        }
    }
}
