package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No6 {
    public static boolean Palindrom(int Angka)
    {
        if(Angka < 10)
        {
            return true;
        }
        else {

            String A1 = String.valueOf(Angka);
            String Temp = "";

            for(int A = A1.length()-1; A >= 0; A--)
            {
                Temp += A1.charAt(A);
            }

            if(A1.equals(Temp))
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("n = ");
        int n = scan.nextInt();

        int ctr = 1;
        int prim = 0;

        while (n != 0)
        {
            //check prima
            for(int A = 1; A <= ctr; A++)
            {
                if(ctr % A == 0)
                {
                    prim++;
                }
            }

            if(prim == 2)
            {
                if(Palindrom(ctr))
                {
                    n--;
                    System.out.print(ctr + " ");
                }
            }
            prim = 0;
            ctr++;
       }
    }
}
