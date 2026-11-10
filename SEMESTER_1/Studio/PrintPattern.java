package SEMESTER_1.Studio;

import java.util.Scanner;

public class PrintPattern {

    public static String Spasi(int A)
    {
        int turn = 1;
        String Temp = "";
        for(int B = 0; B < A; B++) {
            if(turn == 1) {
                System.out.print("*");
                Temp += "*";
                turn = 2;
            } else {
                System.out.print(" ");
                Temp += " ";
                turn = 1;
            }
        }
        return Temp;
    }

    public static void Reversed(String Temp)
    {
        for(int B = Temp.length()-1; B >= 0; B--){
            System.out.print(Temp.charAt(B));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int GanjilLayerd = 1;
        for(int I = 0; I < N-1; I++) {
            GanjilLayerd += 4;
        }

        int Batas = GanjilLayerd;
        int GenapLayerd = GanjilLayerd - 2;
        int Tengah = (int) Math.ceil((double) GanjilLayerd /2);
        for(int A = 0; A < Tengah; A++) {
            if(A % 2 == 0) {
                String Temp = Spasi(A);
                for(int B = 0; B < GanjilLayerd; B++) {
                    System.out.print("*");
                }

                Reversed(Temp);
                GanjilLayerd -= 4;
            }
            else {
                String Temp = Spasi(A);

                for(int B = 0; B < GenapLayerd; B++) {
                    System.out.print(" ");
                }

                Reversed(Temp);
                GenapLayerd-=4;
            }
            System.out.println();
        }

        GenapLayerd = 3;
        GanjilLayerd = 5;
        for(int A = Tengah-2; A >= 0; A--)
        {
            if(A % 2 == 0) {
                String Temp = Spasi(A);
                for(int B = 0; B < GanjilLayerd; B++) {
                    System.out.print("*");
                }

                Reversed(Temp);
                GanjilLayerd += 4;
            }
            else {
                String Temp = Spasi(A);

                for(int B = 0; B < GenapLayerd; B++) {
                    System.out.print(" ");
                }

                Reversed(Temp);
                GenapLayerd+=4;
            }
            System.out.println();
        }
    }
}
