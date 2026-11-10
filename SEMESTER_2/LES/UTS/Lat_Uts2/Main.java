package SEMESTER_2.LES.UTS.Lat_Uts2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        int a = 0,b = 0,c = 0,d = 0;


        System.out.println("ingin rubah atribute data linear? y/t");
        String pilih = scanstr.nextLine();

        Linear L = new Linear();
        if(pilih.equalsIgnoreCase("y"))
        {

            while (a == 0 || b == 0)
            {
                System.out.println("Masukan A : ");
                a = scanint.nextInt();

                System.out.println("Masukan B : ");
                b = scanint.nextInt();

            }
            L = new Linear(a,b);
        }

        System.out.println("ingin rubah atribute data Quardatic? y/t");
        pilih = scanstr.nextLine();


        a = 0;
        b = 0;
        c = 0;
        d = 0;

        Linear Q = new Quadratic();
        if(pilih.equalsIgnoreCase("y"))
        {

            while (a == 0 || b == 0 || c == 0)
            {
                System.out.println("Masukan A : ");
                a = scanint.nextInt();

                System.out.println("Masukan B : ");
                b = scanint.nextInt();

                System.out.println("Masukan C : ");
                c = scanint.nextInt();
            }
            Q = new Quadratic(a,b,c);
        }


        a = 0;
        b = 0;
        c = 0;
        d = 0;

        System.out.println("ingin rubah atribute data Cubic? y/t");

        pilih = scanstr.nextLine();

        Linear C = new Cubic();
        if(pilih.equalsIgnoreCase("y"))
        {

            while (a == 0 || b == 0 || c == 0 || d == 0)
            {
                System.out.println("Masukan A : ");
                a = scanint.nextInt();

                System.out.println("Masukan B : ");
                b = scanint.nextInt();

                System.out.println("Masukan C : ");
                c = scanint.nextInt();

                System.out.println("Masukan D : ");
                d = scanint.nextInt();
            }
            C = new Cubic(a,b,c,d);
        }


        System.out.println("Masukan Nilai X Linear : ");
        int X = scanint.nextInt();

        L.cetak();
        System.out.println(L.CalculateFunction(X));
        Q.cetak();
        System.out.println(Q.CalculateFunction(X));
        C.cetak();
        System.out.println(C.CalculateFunction(X));



    }
}
