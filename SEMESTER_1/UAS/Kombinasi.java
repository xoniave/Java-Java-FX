package SEMESTER_1.UAS;

import java.util.Arrays;
import java.util.Scanner;

public class Kombinasi {
    public static void PrintCombi(String ABC, int[] Biner) {
        String Temp = "";
        for(int A = 0; A < Biner.length; A++) {
            if(Biner[A] == 1) {
                Temp += ABC.charAt(A);
            }
        }
        System.out.println(Temp);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String ABC = "ABC";
        int[] Biner = new int[ABC.length()];

        //NGISI ARRAY DENGAN ANGKA 0
        for(int A = 0; A < ABC.length(); A++) {
            Biner[A] = 0;
        }

        int Min = 0;
        while (Min < ABC.length()) {
            if(Biner[(ABC.length() - 1) - Min] == 0) {
                Biner[(ABC.length() - 1) - Min] = 1;
                Min = 0;

                System.out.println(Arrays.toString(Biner));
                PrintCombi(ABC,Biner);
            }
            else if(Biner[(ABC.length() - 1) - Min] == 1){
                Biner[(ABC.length() - 1) - Min] = 0;
                Min++;
            }
        }
    }
}
