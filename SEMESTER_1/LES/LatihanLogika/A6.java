package SEMESTER_1.LES.LatihanLogika;

import java.util.ArrayList;
import java.util.Scanner;

public class A6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> Hari = new ArrayList<>();


        System.out.println("Masukan biji");
        int N = scan.nextInt();

        for (int A = 0; A < N; A++)
        {
            Hari.add(scan.nextInt());
        }

        for(int A = 0; A < Hari.size() - 1; A++)
        {
            for (int B = A+1; B <  Hari.size(); B++)
            {
                if(Hari.get(A) < Hari.get(B))
                {
                    int Temp = Hari.get(A);
                    Hari.set(A,Hari.get(B));
                    Hari.set(B,Temp);
                }
            }
        }

        int Maxday = 0,CurrentDay = 0;
        for(int A = 1; A <= Hari.size(); A++)
        {
            CurrentDay = A + Hari.get(A-1);
            if(CurrentDay > Maxday)
            {
                Maxday = CurrentDay;
            }
        }

        System.out.println("Max Day : " + (Maxday+1));
    }
}
