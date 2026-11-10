package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class Fibonaci {

    public static int FibonaciRecru(int A) {
        if(A == 0) {
            return 0;
        }
        else if(A == 1) {
            return 1;
        }
        return FibonaciRecru(A - 2) + FibonaciRecru(A - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int A = 0; A < N; A++) {
            System.out.print(FibonaciRecru(A) + " ");
        }
    }
}





