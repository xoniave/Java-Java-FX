package SEMESTER_1.UTS;

import java.util.Scanner;

public class Kelompok {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] Data = {{"Amanda Leonard", "Peggy vasquez","Broderick bridges"},
                           {"Deana Keith",    "Nita Huffman", "Long Cohen"},
                           {"Eloy Morris",    "Chard Larsen", "Lilly Logan",       "Silvia Baxter"},
                           {"Therese Miranda","Efrain burns", "Janna Carney"},
                           {"Vance Conley",   "Noble Daniel", "Jerrell Odonnell",  "Janette Murillo"}};

        String nama = "";
        System.out.println("Masukan Nama : ");
        nama = scan.nextLine();

        int Baris = 0;
        for(int A = 0; A < 5; A++)
        {
            for(int B = 0; B < Data[A].length; B++)
            {
                if(nama.equalsIgnoreCase(Data[A][B]))
                {
                    Baris = A;
                }
            }
        }

        for(int A = 0; A < Data[Baris].length; A++)
        {
            System.out.print( "(" + Data[Baris][A] + ") ");
        }


    }
}
