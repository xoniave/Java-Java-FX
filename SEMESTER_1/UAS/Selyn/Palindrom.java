package SEMESTER_1.UAS.Selyn;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String n = scan.nextLine();

        boolean sama = true;
        for(int A = 0; A < n.length() / 2; A++)
        {
            System.out.println(n.charAt(A) + " " + n.charAt(n.length() - 1 - A));
            if(n.charAt(A) != n.charAt(n.length() - 1 - A))
            {
                sama = false;
                break;
            }
        }

        if(!sama)
        {
            System.out.print("Bukan Palindrom");
        }
        else {
            System.out.print("Palindrom");
        }
    }
}
