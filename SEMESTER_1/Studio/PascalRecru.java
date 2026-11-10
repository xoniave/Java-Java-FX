package SEMESTER_1.Studio;

import java.util.Scanner;
import java.util.ArrayList;
public class PascalRecru
{

    public static void pascal(ArrayList<Integer> Data,int Batas,int index)
    {
        if(index <= Batas)
        {
            if(index == 1)
            {
                System.out.print("1");
            }
            else if(index == 2)
            {
                System.out.print("1 1");
                Data.add(1);
                Data.add(1);
            }
            else
            {
                ArrayList<Integer> Temp = new ArrayList<>();
                for(int A = 0; A < Data.size(); A++)
                {
                    Temp.add(Data.get(A));
                }

                Data.clear();
                Data.add(1);
                for(int A = 0; A < Temp.size() - 1; A++)
                {
                    Data.add(Temp.get(A) + Temp.get(A+1));
                }
                Data.add(1);

                for(int A = 0; A < Data.size(); A++)
                {
                    if(A == Data.size() - 1)
                    {
                        System.out.print(Data.get(A));
                    }
                    else{
                        System.out.print(Data.get(A) + " ");
                    }
                }
            }

            System.out.println();
            pascal(Data,Batas,index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int Batas = scan.nextInt();

        ArrayList<Integer> Data = new ArrayList<>();

        int index = 1;
        pascal(Data,Batas,index);
    }



    // Index HASIL
    // 1      1
    // 2      1 1   [1,1]
    // 3      1 2 1  temp[1,1] clear data [1,2,1]
    // 4      1 3 3 1 temp [1,2,1] clear data [1,3,3,1]

}
