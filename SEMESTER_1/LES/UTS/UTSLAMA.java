package SEMESTER_1.LES.UTS;

import java.util.Scanner;

public class UTSLAMA {

    public static boolean isInsideOf(int x, int y, int left,int right,int bottom,int top)
    {

        if(x >= 3 && x <= 5 && y <= 5 && y >= 2 ) {
            System.out.println("Jawaban B");
            System.out.println("(" + x + ", " + y + ") ada di dalam kotak B");;
        }else if(x >= 7 && x <= 10 && y <= 5 && y >= 3 ){
            System.out.println("Jawaban B");
            System.out.println("(" + x + ", " + y + ") ada di dalam kotak C");;
        }else if(x >= 2 && x <= 9 && y <= 7 && y >= 1 ) {
            System.out.println("Jawaban B");
            System.out.println("(" + x + ", " + y + ") ada di dalam kotak A");;
        }else if(x >= 1 && x <= 4 && y <= 9 && y >= 6 ){
            System.out.println("Jawaban B");
            System.out.println("(" + x + ", " + y + ") ada di dalam kotak D");;
        }


        if (x >= left && x <= right && y <= top && y >= bottom) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int left = 2, right = 5, top = 8, bottom = 1;
        System.out.print("X: ");
        int x = input.nextInt();
        System.out.print("Y: ");
        int y = input.nextInt();

        if (isInsideOf(x,y,left,right,bottom,top))
        {
            System.out.println("Jawaban A");
            System.out.println("(" + x + ", " + y + ") ada di dalam kotak");;
        }
        else {
            System.out.println("Jawaban A");
            System.out.println("(" + x + ", " + y + ") tidak ada di dalam kotak");
        }

    }
}
