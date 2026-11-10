package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class Recursive_Pangkat {

    public static int Pangkat(int Angka,int Pangkat)
    {
        if(Pangkat == 1)
        {
            System.out.print(Angka + " = ");
            return Angka;
        }

        System.out.print(Angka + " x ");
        return Angka * Pangkat(Angka,Pangkat - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Angka : ");
        int Angka = scan.nextInt();
        System.out.print("Pangkat : ");
        int Pangkat = scan.nextInt();

        System.out.print(Angka + "^" + Pangkat + " = ");
        System.out.print(Pangkat(Angka,Pangkat));
    }
}
