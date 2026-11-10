package SEMESTER_1.LES.LatihanLogika;

import java.util.Scanner;

public class A1 {

    public static boolean Check(String Text)
    {

        for(int A = 0; A <= Text.length() - 4; A++)
        {
            String Temp = "";
            for(int B = 0; B < 4; B++)
            {
                Temp = Temp + Text.charAt(A+B);
            }

            if(Temp.equalsIgnoreCase("ROSE") || Temp.equalsIgnoreCase("PINK"))
            {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        System.out.print("Sample Input : ");
        int N = scanint.nextInt();

        int Attend = 0;
        for (int A = 0; A < N; A++)
        {
            System.out.print("Sample ke " + (A+1) + " : ");
            if(Check(scanstr.nextLine()))
            {
                Attend++;
            }
        }

        if(Attend > 1)
        {
            System.out.println("Attend : " + Attend);
        }
        else
        {
            System.out.println("I must watch star wars with my daughter");
        }
    }
}
