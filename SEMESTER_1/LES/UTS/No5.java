package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("batas : ");
        int N = scan.nextInt();

        int[] Arr = new int[N];
        for(int A = 0; A < N; A++)
        {
            Arr[A] = scan.nextInt();
        }

        for(int i = 0; i < N-2; i++)
        {
            if(Arr[i] + Arr[i+1] + Arr[i+2] == 0)
            {
                System.out.print("(" + Arr[i] + "," + Arr[i+1] + "," + Arr[i+2] + ") ");
            }
        }

    }
}
