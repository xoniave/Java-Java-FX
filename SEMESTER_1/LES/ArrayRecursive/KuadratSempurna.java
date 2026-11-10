package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class KuadratSempurna {


    public static int Count(int Index)
    {
        return (int) Math.pow(Index,2);
    }

    public static void ListkuadratSempurna(int N,int Index,int Hitung)
    {
        Hitung = Count(Index);
        if(Hitung <= N)
        {
            System.out.print(Hitung + " ");
            ListkuadratSempurna(N,Index + 1,Hitung);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int Index = 1;

        int Hitung = 1;
        ListkuadratSempurna(N,Index,Hitung);
    }
}
