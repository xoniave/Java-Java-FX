package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("n : ");
        int n = scan.nextInt();

        int Bil1 = 1,Bil2 = 2,Hasil = 0;
        for(int A = 1; A <= n; A++)
        {
            if(A % 2 == 0)
            {
                System.out.print("(-" + Bil1 + ")" + Bil2);
                Hasil += (-Bil1) * Bil2;
            }
            else {
                System.out.print(Bil1 + "(-" + Bil2 + ")");
                Hasil += Bil1 * (-Bil2);
            }

            if(A != n)
            {
                System.out.print(" + ");
            }
            Bil1+=2;
            Bil2+=2;
        }
        System.out.print(" = " + Hasil);
    }
}
