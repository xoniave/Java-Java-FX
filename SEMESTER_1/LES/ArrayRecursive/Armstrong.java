package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class Armstrong {

    public static int JmlhDigit(int Index)
    {
        String digit = String.valueOf(Index);

        return digit.length();
    }

    public static boolean IsArmstrong(int Index,int hitung,int Digit,int original)
    {

        if(Index == 0)
        {
            return hitung == original;
        }

        hitung += (int) Math.pow(Index % 10 , Digit);


        return IsArmstrong(Index / 10,hitung,Digit,original);
    }

    public static void ListArmstrong(int N,int Index)
    {
        int hitung = 0;
        if(Index <= N)
        {
            if(IsArmstrong(Index,hitung,JmlhDigit(Index),Index))
            {
                System.out.print(Index + " ");
            }
            ListArmstrong(N,Index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int Index = 1;
        ListArmstrong(N,Index);
    }
}
