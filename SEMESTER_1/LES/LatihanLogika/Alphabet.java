package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class Alphabet {

    public static boolean Diff(int ABCDE, int FGHIJ)
    {
        String Temp = ABCDE + "" + FGHIJ;

        int ctr = 0;
        for(int A = 0; A < Temp.length(); A++)
        {
            ctr = 0;
            for(int B = 0; B < Temp.length(); B++)
            {
                if(Temp.charAt(A) == Temp.charAt(B))
                {
                    ctr++;
                }
            }

            if(ctr > 1)
            {
                return false;
            }

        }
        return true;
    }

    public static void Calculate(int N)
    {
        boolean ada = false;
        for(int A = 1234; A <= 98765; A++)
        {
            if(A % N == 0) {
                for (int B = 1234; B <= 98765; B++) {
                    double Temp = (double) A /B;
                    if (Diff(A, B) && Temp == N) {
                        System.out.println(A + "/" + B + " : " + N);
                        ada = true;
                    }
                }
            }
        }

        if(!ada)
        {
            System.out.println("No solution");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan N : ");
        int N = scan.nextInt();

        Calculate(N);
    }
}
