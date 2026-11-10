package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Masukan Bilangan : ");
        int n = scan.nextInt();

        int[] Arr = new int[n];

        for(int A = 0; A < n; A++)
        {
            System.out.print("bilangan " + A + " : ");
            Arr[A] = scan.nextInt();
        }


        while (true)
        {
            System.out.println("1.geser Bilangan");
            System.out.println("2.Palindrome Y/N");
            System.out.println("3.Urutkan Bilangan");
            System.out.println("4.Bilangan terkecil");
            System.out.println("5.Bilangan terbesar");
            System.out.println("Pilihan : ");
            int Pilihan = scan.nextInt();

            switch (Pilihan)
            {
                case 1:
                    int Temp = Arr[n-1];
                    for (int A = n-1; A > 0; A--)
                    {
                        Arr[A] = Arr[A-1];
                    }
                    Arr[0] = Temp;

                    break;
                case 2:

                    String Kalimat = "";
                    for(int A = 0; A < n; A++)
                    {
                        Kalimat += Arr[A];
                    }

                    String Balik = "";

                    for(int A = Kalimat.length() - 1; A >= 0; A--)
                    {
                        Balik += Kalimat.charAt(A);
                    }


                    if(Kalimat.equals(Balik))
                    {
                        System.out.println("Palindrome " + Kalimat + " = "+ Balik);
                    }
                    else {
                        System.out.println("Bukan Palindrome " + Kalimat + " = "+ Balik);
                    }

                    break;
                case 3:

                    for(int A = 0; A < n; A++)
                    {
                        for(int B = 0; B < n - A -1; B++)
                        {
                            if(Arr[B] > Arr[B+1])
                            {
                                int Temp1 = Arr[B];
                                Arr[B] = Arr[B+1];
                                Arr[B+1] = Temp1;
                            }
                        }
                    }

                    for(int A = 0; A < n; A++)
                    {
                        System.out.print(Arr[A] + " ");
                    }
                    System.out.println();

                    break;
                case 4:
                    int Terkecil = 0;
                    for(int A = 0; A < n; A++)
                    {
                        if(A == 0)
                        {
                            Terkecil = Arr[A];
                        }
                        else {
                            if(Terkecil >= Arr[A])
                            {
                                Terkecil = Arr[A];
                            }
                        }
                    }
                    System.out.println("terkecil : " + Terkecil);
                    break;
                case 5:
                    int Terbesar = 0;
                    for(int A = 0; A < n; A++)
                    {
                        if(A == 0)
                        {
                            Terbesar = Arr[A];
                        }
                        else {
                            if(Terbesar <= Arr[A])
                            {
                                Terbesar = Arr[A];
                            }
                        }
                    }
                    System.out.println("terbesar : " + Terbesar);
                    break;
            }
        }
    }
}
