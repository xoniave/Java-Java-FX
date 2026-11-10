package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class Recursive {
    public static void Hi(int N) {
        if(N == 0) {
            System.out.println("Done");
            return;
        }
        System.out.println("Hi");
        Hi(N - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Hi(scan.nextInt());
    }
}
