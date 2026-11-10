package SEMESTER_1.Studio;

import java.util.Scanner;

public class Prefix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        String Longest = "";
        for(int A = 0; A < n; A++)
        {
            String teks = scan.nextLine();
            if(A == 0)
            {
                Longest = teks;
            }
            else {
                String temp = "";
                if(Longest.length() < teks.length())
                {
                    for(int B = 0; B < Longest.length(); B++)
                    {
                        if(Longest.charAt(B) == teks.charAt(B))
                        {
                            temp += Longest.charAt(B);
                        }
                        else {
                            break;
                        }
                    }
                }
                else {
                    for(int B = 0; B < teks.length(); B++)
                    {
                        if(Longest.charAt(B) == teks.charAt(B))
                        {
                            temp += Longest.charAt(B);
                        }
                        else {
                            break;
                        }
                    }
                }
                Longest = temp;
            }
        }
        System.out.println(Longest);
    }
}

