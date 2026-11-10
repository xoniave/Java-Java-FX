package SEMESTER_1.WAWANCARA;

import java.util.Scanner;

public class test {

    public static int Fibonacci (int idx)
    {
        if(idx == 0)
        {
            return 0;
        }
        else if(idx == 1)
        {
            return 1;
        }

        return Fibonacci(idx - 2) + Fibonacci(idx - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(Fibonacci(scan.nextInt()));
    }
}
