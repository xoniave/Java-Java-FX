package SEMESTER_1.LES.ArrayRecursive;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Soal1 {

    public static boolean IsPrime(int Angka,int Pembagi,int Ctr)
    {
        if(Pembagi <= Angka)
        {
            if(Angka % Pembagi == 0)
            {
                Ctr++;
            }

            return IsPrime(Angka,Pembagi+1,Ctr);
        }
        else {
            if(Ctr == 2)
            {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static void FilterPrime(ArrayList<Integer> DataAngka, int Index)
    {

        int Pembagi = 1,Ctr = 0;

        if(Index < DataAngka.size()) {
            if (IsPrime(DataAngka.get(Index), Pembagi, Ctr)) {
                System.out.print(DataAngka.get(Index) + " ");
            }

            FilterPrime(DataAngka, Index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> DataAngka = new ArrayList<>();
        Random rand = new Random();
        int Index = 0;

        int N = scan.nextInt();

        for(int A = 0; A < N; A++)
        {
            int Acak = rand.nextInt(99) + 1;
            DataAngka.add(Acak);
        }

        System.out.println(DataAngka);


        FilterPrime(DataAngka,Index);


    }
}
