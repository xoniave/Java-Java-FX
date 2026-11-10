package SEMESTER_1.LES.UAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rekursif {

    public static void Sama(List<Integer> panjang, List<Integer> pendek, int idx, List<Integer> Output)
    {
        if(idx != pendek.size())
        {
            for(int A = 0; A < panjang.size(); A++)
            {
                if(pendek.get(idx) == panjang.get(A))
                {
                    boolean ada = false;

                    for(int B = 0; B < Output.size(); B++)
                    {
                        if(pendek.get(idx) == Output.get(B))
                        {
                            ada = true;
                            break;
                        }
                    }

                    if(!ada)
                    {
                        Output.add(pendek.get(idx));
                    }

                    break;
                }
            }
            Sama(panjang,pendek,idx + 1,Output);
        }
        else {
            for (int A = 0; A < Output.size(); A++)
            {
                System.out.print(Output.get(A) + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> ListA = new ArrayList<>();
        List<Integer> ListB = new ArrayList<>();
        List<Integer> Output = new ArrayList<>();

        int Panjang1 = scan.nextInt();
        int Panjang2 = scan.nextInt();

        for(int A = 0; A < Panjang1; A++)
        {
            ListA.add(scan.nextInt());
        }
        for(int B = 0; B < Panjang2; B++)
        {
            ListB.add(scan.nextInt());
        }

        int idx = 0;
        if(Panjang1 > Panjang2)
        {
            Sama(ListA,ListB,idx,Output);
        }
        else {
            Sama(ListB,ListA,idx,Output);
        }
    }
}
