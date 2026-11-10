package SEMESTER_1.LES.LatihanLogika;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumDistance {

    public static void Calculate(ArrayList<Integer> Rumah)
    {

        int GetMin = 0,NoRumah = 0,Total = 0;
        for (int A = 0; A < Rumah.size(); A++)
        {
            Total = 0;

            for (int B = 0; B < Rumah.size(); B++)
            {
                if (B != A)
                {
                    Total += Math.abs(Rumah.get(A) - Rumah.get(B));
                }
            }

            if(A == 0)
            {
                GetMin = Total;
            }
            else
            {
               if(Total < GetMin)
               {
                   GetMin = Total;
                   NoRumah = Rumah.get(A);
               }
            }

        }

        System.out.println("Total Jarak Minimum : " + GetMin);
        System.out.println("Nomor Rumah : " + NoRumah);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukan Jumlah Keluarga : ");
        int Keluarga = scan.nextInt();

        ArrayList<Integer> Rumah = new ArrayList<>();
        System.out.print("Masukan Rumah : ");
        for (int A = 0; A < Keluarga; A++)
        {
            Rumah.add(scan.nextInt());
        }
        Calculate(Rumah);
    }
}
