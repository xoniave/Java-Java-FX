package SEMESTER_1.LES.ArrayRecursive;

import java.util.Scanner;

public class Pell {

    public static void ListPel(int N,int index)
    {
        if(index <= N) {
            if (index == 1) {
                System.out.print(1 + " ");
            }
            else if (index ==  0) {
                System.out.print(0 + " ");
            }
            else
            {
                int Bil1 = 2 * (index - 1);
                int Bil2 = index - 2;

                System.out.print( (Bil1 + Bil2) + " ");
            }
            ListPel(N,index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int index = 0;
        ListPel(N,index);

    }
}
