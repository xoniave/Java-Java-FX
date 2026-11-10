package SEMESTER_1.LES.UAS;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arraymanip {

    public static void Random(ArrayList<Integer> Data, int Awal,int Ahkir, int N)
    {
        Random rand = new Random();
        for(int A = 0; A < N; A++)
        {
            int Acak = rand.nextInt(Ahkir - Awal) + Awal;

            Data.add(Acak);
        }
        System.out.println(Data);
    }

    public static void HighestDupe(ArrayList<Integer> Data)
    {
        ArrayList<Integer> Dupe = new ArrayList<>();
        ArrayList<Integer> Frekuensi = new ArrayList<>();

        for(int A = 0; A < Data.size(); A++)
        {
            if(A == 0)
            {
                Dupe.add(Data.get(A));
                Frekuensi.add(1);
            }
            else{

                boolean Ada = false;
                for(int B = 0; B < Dupe.size(); B++)
                {
                    if(Data.get(A) == Dupe.get(B))
                    {
                        Frekuensi.set(B, Frekuensi.get(B) + 1);
                        Ada = true;
                        break;
                    }
                }

                if(!Ada)
                {
                    Dupe.add(Data.get(A));
                    Frekuensi.add(1);
                }
            }
        }

        //Search highest Frek
        int Highest = 0;
        int IndexHighest = 0;
        for(int A = 0; A < Frekuensi.size(); A++)
        {
            if(Highest < Frekuensi.get(A))
            {
                Highest = Frekuensi.get(A);
            }
        }

        if(Highest == 1) //LANGSUNG CARI TERTINGGI KARENA FREK !
        {
            Highest = 0;
            for(int A = 0; A < Dupe.size(); A++)
            {
                if(Highest < Dupe.get(A))
                {
                    Highest = Dupe.get(A);
                }
            }

            System.out.print("Dupe tertinggi = " + Highest);
        }
        else {

            ArrayList<Integer> Filter = new ArrayList<>();

            //AMBIL YANG FREK HIGEST AJA
            for(int A = 0; A < Frekuensi.size(); A++)
            {
                if(Frekuensi.get(A) == Highest)
                {
                    Filter.add(Dupe.get(A));
                }
            }

            Highest = 0;
            //SEARCH HIGHEST
            for(int A = 0; A < Filter.size(); A++)
            {
                if(Highest < Filter.get(A))
                {
                    Highest = Filter.get(A);
                }
            }

            System.out.print("Dupe tertinggi = " + Highest);
        }
    }

    public static void Unique (ArrayList<Integer> Data)
    {
        ArrayList<Integer> Dupe = new ArrayList<>();
        ArrayList<Integer> Frekuensi = new ArrayList<>();

        for(int A = 0; A < Data.size(); A++)
        {
            if(A == 0)
            {
                Dupe.add(Data.get(A));
                Frekuensi.add(1);
            }
            else{

                boolean Ada = false;
                for(int B = 0; B < Dupe.size(); B++)
                {
                    if(Data.get(A) == Dupe.get(B))
                    {
                        Frekuensi.set(B, Frekuensi.get(B) + 1);
                        Ada = true;
                        break;
                    }
                }

                if(!Ada)
                {
                    Dupe.add(Data.get(A));
                    Frekuensi.add(1);
                }
            }
        }

        System.out.println(Dupe);
        System.out.println(Frekuensi);

        int Highest = 0;
        for(int A = 0; A < Frekuensi.size(); A++)
        {
            if(Frekuensi.get(A) == 1)
            {
                if(A == Frekuensi.size() - 1)
                {
                    System.out.print(Dupe.get(A));
                }
                else {
                    System.out.print(Dupe.get(A) + " ");
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Rawal = 0,Rahkir = 0,N = 0;

        while (true)
        {
            System.out.print("Input N (5 - 20) : ");
            N = scan.nextInt();
            if(N  >= 5 && N <= 20)
            {
                break;
            }
        }

        while (true)
        {
            System.out.print("Input Range Awal : ");
            Rawal = scan.nextInt();
            System.out.print("Input Range Ahkir : ");
            Rahkir = scan.nextInt();

            if(Rahkir - Rawal > 5 && Rahkir - Rawal < 15)
            {
                break;
            }
            else {
                System.out.println("selisih tidak lebih dari 5 dan kurang dari 15");
            }
        }
        //Deklarasi variable dan array
        ArrayList<Integer> Data = new ArrayList<>();

        Random(Data,Rawal,Rahkir,N);

        HighestDupe(Data);
        Unique(Data);
    }
}
