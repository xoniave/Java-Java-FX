package SEMESTER_1.Studio;

import java.util.ArrayList;
import java.util.Scanner;

public class frekuensi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> Datakata = new ArrayList<>();
        ArrayList<Integer> JumlahKata = new ArrayList<>();

        String Teks = scan.nextLine();

        Teks += " ";
        String Temp = Teks.toLowerCase();

        String Output = "";
        for(int A = 0; A < Temp.length(); A++)
        {
            if(Temp.charAt(A) != '!' && Temp.charAt(A) != '.' && Temp.charAt(A) != ',' && Temp.charAt(A) != ' ') {
                Output+= Temp.charAt(A);
            }
            else {
                if(Output != "")
                {
                    if(Datakata.isEmpty())
                    {
                        Datakata.add(Output);
                        JumlahKata.add(1);
                    }
                    else {
                        boolean Ada = false;
                        for (int B = 0; B < Datakata.size(); B++)
                        {
                            if(Datakata.get(B).equalsIgnoreCase(Output))
                            {
                                Ada = true;
                                JumlahKata.set(B,JumlahKata.get(B)+1);
                                break;
                            }
                        }
                        if(!Ada)
                        {
                            Datakata.add(Output);
                            JumlahKata.add(1);
                        }
                    }
                    Output = "";
                }
            }
        }

        for(int A = 0; A < Datakata.size(); A++)
        {
            if(A == Datakata.size()-1)
            {
                System.out.print(Datakata.get(A) + ": " + JumlahKata.get(A));
            }
            else {
                System.out.println(Datakata.get(A) + ": " + JumlahKata.get(A));
            }
        }
    }
}
