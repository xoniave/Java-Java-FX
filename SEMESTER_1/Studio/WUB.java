package SEMESTER_1.Studio;

import java.util.Scanner;

public class WUB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String Teks = scan.nextLine();

        String[] Data = Teks.split("WUB");

        for(int A = 0; A < Data.length; A++)
        {
            if (Data[A] != "") {
                if (A != Data.length - 1) {
                    System.out.print(Data[A] + " ");
                } else {
                    System.out.print(Data[A]);
                }
            }
        }
    }
}
