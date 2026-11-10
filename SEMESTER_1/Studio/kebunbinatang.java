package SEMESTER_1.Studio;

import java.util.Scanner;

public class kebunbinatang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ukuran = scan.nextInt();
        int[] array = new int[ukuran*2];
        for (int i = 0; i < ukuran; i++) {
            int temp = scan.nextInt();
            array[i] = temp;
            array[i+ukuran] = temp;
        }
        int m = scan.nextInt();
        m *= scan.nextInt();
        int loop = m % ukuran;
        if (loop != 0){
            loop++;
        }
        for (int i = 0; i < array.length/2; i++) {
            System.out.print(array[i+loop] + " ");
        }
    }
}