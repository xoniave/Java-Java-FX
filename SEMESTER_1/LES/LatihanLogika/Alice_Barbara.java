package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class Alice_Barbara {
    public static void Calculate(String Txt)
    {
        int Ap = 0,Bp = 0;
        String Temp = "";
        for(int A = 0; A < Txt.length(); A+=2)
        {
            Temp = "";
            Temp += Txt.charAt(A) +""+ Txt.charAt(A+1);
            switch (Temp)
            {
                case "A1":
                    Ap +=1;
                    break;
                case "A2":
                    Ap +=2;
                    break;
                case "B1":
                    Bp +=1;
                    break;
                case "B2":
                    Bp +=2;
                    break;
            }
        }

        if(Ap >= 11 && (Ap - Bp) >= 2)
        {
            System.out.println("A");
        }
        else if( Bp >= 11 && (Bp - Ap) >= 2)
        {
            System.out.println("B");
        }
        else if(Ap == Bp)
        {
            System.out.println("tie");
        }
        else
        {
            System.out.println("Belum di tentujkan");
        }
    }

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);

        System.out.println("Masukan Input : ");
        String Txt = scanstr.nextLine();

        Calculate(Txt);
    }
}
