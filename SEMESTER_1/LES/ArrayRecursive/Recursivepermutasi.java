package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class Recursivepermutasi {

    public static int Factorial(int Angka)
    {
        if(Angka <= 1)
        {
            return 1;
        }
        return Angka * Factorial(Angka - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("N : ");
        int N = scan.nextInt();
        System.out.print("M : ");
        int M = scan.nextInt();

        int nPr = Factorial(N) / Factorial(N - M);
        System.out.print(nPr);
    }
}
