package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class A3 {

    public static boolean CheckDivideable(int L)
    {
        String Temp = String.valueOf(L);

        int Temp1 = Integer.parseInt(Temp);

        for(int A = 0; A < Temp.length(); A++)
        {
            int pembagi = Temp1 % 10;
            if(pembagi == 0)
            {
                return false;
            }
            else {

                System.out.println(L + " % " + pembagi);

                if (L % pembagi != 0) {
                    return false;
                }
            }
            Temp1 = Temp1/10;
        }
        return true;
    }

    public static boolean CheckAllDiff(int L)
    {
        String Temp = String.valueOf(L);

        for(int A = 0; A < Temp.length(); A++)
        {
            int ctr = 0;
            for(int B = 0; B < Temp.length(); B++)
            {
                if(Temp.charAt(A) == Temp.charAt(B))
                {
                    ctr++;
                }
            }
            if (ctr > 1)
            {
                return false;
            }
        }
        return true;
    }
    public static int Output(int L,int H)
    {
        int Kombinasi = 0;

        for(int A = L ; A <= H; A++)
        {
            if(CheckDivideable(A) && CheckAllDiff(A))
            {
                Kombinasi++;
            }
        }

        return Kombinasi;
    }

    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);

        String Line;

        Line = scanstr.nextLine();

        String[] Split = Line.split(" ");

        int L = Integer.parseInt(Split[0]);
        int H = Integer.parseInt(Split[1]);

        if(L < 123456 || H > 987654)
        {
            System.out.println("Tidak sesuai Inputan");
        }
        else
        {
            System.out.println(Output(L,H));
        }
    }
}
