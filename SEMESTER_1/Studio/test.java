package SEMESTER_1.Studio;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String teks = scan.nextLine();

        teks = teks.replace("WUB"," ").trim();

        System.out.println(teks);
    }
}
