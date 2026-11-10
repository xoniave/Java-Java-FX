package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class Recursive_Faktorial {

    public static int Faktorial(int Angka){
        if(Angka == 1)
        {
            System.out.print(Angka);
            return 1;
        }
        int x = Angka * Faktorial(Angka - 1);
        System.out.print(" x " + Angka);
        return x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Angka = scan.nextInt();
        System.out.println(" = " + Faktorial(Angka));
    }
}
