package SEMESTER_1.LES.UAS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pembilang = 0,penyebut = 0;

        try {
            pembilang = scan.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Eror: input tidak valid, harap masukan angka!");
            System.out.println(e.getMessage());
        }

        try {
            penyebut = scan.nextInt();
            try {
                System.out.print(pembilang / penyebut);
            }
            catch (ArithmeticException e)
            {
                System.out.println("Eror: Tidak dapat membagi dengan nol!");
                System.out.println(e.getMessage());
            }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Eror: input tidak valid, harap masukan angka!");
            System.out.println(e.getMessage());
        }

    }
}
