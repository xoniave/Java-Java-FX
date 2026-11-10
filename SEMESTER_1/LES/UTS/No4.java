package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class No4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1.Segitiga 1");
            System.out.println("2.Segitiga 2");
            System.out.println("3.Segitiga 3");
            System.out.println("4.Segitiga 4");
            System.out.println("0.Exit");
            System.out.print(">> ");
            int Pilihan = scan.nextInt();

            if (Pilihan == 0) break;

            System.out.println("Masukan M & N: ");
            int M = scan.nextInt();

            switch (Pilihan) {
                case 1:

                    for(int A = 0; A < M; A++)
                    {
                        for(int B = 0; B < M-1-A; B++)
                        {
                            System.out.print(" ");
                        }

                        for(int B = 0; B <= A+A; B++)
                        {
                            if(B == 0 || B == A+A || A == M-1)
                            {
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for(int A = 0; A < M; A++)
                    {
                        for(int B = 0; B <= A; B++)
                        {
                            if(B == 0 || B == A)
                            {
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }

                    for(int A = M-1; A > 0; A--)
                    {
                        for (int B = A; B > 0; B--)
                        {
                            if(B == A || B == 1)
                            {
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int ctr = 0;
                    for(int A = 0; A < M; A++)
                    {
                        //spasi
                        for(int B = 0; B < A; B++)
                        {
                            System.out.print(" ");
                        }

                        //segitiga
                        for(int B = (M*2)-1 - ctr; B > 0; B--)
                        {
                            if(A==0 || B == 1 || B == (M*2)-1 - ctr)
                            {
                                System.out.print("*");
                            }
                            else {
                                System.out.print(" ");
                            }
                        }
                        ctr+=2;
                        System.out.println();
                    }

                    break;
                case 4:
                    for(int A = 0; A < M; A++)
                    {
                        for(int B = M-1-A; B > 0; B--)
                        {
                            System.out.print("_");
                        }

                        for(int B = 0; B <= A; B++)
                        {
                            if(B == 0||B == A)
                            {
                                System.out.print("*");
                            }
                            else
                            {
                                System.out.print(" ");
                            }
                        }

                        System.out.println();
                    }

                    for(int A = 0; A < M-1; A++)
                    {
                        for(int B = 0; B <= A; B++)
                        {
                            System.out.print("_");
                        }

                        for(int B = 0; B < M-1-A;B++)
                        {
                            if(B == 0 || A == M-1 || B == M-1-A-1)
                            {
                                System.out.print("*");
                            }
                            else
                            {
                                System.out.print(" ");
                            }
                        }

                        System.out.println();
                    }
                    break;
            }
        }
    }
}
