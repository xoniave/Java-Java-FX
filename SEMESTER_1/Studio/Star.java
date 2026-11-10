package SEMESTER_1.Studio;

import java.util.Scanner;

public class Star {
    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String kata = sc.next();
        int starLocate = 0;
        int count = 0;
        int starCounter = 0;
        if (input.contains("*")) {
            int x = input.length()-2;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '*') {
                    starCounter++;
                    starLocate = i;
                }
            }
            if (starCounter == 1) {
                if (starLocate == 0) {
                    for (int i = 1; i < input.length(); i++) {
                        if (input.charAt(i) == kata.charAt((kata.length() - 1) - x)) {
                            count++;
                            x--;
                        } else {
                            break;
                        }
                    }
                } else if (starLocate == input.length() - 1) {
                    for (int i = 0; i < input.length()-1; i++) {
                        if (input.charAt(i) == kata.charAt(i)) {
                            count++;
                            x--;
                        } else {
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < starLocate; i++) {
                        if (input.charAt(i) == kata.charAt(i)) {
                            count++;
                        } else {
                            break;
                        }
                        if (input.charAt((input.length() - 1) - i) == (kata.charAt(kata.length() - 1) - i)) {
                            count++;
                        } else {
                            break;
                        }
                    }
                }
                if (count == input.length()-1) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                System.out.println("error");
            }


        }
    }
}
