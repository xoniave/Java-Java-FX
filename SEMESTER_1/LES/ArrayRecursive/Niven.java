package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class Niven {

    public static int JmlhDigit(int Index,int hitung)
    {
        if(Index == 0)
        {
            return hitung;
        }

        hitung += Index % 10 ;
        return JmlhDigit(Index / 10,hitung);
    }

    public static boolean IsNiven(int Index)
    {
        int hitung = 0;
        return Index % JmlhDigit(Index,hitung) == 0;
    }

    public static void ListNiven(int N , int Index)
    {
        if(Index <= N)
        {
            if(IsNiven(Index))
            {
                System.out.print(Index + " ");
            }
            ListNiven(N,Index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int Index = 1;

        ListNiven(N,Index);
    }
}
