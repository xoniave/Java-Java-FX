package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class PerfectNum {

    public static boolean IsPerfect(int Angka,int ctr,int Count)
    {
        if(ctr != 0)
        {
            if(Angka % ctr == 0)
            {
                Count+= ctr;
            }
            return IsPerfect(Angka, ctr - 1, Count);
        }

        if(Count == Angka)
        {
            return true;
        }
        return false;
    }

    public static void  ListPerfect(int N,int Index)
    {
        int ctr = Index - 1;
        int Count = 0;
        if(Index <= N) {
            if (IsPerfect(Index,ctr,Count)) {
                System.out.print(Index + " ");
            }
            ListPerfect(N, Index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int Index = 1;
        ListPerfect(N,Index);
    }
}
