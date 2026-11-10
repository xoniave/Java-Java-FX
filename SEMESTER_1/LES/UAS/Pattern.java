package SEMESTER_1.LES.UAS;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        String N = scanstr.nextLine();
        int pola = scanint.nextInt();

        int idx = 0;
        String Hasil = "";
        for(int A = 0; A < N.length(); A++)
        {
            idx = A;
            if(idx + pola > N.length())
            {
                Hasil += N.charAt(idx + (N.length() % pola));
            }
            else {
                Hasil += N.charAt(idx + pola);
            }
        }

        System.out.println(Hasil);
    }
}

