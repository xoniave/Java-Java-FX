package SEMESTER_1;

import java.util.ArrayList;
import java.util.Scanner;
public class test {
        public static void input1 (ArrayList <Integer> input, int n){
            Scanner scan = new Scanner(System.in);
            if (n >0){
                input.add(scan.nextInt());
                input1(input, n-1);
            }
        }

        public static boolean prima (int angka){
            int n = 0;

            for (int i = 1; i <= angka ; i++) {
                if (angka % i == 0){
                    n++;
                }
            }
            if (n == 2){
                return true;
            }
            return false;
        }

        public static void aaa (ArrayList <Integer> input, int n){
            if (n>0){
                aaa(input, n-1);
                if (prima(input.get(n-1))){
                    System.out.println(input.get(n-1));
                }

            }
        }

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            ArrayList <Integer> input = new ArrayList<>();
            input1(input, n);
            aaa(input,n);

        }
}
