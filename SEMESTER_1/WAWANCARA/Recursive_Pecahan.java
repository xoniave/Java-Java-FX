package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class Recursive_Pecahan {

    public static float Pecahan(int N)
    {
        if(N == 1)
        {
            return 1;
        }

        return ((float) 1 / N) + Pecahan(N - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        System.out.println(Pecahan(N));
    }
}
