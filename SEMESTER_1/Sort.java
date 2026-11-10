package SEMESTER_1;

import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] Array = {1,6,7,9,4,3,8,2};

        System.out.println("1.Bubel sort");
        System.out.println("2.Selection sort");
        System.out.print(">> ");

        switch (scan.nextInt())
        {
            case 1:
                for(int B = 0; B < Array.length; B++) {
                    for (int A = 0; A < Array.length - 1 - B; A++) {
                        if (Array[A] > Array[A + 1]) {
                            int Temp = Array[A];
                            Array[A] = Array[A + 1];
                            Array[A + 1] = Temp;
                        }
                    }
                }

                for(int A = 0; A < Array.length; A++)
                {
                    System.out.print(Array[A] + " ");
                }
                break;
            case 2:

                for(int A = 0; A < Array.length - 1; A++)
                {
                    for (int B = A+1; B < Array.length; B++)
                    {
                        if (Array[A] > Array[B])
                        {
                            int Temp = Array[A];
                            Array[A] = Array[B];
                            Array[B] = Temp;
                        }
                    }
                }

                for(int A = 0; A < Array.length; A++)
                {
                    System.out.print(Array[A] + " ");
                }

                break;
        }
    }
}
