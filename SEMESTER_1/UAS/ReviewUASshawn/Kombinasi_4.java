package SEMESTER_1.UAS.ReviewUASshawn;

import java.util.Scanner;

public class Kombinasi_4 {
    public static void main(String[] args) {
        Scanner scanstr = new Scanner(System.in);

        System.out.print("kalimat = ");
        String S = scanstr.nextLine();

        System.out.print("search = ");
        String search = scanstr.nextLine();

        int[] Biner = new int[S.length()];
        for(int A = 0; A < S.length(); A++)
        {
            Biner[A] = 0;
        }

        int Min = 0;
        int count = 0;
        while(Min < Biner.length)
        {
            if(Biner[S.length() - 1 - Min] == 0)
            {
                Biner[S.length() - 1 - Min] = 1;
                Min = 0;

                String Temp = "";
                for(int A = 0; A < Biner.length; A++)
                {
                    if(Biner[A] == 1)
                    {
                        Temp += S.charAt(A);
                    }
                }

                if(Temp.equalsIgnoreCase(search))
                {
                    count++;
                }
            }
            else if(Biner[S.length() - 1 - Min] == 1){
                Biner[S.length() - 1 - Min] = 0;
                Min++;
            }
        }

        System.out.println(count);

    }
}
