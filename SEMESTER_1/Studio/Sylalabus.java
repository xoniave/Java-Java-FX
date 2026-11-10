package SEMESTER_1.Studio;

import java.util.Scanner;

public class Sylalabus {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int indexvokal = 0;;
            for (int i = input.length() - 1; i >= 0; i--) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'i' || input.charAt(i) == 'I' || input.charAt(i) == 'u' || input.charAt(i) == 'U' || input.charAt(i) == 'e' || input.charAt(i) == 'E' || input.charAt(i) == 'o' || input.charAt(i) == 'O') {
                    indexvokal = i;
                    break;
                }
            }
            for (int i = indexvokal; i < input.length(); i++){
                System.out.print(input.charAt(i));
            }

        }
}
