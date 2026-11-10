package SEMESTER_1.LES.LatihanLogika;

import java.util.Arrays;
import java.util.Scanner;

public class A5 {

    public static void Input(int[] Students,int[] CandyPrice,int N)
    {
        Scanner scan = new Scanner(System.in);
        for(int A = 0; A < N; A++)
        {
            Students[A] = scan.nextInt();
        }

        for(int A = 0; A < N; A++)
        {
            CandyPrice[A] = scan.nextInt();
        }
    }

    public static void Check(int[] Students,int[] CandyPrice)
    {
        //sort
        for(int A = 0; A < Students.length-1; A++)
        {
            for (int B = A+1; B < Students.length; B++)
            {
                if(Students[A] < Students[B])
                {
                    int Temp = Students[A];
                    Students[A] = Students[B];
                    Students[B] = Temp;
                }

                if(CandyPrice[A] > CandyPrice[B])
                {
                    int Temp = CandyPrice[A];
                    CandyPrice[A] = CandyPrice[B];
                    CandyPrice[B] = Temp;
                }
            }
        }

        System.out.println(Arrays.toString(Students));
        System.out.println(Arrays.toString(CandyPrice));

    }

    public static void Count(int[] Students,int[] CandyPrice)
    {
        int Price = 0;

        for (int A = 0; A < Students.length; A++)
        {
            Price += Students[A] * CandyPrice[A];
        }
        System.out.println(Price);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukan N : ");
        int N = scan.nextInt();

        int[] Students = new int[N];
        int[] CandyPrice = new int[N];

        Input(Students,CandyPrice,N);
        Check(Students,CandyPrice);
        Count(Students,CandyPrice);
    }
}
