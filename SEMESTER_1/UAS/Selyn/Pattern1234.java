package SEMESTER_1.UAS.Selyn;

import java.util.Scanner;

public class Pattern1234 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        for (int i = 1; i <= input-1 ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);

            }
            for (int j = (input - i) * 2; j >= 1 ; j--) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

        for (int i = 1; i <= input ; i++) {
            System.out.print(i);
        }

        for (int i = input; i >=1 ; i--) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = input - 1 ; i >= 1 ; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);

            }
            for (int j = 0; j < (input - i) * 2 ; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j);

            }
            System.out.println();
        }


    }
}
