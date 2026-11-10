package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No1 {

    public static void Langka(int Hari,int Total)
    {
        int Denda = 0;

        if(Hari <= 3)
        {
            System.out.println("Total Denda : 0,00");
        }
        else {
            Hari -= 3; //BATAS SEBELUM DENDA

            int ctr = 0;
            while(Hari > 0)
            {
                if(ctr < 4)
                {
                    Denda += 1000;
                }
                else if(ctr < 7)
                {
                    Denda += 2500;
                }
                else {
                    Denda += 5000;
                }
                ctr++;
                Hari--;
            }
            System.out.println("Total Denda : " + (Denda * Total) + ",00");
        }
    }

    public static void NonLangka(int Hari,int Total)
    {
        if(Hari <= 7)
        {
            System.out.println("Total Denda : 0,00");
        }
        else
        {
            int Denda = 0;
            Hari -= 7;

            while (Hari > 0)
            {
                Denda += 500;
                Hari--;
            }
            System.out.println("Total Denda : " + (Denda * Total) + ",00");
        }
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int Pilihan;
        while(true) {
            System.out.println("1.Buku Kategori Langka");
            System.out.println("2.Buku Kategori Non Langka");
            System.out.println("0.Exit");
            System.out.print(">> ");
            Pilihan = scan.nextInt();

            if(Pilihan == 0)break;

            int Hari,Total;
            System.out.print("Jumlah Buku : ");
            Total = scan.nextInt();
            System.out.println("Brp Hari Pinjam : ");
            Hari = scan.nextInt();

            switch (Pilihan)
            {
                case 1:
                    Langka(Hari,Total);
                    break;
                case 2:
                    NonLangka(Hari,Total);
                    break;
            }
        }
    }
}
