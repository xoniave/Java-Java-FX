package SEMESTER_1.LES.UAS.UasTwoYearsAgo;

import java.util.ArrayList;
import java.util.Scanner;

public class Soal2 {

    public static Scanner scanint = new Scanner(System.in);
    public static Scanner scanstr = new Scanner(System.in);

    public static void PrintMenu()
    {
        System.out.println("=======================================");
        System.out.println("          TOKO KOMPUTER MELATI         ");
        System.out.println("=======================================");
        System.out.println("1. Tambah Komponen");
        System.out.println("2. Update Stok Komponen");
        System.out.println("3. Hapus Data Komponen");
        System.out.println("4. Tampilkan Semua");
        System.out.println("5. keluar");
        System.out.print("Pilihan : ");
    }

    public static void TambahKomponen(ArrayList<String> DataNama, ArrayList<Integer> DataStok)
    {
        System.out.print("Masukan Nama Komponen : ");
        DataNama.add(scanstr.nextLine());

        System.out.print("Jumlah Stok Awal : ");
        DataStok.add(scanint.nextInt());

        System.out.println("Sucess");
    }

    public static void UpdateKomponen(ArrayList<String> DataNama, ArrayList<Integer> DataStok)
    {
        boolean Finish = false;

        System.out.println("Tulis Keluar/keluar untuk berhenti");
        while (!Finish)
        {
            System.out.print("Nama Komponen : ");
            String Nama = scanstr.nextLine();

            if(Nama.equalsIgnoreCase("Keluar"))
            {
                break;
            }

            for(int A = 0; A < DataNama.size(); A++)
            {
                if(Nama.equals(DataNama.get(A)))
                {
                    Finish = true;
                    System.out.print("Jumlah Stok terbaru : ");
                    DataStok.set(A,scanint.nextInt());
                    break;
                }
            }

            if(!Finish)
            {
                System.out.println("Komponen tidak ditemukan, mohon inputkan kembali !");
            }
        }
    }

    public static void HapusData(ArrayList<String> DataNama, ArrayList<Integer> DataStok)
    {
        boolean Finish = false;

        System.out.println("Tulis Keluar/keluar untuk berhenti");
        while (!Finish)
        {
            System.out.print("Nama Komponen : ");
            String Nama = scanstr.nextLine();

            if(Nama.equalsIgnoreCase("Keluar"))
            {
                break;
            }

            for(int A = 0; A < DataNama.size(); A++)
            {
                if(Nama.equals(DataNama.get(A)))
                {
                    DataNama.remove(A);
                    DataStok.remove(A);
                    Finish = true;
                    break;
                }
            }

            if(!Finish)
            {
                System.out.println("Komponen tidak ditemukan, mohon inputkan kembali !");
            }
        }
    }

    public static void TampilkanSemua(ArrayList<String> DataNama, ArrayList<Integer> DataStok)
    {
        System.out.println("Data Komponen : ");
        for(int A = 0; A < DataNama.size(); A++)
        {
            System.out.println("Komponen - " + A+1);
            System.out.println("Nama Komponen : " + DataNama.get(A));
            System.out.println("Jumlah Stok : " + DataStok.get(A));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> DataNama = new ArrayList<>();
        ArrayList<Integer> DataStok = new ArrayList<>();

        boolean Loop = true;
        while (Loop)
        {
            PrintMenu();
            switch (scanint.nextInt())
            {
                case 1:
                    TambahKomponen(DataNama,DataStok);
                    break;
                case 2:
                    UpdateKomponen(DataNama,DataStok);
                    break;
                case 3:
                    HapusData(DataNama,DataStok);
                    break;
                case 4:
                    TampilkanSemua(DataNama,DataStok);
                    break;
                case 5:
                    Loop = false;
                    break;
            }
        }
    }
}
