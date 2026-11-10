package SEMESTER_2.LES.UTS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Jeruk Store = new Jeruk();

        System.out.println("Paket : ");
        int Paket = scan.nextInt();

        for(int A = 0; A < Paket; A++)
        {
            System.out.print("Paket ke-" + (A+1) + " : ");
            int Dim = scan.nextInt();
            System.out.print("Jumlah = ");
            int jmlh = scan.nextInt();

            Store.SetJmlh(Dim,jmlh);
        }
        System.out.println(Store);
    }
}
