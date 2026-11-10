package SEMESTER_1.UAS.ReviewUASshawn;

import java.util.Scanner;

public class StringManip_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int longest = 0;
        for (int i = 0; i < input.length(); i++) {
            String temp = "";
            for (int j = i; j < input.length(); j++) {
                if (!temp.contains(String.valueOf(input.charAt(j)))){
                    temp += input.charAt(j);
                } else break;
            }
            if (longest < temp.length()){
                longest = temp.length();
            }
        }
        System.out.println(longest);
    }
}
