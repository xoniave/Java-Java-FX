package SEMESTER_1.Studio;

import java.util.Scanner;
public class RecurPascalsingkat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascal(i,j) + " ");
            }
            System.out.println();
        }
    }
    public static int pascal(int  row, int column) {
        if (column ==0 || row == column)
        {
            return 1;
        }
        return pascal(row-1,column-1)+ pascal(row-1, column);
    }
}